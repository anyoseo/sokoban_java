package g52833.sokoban.javafx;

import java.io.IOException;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This class represents the main of the game in javafx.
 *
 * @author Binh-Philippe
 */
public class MainFX extends Application {

    private VBox vbox;
    private ChoiceBox<Integer> cbLevel;
    private GridPane menu;
    private Button startButton;
    private SokobanFX sokobanFX;
    private Scene mainMenu;
    private Scene gameScene;

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.vbox = new VBox();
        mainMenu = new Scene(vbox, 1200, 800);
        menuStart();
        start();
        backgroundColorVBox();
        primaryStage.setTitle("Sokoban");
        primaryStage.setScene(mainMenu);
        primaryStage.setResizable(false);
        primaryStage.show();
        clickedStartButton(mainMenu, primaryStage);
    }

    /**
     * Method which changes the color and the positionning in th vbox.
     */
    private void backgroundColorVBox() {
        BackgroundFill background_fill = new BackgroundFill(Color.rgb(0, 0, 0),
                CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        vbox.setPadding(new Insets(80));
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setBackground(background);
    }

    /**
     * Method which creates and configures the menu.
     */
    private void menuStart() {
        menu = new GridPane();
        menu.setVgap(10);
        menu.setHgap(10);
        menu.setAlignment(Pos.CENTER);
        choiceBoxLevel();

        vbox.getChildren().addAll(welcomeMessage(), menu);
    }

    /**
     * Method which creates the label of welcome.
     *
     * @return
     */
    private Label welcomeMessage() {
        Label lblWelcomeMsg = new Label("SOKOBAN");
        lblWelcomeMsg.setTextFill(Color.RED);
        lblWelcomeMsg.setFont(new Font("Times New Roman", 150));
        lblWelcomeMsg.setPrefHeight(300);
        menu.add(lblWelcomeMsg, 0, 0);

        return lblWelcomeMsg;
    }

    /**
     * Method which creates the choice box for the level to select.
     */
    private void choiceBoxLevel() {
        Label lblLevel = new Label("Choisir un niveau :");
        lblLevel.setTextFill(Color.WHITE);
        lblLevel.setFont(new Font("Times New Roman", 35));
        GridPane.setHalignment(lblLevel, HPos.RIGHT);
        menu.add(lblLevel, 0, 4);

        cbLevel = new ChoiceBox<>();
        for (int i = 0; i <= 10; i++) {
            cbLevel.getItems().add(i);
        }
        cbLevel.setPrefWidth(75);
        menu.add(cbLevel, 1, 4);
        cbLevel.getSelectionModel().selectFirst();
    }

    /**
     * Method which creates and configures the button start.
     */
    private void start() {
        startButton = new Button("START");
        startButton.setFont(new Font("Times New Roman", 20));
        startButton.setPrefSize(100, 40);
        GridPane.setHalignment(startButton, HPos.CENTER);
        menu.add(startButton, 0, 12);
    }

    /**
     * Method which changes the scene if the button start is clicked.
     *
     * @param mainMenu the main menu of the stage.
     * @param primaryStage the stage of the game.
     */
    private void clickedStartButton(Scene mainMenu, Stage primaryStage) {
        startButton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    sokobanFX = new SokobanFX(Integer.toString(cbLevel.getValue()), primaryStage, mainMenu);
                    gameScene = new Scene(sokobanFX.getHbox(), 1200, 800);
                    primaryStage.setScene(gameScene);
                    sokobanFX.move(mainMenu, gameScene, primaryStage);
                } catch (IOException ex) {
                    System.out.println("File's not found");
                }
            }
        });

    }

}
