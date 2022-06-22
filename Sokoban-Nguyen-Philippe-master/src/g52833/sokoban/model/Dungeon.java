package g52833.sokoban.model;

/**
 * This class represents a dungeon.
 *
 * @author G52833
 */
public class Dungeon {

    private Square[][] board;
    private static final int HEIGHT = 11;
    private static final int WIDTH = 11;

    /**
     * Constructor of the class Dungeon.
     */
    Dungeon() {
        board = new Square[HEIGHT][WIDTH];

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                board[i][j] = new Square();
            }
        }
    }

    /**
     * Method which returns the width of the dungeon.
     *
     * @return the width of the dungeon.
     */
    int getWidth() {
        return WIDTH;
    }

    /**
     * Method which returns the height of the dungeon.
     *
     * @return the height of the dungeon.
     */
    int getHeight() {
        return HEIGHT;
    }

    /**
     * Method which gets the square at the given position.
     *
     * @param position the position of the square.
     * @return the square on the board.
     */
    Square getSquare(Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("Position must be"
                    + " inside the board :" + position.getX()
                    + " " + position.getY());
        }
        return board[position.getX()][position.getY()];
    }

    /**
     * Method which gets the entity on the given square.
     *
     * @param position the position of the square.
     * @return the entity on the square.
     */
    Entity getEntity(Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("Position must be"
                    + " inside the board :" + position.getX()
                    + " " + position.getY());
        }
        return getSquare(position).getEntity();
    }

    /**
     * Setter for the Squares of the board.
     *
     * @param square the square to set the square's dungeon.
     * @param position the position of the square to set.
     */
    void setSquare(Square square, Position position) {
        board[position.getX()][position.getY()] = square;
    }

    /**
     * Method which puts an entity on the given square.
     *
     * @param entity the entity to put.
     * @param position the position of the square.
     */
    void put(Entity entity, Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("Position must be"
                    + " inside the board :" + position.getX()
                    + " " + position.getY());
        }
        getSquare(position).put(entity);
    }

    /**
     * Method which checks if the given square is free.
     *
     * @param position the position of the square to check.
     * @return true if it's free else false.
     */
    boolean isFree(Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("Position must be"
                    + " inside the board :" + position.getX()
                    + " " + position.getY());
        }
        return getSquare(position).isFree();
    }

    /**
     * Method which checks if the position is inside the board.
     *
     * @param position the position to check.
     * @return true if it's inside else false.
     */
    boolean isInside(Position position) {
        if (position.getX() < 0 || position.getY() < 0
                || position.getX() >= WIDTH || position.getY() >= HEIGHT) {
            return false;
        }
        return true;
    }

}
