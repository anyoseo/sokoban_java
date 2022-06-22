package g52833.sokoban.view;

import g52833.sokoban.model.Box;
import g52833.sokoban.model.Floor;
import g52833.sokoban.model.Game;
import g52833.sokoban.model.Player;
import g52833.sokoban.model.Storage;
import g52833.sokoban.model.Wall;
import java.util.Scanner;

/**
 * This class represents the view of the game.
 *
 * @author G52833
 */
public class View {

    private Scanner in = new Scanner(System.in);
    private Game game;
    private final char PLAYER = '@';
    private final char FLOOR = ' ';
    private final char WALL = '#';
    private final char BOXSTORED = '*';
    private final char BOX = '$';
    private final char STORAGE = '.';
    private final char PLAYERSTORE = '+';

    /**
     * The constructor of the class View.
     *
     * @param game
     */
    public View(Game game) {
        this.game = game;
    }

    /**
     * Method which asks to enter a command.
     *
     * @return the command entered.
     */
    public String askCommand() {
        System.out.println("Tapez 'help' pour afficher les commandes "
                + "possibles");
        System.out.print("=======================\nEntrez une commande : ");
        String command = in.nextLine();
        System.out.println();
        return command;
    }

    /**
     * Method which displays the dungeon selected.
     */
    public void displayBoard() {
        String board = "";
        System.out.println("Vous êtes à " + game.nbMoves() + " mouvements\n");
        for (int i = 0; i < game.dungeonLength(); i++) {
            for (int j = 0; j < game.dungeonLength(); j++) {
                if (game.getSquare(i, j) instanceof Wall) {
                    board += WALL; //@srv constantes.

                } else if (game.getSquare(i, j) instanceof Storage
                        && game.getEntity(i, j) instanceof Player) {
                    board += PLAYERSTORE;

                } else if (game.getSquare(i, j) instanceof Storage
                        && game.getEntity(i, j) instanceof Box) {
                    board += BOXSTORED;

                } else if (game.getSquare(i, j) instanceof Storage) {
                    board += STORAGE;

                } else if (game.getEntity(i, j) instanceof Box) {
                    board += BOX;

                } else if (game.getEntity(i, j) instanceof Player) {
                    board += PLAYER;

                } else if (game.getSquare(i, j) instanceof Floor
                        && game.getEntity(i, j)
                        == null) {
                    board += FLOOR;
                }
                board += FLOOR;
            }
            board += "\n";
        }
        System.out.println(board);
    }

    /**
     * Method which displays the game's command.
     */
    public void displayHelp() {
        System.out.println("'load [level]' pour charger un niveau.");
        System.out.println("'exit' pour quitter le jeu.");
        System.out.println("'z' pour se déplacer vers le haut.");
        System.out.println("'s' pour se déplacer vers le bas.");
        System.out.println("'q' pour se déplacer vers la gauche.");
        System.out.println("'d' pour se déplacer vers la droite.");
        System.out.println("'undo' pour annuler un déplacement.");
        System.out.println("'redo' pour re-exécuter un déplacement annulé.");
        System.out.println("'surrend' pour abandonner le niveau.\n");

    }

    /**
     * Method which displays the given message.
     *
     * @param msg the message to display.
     */
    public void displayMessage(String msg) {
        System.out.println(msg);
    }
}
