package g52833.sokoban.model;

/**
 * This class represents the interface command.
 *
 * @author Binh-Philippe
 */
public interface Command {

    /**
     * Method which executes the command.
     */
    void execute();

    /**
     * Method which unexecutes the command.
     */
    void unexecute();
}
