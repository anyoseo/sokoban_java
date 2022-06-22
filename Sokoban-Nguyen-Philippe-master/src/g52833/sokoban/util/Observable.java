package g52833.sokoban.util;

/**
 * This class represents the Observable.
 *
 * @author g52833
 */
public interface Observable {

    void addObserver(Observer obs);

    void removeObserver(Observer obs);
}
