package g52833.sokoban.javafx;

import g52833.sokoban.model.Game;
import g52833.sokoban.model.MoveCommand;
import g52833.sokoban.util.Observer;
import java.io.IOException;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This class represents the infos of the current game.
 *
 * @author Binh-Philippe
 */
public class InfoFX extends VBox implements Observer {

    private Button undo;
    private Button redo;
    private Button restart;
    private Button surrend;
    private HBox undoRedo;
    private GridPane gPnbMoves;
    private GridPane gPObjectif;
    private VBox undoHistoric;
    private VBox redoHistoric;
    private Label nbMoves;
    private Label nbObjectifReached;
    private Game game;

    /**
     * Constructor of the class InfoFX.
     *
     * @param game the value to initialize the attribute game.
     * @param stage the stage of the game.
     * @param scene the scene to switch to.
     */
    InfoFX(Game game, Stage stage, Scene scene) {
        this.game = game;
        createConfigureUndoRedoHistoric();
        countMoves();
        nbObjectifs();
        createButtons();
        createUndoHistoric();
        createRedoHistoric();
        Label lblUndoHistoric = new Label("Coups précédents :");
        lblUndoHistoric.setTextFill(Color.WHITE);
        lblUndoHistoric.setFont(new Font("Times New Roman", 25));
        Label lblRedoHistoric = new Label("Coups annulés :");
        lblRedoHistoric.setTextFill(Color.WHITE);
        lblRedoHistoric.setFont(new Font("Times New Roman", 25));
        getChildren().addAll(lblUndoHistoric, undoHistoric, lblRedoHistoric,
                redoHistoric);
        vBoxPositionning();
        setActionOnButtons(stage, scene);
        this.game.addObserver(this);

    }

    /**
     * Method which creates and configures the attribute undoHistoric and
     * redoHistoric.
     */
    private void createConfigureUndoRedoHistoric() {
        undoHistoric = new VBox();
        undoHistoric.setPrefHeight(45);
        redoHistoric = new VBox();
        redoHistoric.setPrefHeight(45);
    }

    /**
     * Method which sets the differents actions to activate on the buttons.
     *
     * @param stage the stage of the game.
     * @param scene the scene to switch to.
     */
    private void setActionOnButtons(Stage stage, Scene scene) {
        clickedUndoButton();
        clickedRedoButton();
        clickedRestartButton();
        clickedGiveUpButton(stage, scene);
    }

    /**
     * Method which creates and configures all the buttons.
     */
    private void createButtons() {
        this.undo = new Button("UNDO");
        this.redo = new Button("REDO");
        this.restart = new Button("RECOMMENCER");
        this.surrend = new Button("ABANDONNER");
        undo.setFont(new Font("Times New Roman", 20));
        redo.setFont(new Font("Times New Roman", 20));
        restart.setFont(new Font("Times New Roman", 20));
        surrend.setFont(new Font("Times New Roman", 20));
        undo.setPrefSize(150, 40);
        redo.setPrefSize(150, 40);
        restart.setPrefSize(310, 40);
        surrend.setPrefSize(310, 40);
        this.undoRedo = new HBox(undo, redo);
        getChildren().addAll(undoRedo, restart, surrend);
    }

    /**
     * Method which sets the spacing of the undo and redo buttons and the vbox.
     */
    private void vBoxPositionning() {
        undoRedo.setSpacing(10);
        setSpacing(25);
    }

    /**
     * Method which creates the Grid Pane and the label for the counting of the
     * numbers of moves that the player has done.
     */
    private void countMoves() {
        Label moves = new Label("Déplacements :");
        nbMoves = new Label(String.valueOf(game.nbMoves()));
        gPnbMoves = new GridPane();
        gPnbMoves.add(moves, 0, 0);
        gPnbMoves.add(nbMoves, 1, 0);
        gPnbMoves.setHgap(10);
        moves.setTextFill(Color.WHITE);
        moves.setFont(new Font("Times New Roman", 25));
        nbMoves.setTextFill(Color.WHITE);
        nbMoves.setFont(new Font("Times New Roman", 25));
        getChildren().add(gPnbMoves);
    }

