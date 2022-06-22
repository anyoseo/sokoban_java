package g52833.sokoban.model;

/**
 * This class represents a box.
 *
 * @author Binh-Philippe
 */
public class Box extends Entity {

    /**
     * Constructor for the class Box.
     *
     * @param position the position of the box.
     */
    Box(Position position) {
        super(position);
    }

    /**
     * Method which checks if a box can move.
     *
     * @param dir the direction to move to.
     * @param dungeon the dungeon of the game.
     * @return true if it can move else false.
     */
    @Override
    boolean canMove(Direction dir, Dungeon dungeon) {
        if (dungeon.getEntity(position.next(dir)) instanceof Box
                || dungeon.getSquare(position.next(dir)) instanceof Wall) {
            return false;
        }
        return true;
    }

}
