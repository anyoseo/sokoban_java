package g52833.sokoban.model;

/**
 * This enumartion represents the directions.
 *
 * @author G52833
 */
public enum Direction {

    /**
     * The up direction.
     */
    UP(-1, 0),
    /**
     * The down direction.
     */
    DOWN(1, 0),
    /**
     * The left direction.
     */
    LEFT(0, -1),
    /**
     * The right direction.
     */
    RIGHT(0, 1);

    private int row;
    private int column;

    /**
     * Constructor of the enumartion Direction.
     *
     * @param row the value for the attribute row.
     * @param column the value for the attribute column.
     */
    private Direction(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Getter for the enumeration's attribute row.
     *
     * @return the attribute row.
     */
    int getRow() {
        return row;
    }

    /**
     * Getter for the enumeration's attribute column.
     *
     * @return the attribute column.
     */
    int getColumn() {
        return column;
    }

    /**
     * Method which gets the opposite direction of the current direction.
     *
     * @return the opposite direction.
     */
    Direction oppositeDirection() {
        switch (this.row) {
            case 0:
                if (this.column == 1) {
                    return LEFT;
                } else {
                    return RIGHT;
                }
            case 1:
                return UP;
            default:
                return DOWN;
        }
    }

}
