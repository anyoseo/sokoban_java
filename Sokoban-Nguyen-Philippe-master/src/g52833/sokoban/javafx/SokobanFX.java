package g52833.sokoban.javafx;

import g52833.sokoban.model.Direction;
import g52833.sokoban.model.Game;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Method which represents the game's part.
 *
 * @author Binh-Philippe
 */
public class SokobanFX extends HBox {

    private HBox hbox;
    private InfoFX infoFX;
    private Game game;
    private BoardFX boardFX;
    private AlertWin alert;

    /**
     * Constructor of the class SokobanFX.
     *
     * @param level the level to load.
     * @param stage the main stage of the game.
     * @param scene the old scene to switch to.
     * @throws IOException
     */
    SokobanFX(String level, Stage stage, Scene scene) throws IOException {
        game = new Game();
        boardFX = new BoardFX(game, level);
        infoFX = new InfoFX(game, stage, scene);
        hbox = new HBox(boardFX, infoFX);
        hBoxGpAlignementBackground();
    }

    /**
     * Getter for the attribute hbox.
     *
     * @return
     */
    HBox getHbox() {
        return this.hbox;
    }

    /**
     * Method which sets the aligmnement and the background of the attribute
     * hbox.
     */
    private void hBoxGpAlignementBackground() {
        BackgroundFill background_fill = new BackgroundFill(Color.rgb(0, 0, 0),
                CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);

        hbox.setSpacing(100);
        hbox.setPadding(new Insets(100));
        hbox.setAlignment(Pos.CENTER);
        hbox.setBackground(background);
    }

    /**
     * Method which checks if a level is completed if so disable all events and
     * returns to the main menu.
     *
     * @param stage the main stage of the game.
     * @param mainMenu the main menu to go back to.
     * @param key the event to disable once the level is complete
     */
    void levelCompleted(Stage stage, Scene mainMenu, EventHandler<KeyEvent> key) {
        if (game.levelComplete()) {
            infoFX.setDisable(true);
            mainMenu.removeEventHandler(KeyEvent.KEY_PRESSED, key);
            backMainMenuOver(stage, mainMenu);
        }
    }

    /**
     * Method which goes back to the main menu once the button is clicked.
     *
     * @param stage the main stage of the game.
     * @param mainMenu the main menu to go back to.
     */
    public void backMainMenuOver(Stage stage, Scene mainMenu) {
        alert = new AlertWin(Alert.AlertType.CONFIRMATION);
        if (alert.buttonMainMenuClicked()) {
            stage.setScene(mainMenu);
        }

    }

    /**
     * Method which reads the keyboard input and moves the player of the
     * dungeon.
     *
     * @param mainMenu the main menu to go back to.
     * @param gameScene the game scene to activate the key event.
     * @param stage the main stage of the game.
     */
    void move(Scene mainMenu, Scene gameScene, Stage stage) {
        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent key) {
                switch (key.getCode()) {
                    case Z:
                        game.move(Direction.UP);
                        break;
                    case S:
                        game.move(Direction.DOWN);
                        break;
                    case Q:
                        game.move(Direction.LEFT);
                        break;
                    case D:
                        game.move(Direction.RIGHT);
                        break;
                    default:
                        break;
                }
                levelCompleted(stage, mainMenu, this);
            }
        });
    }

}
