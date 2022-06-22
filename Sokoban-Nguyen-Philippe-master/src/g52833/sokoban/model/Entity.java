package g52833.sokoban.model;

import java.util.Objects;

/**
 * This class represents an entity.
 *
 * @author G52833
 */
public class Entity {

    protected Position position;

    /**
     * Constructor of the class Entity.
     *
     * @param position the value to initialize the attribute position.
     */
    Entity(Position position) {
        if (position == null) {
            throw new NullPointerException("Position cannot be null");
        }
        this.position = position;
    }

    /**
     * Getter for the attribute position.
     *
     * @return the attribute position.
     */
    Position getPosition() {
        return position;
    }

    /**
     * Method which moves the position to the given direction.
     *
     * @param direction the direction to move to.
     */
    void move(Direction direction) {
        position.move(direction);
    }

    /**
     * Method which checks if an entity can move.
     *
     * @param dir the direction to move to.
     * @param dungeon the dungeon of the game.
     * @return true if it can move else false.
     */
    boolean canMove(Direction dir, Dungeon dungeon) {
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        final Entity other = (Entity) obj;
        if (!Objects.equals(this.position, other.position)
                || getClass() != obj.getClass() || obj == null) {
            return false;
        }
        return true;
    }

}
