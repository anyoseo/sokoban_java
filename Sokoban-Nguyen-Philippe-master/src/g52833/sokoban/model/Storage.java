package g52833.sokoban.model;

/**
 * This class represents a storage.
 *
 * @author G52833
 */
public class Storage extends Square {

    /**
     * Default constructor of the class Storage.
     */
    Storage() {
        super();
    }

    /**
     * Constructor with parameters of the class Storage.
     *
     * @param player the value to initialize the attribute player.
     */
    Storage(Player player) {
        super(player);
    }

    /**
     * Constructor with parameters of the class
     *
     * @param box
     */
    Storage(Box box) {
        super(box);

    }

}
