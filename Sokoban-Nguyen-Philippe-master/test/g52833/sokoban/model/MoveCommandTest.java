package g52833.sokoban.model;

import g52833.sokoban.view.View;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for MoveCommand class.
 *
 * @author G52833
 */
public class MoveCommandTest {

    /**
     * Test of execute method, of class MoveCommand.
     */
    @Test
    public void testExecuteDownFree() {
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "0");
        } catch (IOException ex) {
        }
        System.out.println("testExecuteDownFree");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(2, 4)));
        MoveCommand instance = new MoveCommand(dungeon,
                Direction.DOWN, list);
        instance.execute();
        boolean expResult = false;
        boolean result = dungeon.getSquare(new Position(3, 4)).isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of execute method, of class MoveCommand.
     */
    @Test
    public void testExecuteUpFree() {
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "0");
        } catch (IOException ex) {
        }
        System.out.println("testExecuteUpFree");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(2, 4)));
        MoveCommand instance = new MoveCommand(dungeon,
                Direction.UP, list);
        instance.execute();
        boolean expResult = false;
        boolean result = dungeon.getSquare(new Position(1, 4)).isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of execute method, of class MoveCommand.
     */
    @Test
    public void testExecuteLeftFree() {
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "0");
        } catch (IOException ex) {
        }
        System.out.println("testExecuteLeftFree");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(2, 4)));
        MoveCommand instance = new MoveCommand(dungeon,
                Direction.LEFT, list);
        instance.execute();
        boolean expResult = false;
        boolean result = dungeon.getSquare(new Position(2, 3)).isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of execute method, of class MoveCommand.
     */
    @Test
    public void testExecuteRightFree() {
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "7");
        } catch (IOException ex) {
        }
        System.out.println("testExecuteRightFree");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(8, 2)));
        MoveCommand instance = new MoveCommand(dungeon,
                Direction.RIGHT, list);
        instance.execute();
        boolean expResult = false;
        boolean result = dungeon.getSquare(new Position(8, 3)).isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of execute method, of class MoveCommand.
     */
    @Test
    public void testExecuteDownWithBox() {
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "3");
        } catch (IOException ex) {
        }
        System.out.println("testExecuteDownWithBox");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(1, 6)));
        list.add(dungeon.getEntity(new Position(2, 6)));
        MoveCommand instance = new MoveCommand(dungeon,
                Direction.DOWN, list);
        instance.execute();
        boolean expResult = false;
        boolean result = dungeon.getSquare(new Position(3, 6)).isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of execute method, of class MoveCommand.
     */
    @Test
    public void testExecuteUpWithBox() {
        System.out.println("testExecuteUpWithBox");
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "7");
        } catch (IOException ex) {
        }
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(8, 2)));
        list.add(dungeon.getEntity(new Position(7, 2)));
        MoveCommand instance = new MoveCommand(dungeon,
                Direction.UP, list);
        instance.execute();
        boolean expResult = false;
        boolean result = dungeon.getSquare(new Position(6, 2)).isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of execute method, of class MoveCommand.
     */
    @Test
    public void testExecuteLeftWithBox() {
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "3");
        } catch (IOException ex) {
        }
        System.out.println("testExecuteLeftWithBox");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(1, 6)));
        list.add(dungeon.getEntity(new Position(1, 5)));
        MoveCommand instance = new MoveCommand(dungeon,
                Direction.LEFT, list);
        instance.execute();
        boolean expResult = false;
        boolean result = dungeon.getSquare(new Position(1, 4)).isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of execute method, of class MoveCommand.
     */
    @Test
    public void testExecuteRightWithBox() {
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
        MoveCommand instance = new MoveCommand(dungeon,
                Direction.RIGHT, list);
        instance.execute();
        boolean expResult = false;
        boolean result = dungeon.getSquare(new Position(2, 6)).isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of unexecute method, of class MoveCommand.
     */
    @Test
    public void testUnexecuteRightFree() {
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "0");
        } catch (IOException ex) {
        }
        System.out.println("testUnexecuteRightFree");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(2, 4)));
        MoveCommand instance = new MoveCommand(dungeon,
                Direction.RIGHT, list);
        instance.unexecute();
        boolean expResult = false;
        boolean result = dungeon.getSquare(new Position(2, 3)).isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of unexecute method, of class MoveCommand.
     */
    @Test
    public void testUnexecuteLeftFree() {
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "7");
        } catch (IOException ex) {
        }
        System.out.println("testUnexecuteLeftFree");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(8, 2)));
        MoveCommand instance = new MoveCommand(dungeon,
                Direction.RIGHT, list);
        instance.execute();
        boolean expResult = false;
        boolean result = dungeon.getSquare(new Position(8, 3)).isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of unexecute method, of class MoveCommand.
     */
    @Test
    public void testUnexecuteUpFree() {
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "0");
        } catch (IOException ex) {
        }
        System.out.println("testUnexecuteUpFree");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(2, 4)));
        MoveCommand instance = new MoveCommand(dungeon,
                Direction.DOWN, list);
        instance.unexecute();
        boolean expResult = false;
        boolean result = dungeon.getSquare(new Position(1, 4)).isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of unexecute method, of class MoveCommand.
     */
    @Test
    public void testUnexecuteDownFree() {
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "0");
        } catch (IOException ex) {
        }
        System.out.println("testUnexecuteDownFree");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(2, 4)));
        MoveCommand instance = new MoveCommand(dungeon,
                Direction.UP, list);
        instance.unexecute();
        boolean expResult = false;
        boolean result = dungeon.getSquare(new Position(3, 4)).isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of execute method, of class MoveCommand.
     */
    @Test
    public void testUnexecuteDownWithBox() {
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "3");
        } catch (IOException ex) {
        }
        System.out.println("testExecuteDownWithBox");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(1, 6)));
        list.add(dungeon.getEntity(new Position(2, 6)));
        MoveCommand instance = new MoveCommand(dungeon,
                Direction.DOWN, list);
        instance.execute();
        instance.unexecute();
        boolean expResult = false;
        boolean result = dungeon.getSquare(new Position(2, 6)).isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of unexecute method, of class MoveCommand.
     */
    @Test
    public void testUnexecuteUpWithBox() {
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "7");
        } catch (IOException ex) {
        }
        System.out.println("testUnexecuteUpWithBox");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(8, 2)));
        list.add(dungeon.getEntity(new Position(7, 2)));
        MoveCommand instance = new MoveCommand(dungeon,
                Direction.UP, list);
        instance.execute();
        instance.unexecute();
        boolean expResult = false;
        boolean result = dungeon.getSquare(new Position(7, 2)).isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of unexecute method, of class MoveCommand.
     */
    @Test
    public void testUnexecuteLeftWithBox() {
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "10");
        } catch (IOException ex) {
        }
        System.out.println("testExecuteLeftWithBox");
        List<Entity> list = new ArrayList<>();
        list.add(dungeon.getEntity(new Position(1, 3)));
        list.add(dungeon.getEntity(new Position(1, 4)));
        MoveCommand instance = new MoveCommand(dungeon,
                Direction.LEFT, list);
        instance.unexecute();
        boolean expResult = false;
        boolean result = dungeon.getSquare(new Position(1, 5)).isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of unexecute method, of class MoveCommand.
     */
    @Test
    public void testUnexecuteRightWithBox() {
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
        MoveCommand instance = new MoveCommand(dungeon,
                Direction.RIGHT, list);
        instance.unexecute();
        boolean expResult = false;
        boolean result = dungeon.getSquare(new Position(2, 4)).isFree();
        assertEquals(expResult, result);
    }

}
