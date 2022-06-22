package g52833.sokoban.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for CommandManager class.
 *
 * @author G52833
 */
public class CommandManagerTest {

    /**
     * Test of doCommand method, of class CommandManager.
     */
    @Test
    public void testDoCommand() {
        System.out.println("testDoCommand");
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "0");
        } catch (IOException ex) {
        }
        System.out.println("testExecuteRightWithBox");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(2, 4)));
        list.add(dungeon.getEntity(new Position(2, 5)));
        MoveCommand command = new MoveCommand(dungeon,
                Direction.RIGHT, list);
        CommandManager instance = new CommandManager();
        instance.doCommand(command);
        int expResult = 1;
        int result = instance.numberMove();
        assertEquals(expResult, result);
    }

    /**
     * Test of undo method, of class CommandManager.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "0");
        } catch (IOException ex) {
        }
        System.out.println("testExecuteRightWithBox");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(2, 4)));
        list.add(dungeon.getEntity(new Position(2, 5)));
        MoveCommand command = new MoveCommand(dungeon,
                Direction.RIGHT, list);
        CommandManager instance = new CommandManager();
        instance.doCommand(command);
        instance.undo();
        int expResult = 0;
        int result = instance.numberMove();
        assertEquals(expResult, result);
    }

    /**
     * Test of redo method, of class CommandManager.
     */
    @Test
    public void testRedo() {
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "0");
        } catch (IOException ex) {
        }
        System.out.println("testExecuteRightWithBox");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(2, 4)));
        list.add(dungeon.getEntity(new Position(2, 5)));
        MoveCommand command = new MoveCommand(dungeon,
                Direction.RIGHT, list);
        CommandManager instance = new CommandManager();
        instance.doCommand(command);
        instance.undo();
        instance.redo();
        int expResult = 1;
        int result = instance.numberMove();
        assertEquals(expResult, result);
    }

    /**
     * Test of resetStacks method, of class CommandManager.
     */
    @Test
    public void testResetStacks() {
        System.out.println("testResetStacks");
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "0");
        } catch (IOException ex) {
        }
        System.out.println("testExecuteRightWithBox");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(2, 4)));
        list.add(dungeon.getEntity(new Position(2, 5)));
        MoveCommand command = new MoveCommand(dungeon,
                Direction.RIGHT, list);
        CommandManager instance = new CommandManager();
        instance.doCommand(command);
        instance.undo();
        instance.redo();
        instance.resetStacks();
        int expResult = 0;
        int result = instance.numberMove();
        assertEquals(expResult, result);

    }

    /**
     * Test of numberMove method, of class CommandManager.
     */
    @Test
    public void testNumberMove() {
        System.out.println("numberMove");
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "0");
        } catch (IOException ex) {
        }
        System.out.println("testExecuteRightWithBox");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(2, 4)));
        list.add(dungeon.getEntity(new Position(2, 5)));
        MoveCommand command = new MoveCommand(dungeon,
                Direction.RIGHT, list);
        CommandManager instance = new CommandManager();
        instance.doCommand(command);
        int expResult = 1;
        int result = instance.numberMove();
        assertEquals(expResult, result);
    }

    /**
     * Test for undoList method from commandManager class.
     */
    @Test
    public void undoList() {
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "0");
        } catch (IOException ex) {
        }
        System.out.println("undoList");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(2, 4)));
        list.add(dungeon.getEntity(new Position(2, 5)));
        MoveCommand command = new MoveCommand(dungeon,
                Direction.RIGHT, list);
        CommandManager instance = new CommandManager();
        instance.doCommand(command);
        List<MoveCommand> undoList = instance.undoList();
        int result = undoList.size();
        int expected = 1;
        assertEquals(expected, result);
    }

    /**
     * Test for redoList method from commandManager class.
     */
    @Test
    public void redoList() {
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "0");
        } catch (IOException ex) {
        }
        System.out.println("redoList");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(2, 4)));
        list.add(dungeon.getEntity(new Position(2, 5)));
        MoveCommand command = new MoveCommand(dungeon,
                Direction.RIGHT, list);
        CommandManager instance = new CommandManager();
        instance.doCommand(command);
        instance.undo();
        List<MoveCommand> undoList = instance.redoList();
        int result = undoList.size();
        int expected = 1;
        assertEquals(expected, result);

    }

}
