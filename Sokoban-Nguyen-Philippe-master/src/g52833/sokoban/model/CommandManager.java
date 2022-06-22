package g52833.sokoban.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This class represents the command management.
 *
 * @author G52833
 */
public class CommandManager {

    private Stack<MoveCommand> undoStack = new Stack<>();
    private Stack<MoveCommand> redoStack = new Stack<>();

    /**
     * Method which executes the command.
     *
     * @param command the command to execute.
     */
    void doCommand(MoveCommand command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    /**
     * Method which undoes the command executed.
     */
    void undo() {
        if (!undoStack.isEmpty()) {
            MoveCommand command = undoStack.pop();
            redoStack.push(command);
            command.unexecute();
        }
    }

    /**
     * Method which redoes the previous command.
     */
    void redo() {
        if (!redoStack.isEmpty()) {
            MoveCommand command = redoStack.pop();
            undoStack.push(command);
            command.execute();
        }
    }

    /**
     * Method which resets the stacks.
     */
    void resetStacks() {
        redoStack.clear();
        undoStack.clear();
    }

    /**
     * Method which returns the size of the undo stack.
     *
     * @return the size of the undo stack.
     */
    int numberMove() {
        return undoStack.size();
    }

    /**
     * Method which creates a list with the undo stack's elements.
     *
     * @return a list of MoveCommand.
     */
    List<MoveCommand> undoList() {
        List<MoveCommand> undoStackList = new ArrayList<>();
        MoveCommand temp1;
        MoveCommand temp2;
        if (undoStack.size() > 0) {
            temp1 = this.undoStack.pop();
            undoStackList.add(temp1);

            if (undoStack.size() >= 1) {
                temp2 = this.undoStack.pop();
                undoStackList.add(temp2);
                this.undoStack.push(temp2);
            }
            this.undoStack.push(temp1);
        }
        return undoStackList;
    }

    /**
     * Method which creates a list with the redo stack's elements.
     *
     * @return a list of MoveCommand.
     */
    List<MoveCommand> redoList() {
        List<MoveCommand> redoStackList = new ArrayList<>();
        MoveCommand temp1;
        MoveCommand temp2;
        if (redoStack.size() > 0) {
            temp1 = this.redoStack.pop();
            redoStackList.add(temp1);

            if (redoStack.size() >= 1) {
                temp2 = this.redoStack.pop();
                redoStackList.add(temp2);
                this.redoStack.push(temp2);
            }
            this.redoStack.push(temp1);
        }
        return redoStackList;
    }

}
