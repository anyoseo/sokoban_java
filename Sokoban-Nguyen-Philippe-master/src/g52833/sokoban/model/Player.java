package g52833.sokoban.model;

/**
 * This class represents the player on the dungeon.
 *
 * @author G52833
 */
public class Player extends Entity {

    /**
     * Constructor of the class Player.
     *
     * @param position the position of the player.
     */
    Player(Position position) {
        super(position);
    }

    /**
     * Method which checks if the player can move.
     *
     * @param dir the direction to move to.
     * @param dungeon the dungeon of the game.
     * @return true if it can move else false.
     */
    @Override
    boolean canMove(Direction dir, Dungeon dungeon) {
        if (dungeon.getEntity(position.next(dir)) instanceof Box) {
            if (!dungeon.getEntity(position.next(dir)).canMove(dir, dungeon)) {
                return false;
            }
        }
        return true;
    }

}
