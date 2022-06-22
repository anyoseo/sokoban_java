package g52833.sokoban.model;

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for Player class.
 *
 * @author G52833
 */
public class PlayerTest {

    /**
     * Test of constructor from class Player.
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorPlayerNull() {
        System.out.println("testConstructorPlayerNull");
        Position position = null;
        new Player(position);
    }

    /**
     * Test of getPosition method from class Player.
     */
    @Test
    public void testGetPosition() {
        System.out.println("testGetPosition");
        Player player = new Player(new Position(1, 1));
        Position expected = new Position(1, 1);
        Position result = player.getPosition();
        assertEquals(expected, result);
    }

    /**
     * Test of move method from class Player.
     */
    @Test
    public void testMoveRight() {
        System.out.println("testMoveRight");
        Player player = new Player(new Position(1, 1));
        player.move(Direction.RIGHT);
        Position expected = new Position(1, 2);
        Position result = player.getPosition();
        assertEquals(expected, result);
    }

    /**
     * Test of move method from class Player.
     */
    @Test
    public void testMoveLeft() {
        System.out.println("testMoveLeft");
        Player player = new Player(new Position(1, 1));
        player.move(Direction.LEFT);
        Position expected = new Position(1, 0);
        Position result = player.getPosition();
        assertEquals(expected, result);
    }

    /**
     * Test of move method from class Player.
     */
    @Test
    public void testMoveUp() {
        System.out.println("testMoveUp");
        Player player = new Player(new Position(3, 3));
        player.move(Direction.UP);
        Position expected = new Position(2, 3);
        Position result = player.getPosition();
        assertEquals(expected, result);
    }

    /**
     * Test of move method from class Player.
     */
    @Test
    public void testMoveDown() {
        System.out.println("testMoveDown");
        Player player = new Player(new Position(3, 3));
        player.move(Direction.DOWN);
        Position expected = new Position(4, 3);
        Position result = player.getPosition();
        assertEquals(expected, result);
    }

    /**
     * Test of canMove method from class Player.
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
        Entity entity = dungeon.getEntity(new Position(2, 4));
        boolean result = entity.canMove(Direction.UP, dungeon);
        assertEquals(true, result);
    }

    /**
     * Test of canMove method from class Player.
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
        Entity entity = dungeon.getEntity(new Position(2, 4));
        boolean result = entity.canMove(Direction.DOWN, dungeon);
        assertEquals(true, result);
    }

    /**
     * Test of canMove method from class Player.
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
        Entity entity = dungeon.getEntity(new Position(2, 4));
        boolean result = entity.canMove(Direction.LEFT, dungeon);
        assertEquals(true, result);
    }

    /**
     * Test of canMove method from class Player.
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
        Entity entity = dungeon.getEntity(new Position(2, 4));
        boolean result = entity.canMove(Direction.RIGHT, dungeon);
        assertEquals(true, result);
    }

}
