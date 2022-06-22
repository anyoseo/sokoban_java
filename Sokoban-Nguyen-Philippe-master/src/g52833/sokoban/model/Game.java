package g52833.sokoban.model;

import g52833.sokoban.util.Observable;
import g52833.sokoban.util.Observer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the facede of the game.
 *
 * @author G52833
 */
public class Game implements Observable {

    private Dungeon dungeon;
    private Player player;
    private String level;
    private CommandManager commandManager;
    private XsbReader xsbReader;
    private List<Observer> observers = new ArrayList<>();

    /**
     * Constructor of the class Game.
     *
     */
    public Game() {
        this.dungeon = new Dungeon();
        commandManager = new CommandManager();
        xsbReader = new XsbReader();
    }

    /**
     * Getter of the attribute level.
     *
     * @return the level of the game.
     */
    public String getLevel() {
        return level;
    }

    public void loadLevel(String level) throws IOException {
        player = xsbReader.loadLevel(dungeon, level);
        this.level = level;
        restart();
        notifyObservers();
    }

    /**
     * Method which gets the entity at the given square's position.
     *
     * @param x the abciss of the square.
     * @param y the ordinate of the square.
     * @return the entity of the square.
     */
    public Entity getEntity(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Parameters must be positive");
        }
        return dungeon.getEntity(new Position(x, y));
    }

    /**
     * Method which gets the square at the given position.
     *
     * @param x the abciss of the square.
     * @param y the ordinate of the square.
     * @return the square at the given position.
     */
    public Square getSquare(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Parameters must be positive");
        }
        return dungeon.getSquare(new Position(x, y));
    }

    /**
     * Method which gets the length of the dungeon.
     *
     * @return the lenght of the dungeon.
     */
    public int dungeonLength() {
        return dungeon.getWidth();
    }

    /**
     * Method which resets all the attribute.
     *
     */
    public void resetAll() {
        restart();
        level = null;
        notifyObservers();
    }

    /**
     * Method which resets the undo and reso stacks.
     */
    public void restart() {
        commandManager.resetStacks();
    }

    /**
     * Method which moves a player towards a direction.
     *
     * @param direction the direction to move to.
     */
    public void move(Direction direction) {
        Position nextPosition = player.getPosition().next(direction);
        List<Entity> list = new ArrayList<>();
        if (!(dungeon.getSquare(nextPosition) instanceof Wall)) {
            if (player.canMove(direction, dungeon)) {
                list.add(player);
                MoveCommand command = new MoveCommand(dungeon, direction, list);
                if (dungeon.getEntity(nextPosition) instanceof Box) {
                    list.add(dungeon.getEntity(nextPosition));
                }
                commandManager.doCommand(command);
                notifyObservers();
            }
        }
    }

    /**
     * Method which checks if a level is completed.
     *
     * @return true if it's completed else false.
     */
    public boolean levelComplete() {
        for (int i = 0; i < dungeon.getWidth(); i++) {
            for (int j = 0; j < dungeon.getHeight(); j++) {
                if ((dungeon.getSquare(new Position(i, j)).getEntity() == null
                        || dungeon.getSquare(new Position(i, j)).getEntity() instanceof Player)
                        && dungeon.getSquare(new Position(i, j)) instanceof Storage) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method which gives the number of objectives on the board.
     *
     * @return the number of objectives.
     */
    public int objectif() {
        int nbObjectif = 0;
        for (int i = 0; i < dungeon.getWidth(); i++) {
            for (int j = 0; j < dungeon.getHeight(); j++) {
                if (dungeon.getSquare(new Position(i, j)) instanceof Storage) {
                    nbObjectif++;
                }
            }
        }
        return nbObjectif;
    }

    /**
     * Method which gives the number of objectives reached on the board.
     *
     * @return the number of objectives reached.
     */
    public int objectifReached() {
        int nbObjectifReached = 0;
        for (int i = 0; i < dungeon.getWidth(); i++) {
            for (int j = 0; j < dungeon.getHeight(); j++) {
                if (dungeon.getSquare(new Position(i, j)) instanceof Storage
                        && dungeon.getEntity(new Position(i, j)) instanceof Box) {
                    nbObjectifReached++;
                }
            }
        }
        return nbObjectifReached;
    }

    /**
     * Method which gets the list of the undo stack's element.
     *
     * @return a list of MoveCommand.
     */
    public List<MoveCommand> historyUndo() {
        return commandManager.undoList();
    }

    /**
     * Method which gets the list of the redo stack's element.
     *
     * @return a list of MoveCommand.
     */
    public List<MoveCommand> historyRedo() {
        return commandManager.redoList();
    }

    /**
     * Method which gets the number of moves done.
     *
     * @return an integer which is the number of moves.
     */
    public int nbMoves() {
        return commandManager.numberMove();
    }

    /**
     * Method which undoes a move.
     */
    public void undo() {
        commandManager.undo();
        notifyObservers();
    }

    /**
     * Method which redoes a move undone.
     */
    public void redo() {
        commandManager.redo();
        notifyObservers();
    }

    /**
     * This method allows to notify all the Observers.
     */
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * This method allows to add an Observer.
     *
     * @param obs is an Observer.
     */
    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    /**
     * This method allows to remove an Observer.
     *
     * @param obs is an Observer.
     */
    @Override
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }
}
