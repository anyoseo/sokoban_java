package g52833.sokoban.model;

/**
 * This class represents a position.
 *
 * @author G52833
 */
public class Position {

    private int x;
    private int y;

    /**
     * Constructor of the class Position.
     *
     * @param x the value to initialize the attribute x.
     * @param y the value to initialize the attribute y.
     */
    Position(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Position cannot be negative : "
                    + x + " " + y);
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for the class's attribute x.
     *
     * @return
     */
    int getX() {
        return x;
    }

    /**
     * Getter for the class's attribute x.
     *
     * @return
     */
    int getY() {
        return y;
    }

    /**
     * Method which gets the position next to the current one at the given
     * direction.
     *
     * @param direction the direction to get from.
     * @return the position next to the current position.
     */
    Position next(Direction direction) {
        return new Position(x + direction.getRow(), y + direction.getColumn());
    }

    /**
     * Method which moves the position towards the given direction.
     *
     * @param direction the direction to move to.
     */
    void move(Direction direction) {
        this.x += direction.getRow();
        this.y += direction.getColumn();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.x;
        hash = 13 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final Position other = (Position) obj;
        return this.x == other.x && this.y == other.y;

    }

}
