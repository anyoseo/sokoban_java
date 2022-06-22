package g52833.sokoban.model;

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for Box class.
 *
 * @author G52833
 */
public class BoxTest {

    /**
     * Test of constructor from class Box.
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorBoxNull() {
        System.out.println("testConstructorBoxNull");
        Position position = null;
        new Box(position);
    }

    /**
     * Test of getPosition method from class Box.
     */
    @Test
    public void testGetPosition() {
        System.out.println("testGetPosition");
        Box box = new Box(new Position(1, 1));
        Position expected = new Position(1, 1);
        Position result = box.getPosition();
        assertEquals(expected, result);
    }

    /**
     * Test of move method from class Box.
     */
    @Test
    public void testMoveRight() {
        System.out.println("testMoveRight");
        Box box = new Box(new Position(1, 1));
        box.move(Direction.RIGHT);
        Position expected = new Position(1, 2);
        Position result = box.getPosition();
        assertEquals(expected, result);
    }

    /**
     * Test of move method from class Box.
     */
    @Test
    public void testMoveLeft() {
        System.out.println("testMoveLeft");
        Box box = new Box(new Position(1, 1));
        box.move(Direction.LEFT);
        Position expected = new Position(1, 0);
        Position result = box.getPosition();
        assertEquals(expected, result);
    }

    /**
     * Test of move method from class Box.
     */
    @Test
    public void testMoveUp() {
        System.out.println("testMoveUp");
        Box box = new Box(new Position(3, 3));
        box.move(Direction.UP);
        Position expected = new Position(2, 3);
        Position result = box.getPosition();
        assertEquals(expected, result);
    }

    /**
     * Test of move method from class Box.
     */
    @Test
    public void testMoveDown() {
        System.out.println("testMoveDown");
        Box box = new Box(new Position(3, 3));
        box.move(Direction.DOWN);
        Position expected = new Position(4, 3);
        Position result = box.getPosition();
        assertEquals(expected, result);
    }

    /**
     * Test of canMove method from class Box.
     */
    @Test
    public void testCanMoveRight() {
        System.out.println("testCanMoveRight");
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "0");
        } catch (IOException ex) {
        }
        Entity entity = dungeon.getEntity(new Position(2, 2));
        boolean result = entity.canMove(Direction.RIGHT, dungeon);
        assertEquals(true, result);
    }

    /**
     * Test of canMove method from class Box.
     */
    @Test
    public void testCanMoveLeft() {
        System.out.println("testCanMoveLeft");
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "0");
        } catch (IOException ex) {
        }
        Entity entity = dungeon.getEntity(new Position(2, 2));
        boolean result = entity.canMove(Direction.LEFT, dungeon);
        assertEquals(true, result);
    }

    /**
     * Test of canMove method from class Box.
     */
    @Test
    public void testCanMoveUp() {
        System.out.println("testCanMoveUp");
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "0");
        } catch (IOException ex) {
        }
        Entity entity = dungeon.getEntity(new Position(2, 2));
        boolean result = entity.canMove(Direction.UP, dungeon);
        assertEquals(true, result);
    }

    /**
     * Test of canMove method from class Box.
     */
    @Test
    public void testCanMoveDown() {
        System.out.println("testCanMoveDown");
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "0");
        } catch (IOException ex) {
        }
        Entity entity = dungeon.getEntity(new Position(2, 2));
        boolean result = entity.canMove(Direction.DOWN, dungeon);
        assertEquals(true, result);
    }

    /**
     * Test of canMove method from class Box.
     */
    @Test
    public void testCanMoveDownFalse() {
        System.out.println("testCanMoveDownFalse");
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "10");
        } catch (IOException ex) {
        }
        Entity entity = dungeon.getEntity(new Position(1, 4));
        boolean result = entity.canMove(Direction.DOWN, dungeon);
        assertEquals(false, result);
    }

    /**
     * Test of canMove method from class Box.
     */
    @Test
    public void testCanMoveUpFalse() {
        System.out.println("testCanMoveUpFalse");
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "10");
        } catch (IOException ex) {
        }
        Entity entity = dungeon.getEntity(new Position(1, 4));
        boolean result = entity.canMove(Direction.UP, dungeon);
        assertEquals(false, result);
    }

    /**
     * Test of canMove method from class Box.
     */
    @Test
    public void testCanMoveLeftFalse() {
        System.out.println("testCanMoveLeftFalse");
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "2");
        } catch (IOException ex) {
        }
        Entity entity = dungeon.getEntity(new Position(4, 1));
        boolean result = entity.canMove(Direction.LEFT, dungeon);
        assertEquals(false, result);
    }

    /**
     * Test of canMove method from class Box.
     */
    @Test
    public void testCanMoveLeftRight() {
        System.out.println("testCanMoveLeftRight");
        Dungeon dungeon = new Dungeon();
        XsbReader reader = new XsbReader();
        try {
            reader.loadLevel(dungeon, "2");
        } catch (IOException ex) {
        }
        Entity entity = dungeon.getEntity(new Position(4, 1));
        boolean result = entity.canMove(Direction.RIGHT, dungeon);
        assertEquals(false, result);
    }

}
