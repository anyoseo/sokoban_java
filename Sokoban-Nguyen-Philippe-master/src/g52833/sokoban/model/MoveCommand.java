package g52833.sokoban.model;

import java.util.List;

/**
 * This class represents the command move.
 *
 * @author G52833
 */
public class MoveCommand implements Command {

    private Dungeon dungeon;
    private Direction direction;
    private List<Entity> list;

    /**
     * Constructor of the class MoveCommand.
     *
     * @param dungeon the value to initialize the attribute dungeon.
     * @param direction the value to initialize the attribute direction.
     * @param list the value to intialize the attribute list.
     */
    MoveCommand(Dungeon dungeon, Direction direction, List<Entity> list) {
        this.dungeon = dungeon;
        this.direction = direction;
        this.list = list;
    }

    /**
     * Getter for the attribute direction.
     *
     * @return the attribute direction.
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * /**
     * Getter for the attribute list.
     *
     * @return the attribute list.
     */
    public List<Entity> getList() {
        return list;
    }

    /**
     * Method which executes the move command.
     */
    @Override
    public void execute() {
        if (list.size() == 1) {
            dungeon.getSquare(list.get(0).getPosition()).remove();
            list.get(0).move(direction);
            dungeon.put(list.get(0), list.get(0).getPosition());
        } else {
            dungeon.put(new Box(list.get(1).getPosition().next(direction)),
                    list.get(1).getPosition().next(direction));
            dungeon.getSquare(list.get(1).getPosition()).remove();
            list.get(1).move(direction);
            dungeon.getSquare(list.get(0).getPosition()).remove();
            list.get(0).getPosition().move(direction);
            dungeon.put(list.get(0), list.get(0).getPosition());
        }
    }

    /**
     * Method which unexecutes the previous command.
     */
    @Override
    public void unexecute() {
        if (list.size() == 1) {
            dungeon.getSquare(list.get(0).getPosition()).remove();
            list.get(0).move(direction.oppositeDirection());
            dungeon.put(list.get(0), list.get(0).getPosition());
        } else {

            dungeon.getSquare(list.get(0).getPosition()).remove();
            dungeon.getSquare(list.get(1).getPosition()).remove();
            list.get(0).getPosition().move(direction.oppositeDirection());
            dungeon.put(list.get(0), list.get(0).getPosition());
            dungeon.put(new Box(list.get(1).getPosition()
                    .next(direction.oppositeDirection())), list.get(1)
                    .getPosition().next(direction.oppositeDirection()));
            list.get(1).getPosition().move(direction.oppositeDirection());
        }
    }
}
