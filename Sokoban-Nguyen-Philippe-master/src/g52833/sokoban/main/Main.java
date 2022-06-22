package g52833.sokoban.main;

import g52833.sokoban.controller.Controller;
import g52833.sokoban.model.Game;
import g52833.sokoban.view.View;

/**
 * This class represents the main for the game.
 *
 * @author G52833
 */
public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        View view = new View(game);
        Controller controller = new Controller(game, view);
        controller.start();
    }

}
