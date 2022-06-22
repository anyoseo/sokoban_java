package g52833.sokoban.javafx;

import g52833.sokoban.model.Box;
import g52833.sokoban.model.Game;
import g52833.sokoban.model.Player;
import g52833.sokoban.model.Storage;
import g52833.sokoban.model.Wall;
import g52833.sokoban.util.Observer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.HPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * This class represents the board.
 *
 * @author Binh-Philippe
 */
public class BoardFX extends GridPane implements Observer {

    private Game game;
    private ImageView img;
    private ImageView player;
    private List<ImageView> boxes = new ArrayList<>();
    private List<ImageView> boxesOnStorage = new ArrayList<>();
    private Image imgWall;
    private Image imgStorage;
    private Image imgBoxStorage;
    private Image imgPlayer;
    private Image imgBox;

    /**
     * Constructor of the class BoardFX.
     *
     * @param game the game value to initialize the attribute game.
     * @param level the level value to initialize the attribute level.
     * @throws IOException if the file was not found.
     */
    public BoardFX(Game game, String level) throws IOException {
        this.game = game;
        this.game.loadLevel(level);
        initializeImage();
        createBoard();
        game.addObserver(this);
    }

    /**
     * Method which initializes the differents images.
     *
     * @throws FileNotFoundException if the file is not found.
     */
    public void initializeImage() throws FileNotFoundException {

        FileInputStream fileWall = new FileInputStream("ressources/wall.jpg");
        imgWall = new Image(fileWall);

        FileInputStream fileBoxStorage = new FileInputStream("ressources/boxstorage.png");
        imgBoxStorage = new Image(fileBoxStorage);

        FileInputStream fileStorage = new FileInputStream("ressources/storage.png");
        imgStorage = new Image(fileStorage);

        FileInputStream filePlayer = new FileInputStream("ressources/player.png");
        imgPlayer = new Image(filePlayer);

        FileInputStream fileBox = new FileInputStream("ressources/box.png");
        imgBox = new Image(fileBox);

    }

    /**
     * Method which creates all the board.
     *
     */
    private void createBoard() {
        createWallAndStorage();
        createBox();
        createBoxWithStorage();
        createPlayer();

    }

    /**
     * Method which creates the walls and the storages for the board.
     *
     */
    private void createWallAndStorage() {
        for (int i = 0; i < game.dungeonLength(); i++) {
            for (int j = 0; j < game.dungeonLength(); j++) {
                if (game.getSquare(i, j) instanceof Wall) {
                    img = new ImageView(imgWall);
                    img.setPreserveRatio(true);
                    img.setFitHeight(60);
                    img.setFitWidth(60);
                    add(img, j, i);
                } else if (game.getSquare(i, j) instanceof Storage) {
                    img = new ImageView(imgStorage);
                    img.setPreserveRatio(true);
                    img.setFitHeight(25);
                    img.setFitWidth(25);
                    add(img, j, i);
                    setHalignment(img, HPos.CENTER);

                }
            }
        }
    }

    /**
     * Method which creates the boxes on the storages for the board.
     */
    private void createBoxWithStorage() {
        for (int i = 0; i < game.dungeonLength(); i++) {
            for (int j = 0; j < game.dungeonLength(); j++) {
                if (game.getSquare(i, j) instanceof Storage
                        && game.getEntity(i, j) instanceof Box) {
                    ImageView boxOnStorage = new ImageView(imgBoxStorage);
                    boxOnStorage.setPreserveRatio(true);
                    boxOnStorage.setFitHeight(60);
                    boxOnStorage.setFitWidth(60);
                    add(boxOnStorage, j, i);
                    boxesOnStorage.add(boxOnStorage);

                }
            }
        }
    }

    /**
     * Method which creates the player for the game's board.
     */
    private void createPlayer() {
        for (int i = 0; i < game.dungeonLength(); i++) {
            for (int j = 0; j < game.dungeonLength(); j++) {
                if (game.getEntity(i, j) instanceof Player) {
                    player = new ImageView(imgPlayer);
                    player.setPreserveRatio(true);
                    player.setFitHeight(60);
                    player.setFitWidth(60);
                    add(player, j, i);
                    setHalignment(player, HPos.CENTER);
                }
            }
        }
    }

    /**
     * Method which creates the boxes for the game's board.
     */
    private void createBox() {
        for (int i = 0; i < game.dungeonLength(); i++) {
            for (int j = 0; j < game.dungeonLength(); j++) {
                if (game.getEntity(i, j) instanceof Box) {
                    ImageView box = new ImageView(imgBox);
                    box.setPreserveRatio(true);
                    box.setFitHeight(60);
                    box.setFitWidth(60);
                    add(box, j, i);
                    boxes.add(box);
                }
            }
        }
    }

    /**
     * Method which refreshes the game's board.
     */
    private void refreshBoard() {
        getChildren().removeAll(boxes);
        getChildren().removeAll(boxesOnStorage);
        getChildren().remove(player);
    }

    @Override
    public void update() {
        refreshBoard();
        createBox();
        createBoxWithStorage();
        createPlayer();

    }

}