    /**
     * Method which creates the Grid Pane for the numbers of objectives that the
     * player has completed.
     */
    private void nbObjectifs() {
        Label objectif = new Label("Objectifs : ");
        nbObjectifReached = new Label(String.valueOf(game.objectifReached()));
        Label goals = new Label("/" + String.valueOf(game.objectif()));
        gPObjectif = new GridPane();
        gPObjectif.add(objectif, 0, 0);
        gPObjectif.add(nbObjectifReached, 1, 0);
        gPObjectif.add(goals, 2, 0);
        objectif.setTextFill(Color.WHITE);
        objectif.setFont(new Font("Times New Roman", 25));
        nbObjectifReached.setTextFill(Color.WHITE);
        nbObjectifReached.setFont(new Font("Times New Roman", 25));
        goals.setTextFill(Color.WHITE);
        goals.setFont(new Font("Times New Roman", 25));
        getChildren().add(gPObjectif);
    }

    /**
     * Method which creates an event on the undo button for the undo action.
     */
    private void clickedUndoButton() {
        undo.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                game.undo();
            }
        });
    }

    /**
     * Method which creates an event on the redo button for the redo action.
     */
    private void clickedRedoButton() {
        redo.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                game.redo();
            }
        });
    }

    /**
     * Method which creates an event on the restart button for the restart
     * action.
     */
    private void clickedRestartButton() {
        restart.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    game.restart();
                    game.loadLevel(game.getLevel());
                } catch (IOException ex) {
                }
            }
        });
    }

    /**
     * Method which creates an event on the giveUp button for the surrend
     * action.
     *
     * @param stage the stage of the game.
     * @param scene the scene to switch to.
     */
    private void clickedGiveUpButton(Stage stage, Scene scene) {
        surrend.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setScene(scene);
            }
        });
    }

    /**
     * Method which creates the historic of the undo stack.
     */
    private void createUndoHistoric() {
        List<MoveCommand> undoList = game.historyUndo();
        Label first;
        undoHistoric.getChildren().clear();
        for (int i = 0; i < undoList.size(); i++) {
            first = new Label();
            first.setTextFill(Color.WHITE);
            first.setFont(new Font("Times New Roman", 20));
            if (undoList.get(i).getList().size() < 2) {
                first.setText("Joueur");
            } else {
                first.setText("Joueur et Boîte");
            }
            switch (undoList.get(i).getDirection()) {
                case UP:
                    first.setText(first.getText() + " - HAUT");
                    break;
                case DOWN:
                    first.setText(first.getText() + " - BAS");
                    break;
                case LEFT:
                    first.setText(first.getText() + " - GAUCHE");
                    break;
                case RIGHT:
                    first.setText(first.getText() + " - DROITE");
                    break;
            }
            undoHistoric.getChildren().add(first);
        }
    }

    /**
     * Method which creates the historic of the redo stack.
     */
    private void createRedoHistoric() {
        List<MoveCommand> redoList = game.historyRedo();
        Label first;
        redoHistoric.getChildren().clear();
        for (int i = 0; i < redoList.size(); i++) {
            first = new Label();
            first.setTextFill(Color.WHITE);
            first.setFont(new Font("Times New Roman", 20));
            if (redoList.get(i).getList().size() < 2) {
                first.setText("Joueur");
            } else {
                first.setText("Joueur et Boîte");
            }
            switch (redoList.get(i).getDirection()) {
                case UP:
                    first.setText(first.getText() + " - HAUT");
                    break;
                case DOWN:
                    first.setText(first.getText() + " - BAS");
                    break;
                case LEFT:
                    first.setText(first.getText() + " - GAUCHE");
                    break;
                case RIGHT:
                    first.setText(first.getText() + " - DROITE");
                    break;
            }
            redoHistoric.getChildren().add(first);
        }
    }

    /**
     * Method which refreshes the number of moves that the player has done.
     */
    private void refreshNbMoves() {
        nbMoves.setText(String.valueOf(game.nbMoves()));
    }

    /**
     * Method which refreshes the number of objectives that the player has
     * reached.
     */
    private void refreshNbObjectifReached() {
        nbObjectifReached.setText(String.valueOf(game.objectifReached()));
    }

    @Override
    public void update() {
        refreshNbMoves();
        refreshNbObjectifReached();
        createUndoHistoric();
        createRedoHistoric();
    }
}
