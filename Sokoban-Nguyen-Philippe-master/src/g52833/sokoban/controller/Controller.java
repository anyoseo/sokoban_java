package g52833.sokoban.controller;

import g52833.sokoban.model.Direction;
import g52833.sokoban.model.Game;
import g52833.sokoban.view.View;
import java.io.IOException;

/**
 * This class represents the controller of the game.
 *
 * @author G52833
 */
public class Controller {

    private Game game;
    private View view;

    /**
     * Constructor of the class Controller
     *
     * @param game the value to initialize the class's attribute game.
     * @param view the value to initialize the class's attribute view.
     */
    public Controller(Game game, View view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Method which starts the game.
     */
    public void start() {
        String command = "";
        boolean selected = false;
        while (!selected && !command.equals("exit")) {
            System.out.println("=======================\n"
                    + "Sélectionner un niveau");
            command = view.askCommand();
            if (command.matches("load\\s\\d+")) {
                String[] load = command.split(" ");
                selected = loadCommand(load);
            } else if (command.matches("help")) {
                view.displayHelp();
            }
            if (selected == true) {
                while (!command.equals("exit") && !command.equals("surrend")) {
                    applyCommand(command);
                    view.displayBoard();
                    if (game.levelComplete()) {
                        view.displayMessage("Félicitations niveau complété !");
                        command = "surrend";
                    } else {
                        command = view.askCommand();
                    }
                }
                selected = false;
                game.resetAll();
            }
        }
    }

    /**
     * Method which apply the command entered.
     *
     * @param command the command entered.
     * @return the command entered.
     */
    public String applyCommand(String command) {
        if (!command.equals("exit")) {
            String[] tab = command.split(" ");
            switch (tab[0]) {
                case "load":
                    loadCommand(tab);
                    break;
                case "z": //@srv constantes.
                    applyMove(Direction.UP);
                    break;
                case "q":
                    applyMove(Direction.LEFT);
                    break;
                case "d":
                    applyMove(Direction.RIGHT);
                    break;
                case "s":
                    applyMove(Direction.DOWN);
                    break;
                case "restart": {
                    try {
                        game.loadLevel(game.getLevel());
                    } catch (IOException ex) {
                        view.displayMessage("Le niveau ne peut pas être"
                                + " chargé");
                    }
                    break;
                }
                case "undo":
                    game.undo();
                    break;
                case "redo":
                    game.redo();
                    break;
                case "help":
                    view.displayHelp();
                    break;
            }
        }
        return command;
    }

    /**
     * Method which load the level asked.
     *
     * @param tab the array which contains the command and the level.
     * @return boolean true if the level was loaded else false.
     */
    public boolean loadCommand(String[] tab) {
        try {
            game.loadLevel(tab[1]);
            return true;
        } catch (IOException ioe) {
            view.displayMessage("Le niveau n'existe pas");
            return false;
        }
    }

    /**
     * Method which apply the move.
     *
     * @param direction the direction to move to.
     */
    public void applyMove(Direction direction) {
        game.move(direction);
    }
}
