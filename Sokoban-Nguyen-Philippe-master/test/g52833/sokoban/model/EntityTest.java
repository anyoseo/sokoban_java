package g52833.sokoban.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for Entity class.
 *
 * @author G52833
 */
public class EntityTest {

    /**
     * Test of constructor method from class Entity.
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorPlayerNull() {
        System.out.println("testConstructorPlayerNull");
        Position position = null;
        new Entity(position);
    }

    /**
     * Test of getPosition method from class Entity.
     */
    @Test
    public void testGetPosition() {
        System.out.println("testGetPosition");
        Entity entity = new Entity(new Position(1, 1));
        Position expected = new Position(1, 1);
        Position result = entity.getPosition();
        assertEquals(expected, result);
    }

    /**
     * Test of move method from class Entity.
     */
    @Test
    public void testMoveRight() {
        System.out.println("testMoveRight");
        Entity entity = new Entity(new Position(1, 1));
        entity.move(Direction.RIGHT);
        Position expected = new Position(1, 2);
        Position result = entity.getPosition();
        assertEquals(expected, result);
    }

    /**
     * Test of move method from class Entity.
     */
    @Test
    public void testMoveLeft() {
        System.out.println("testMoveLeft");
        Entity entity = new Entity(new Position(1, 1));
        entity.move(Direction.LEFT);
        Position expected = new Position(1, 0);
        Position result = entity.getPosition();
        assertEquals(expected, result);
    }

    /**
     * Test of move method from class Entity.
     */
    @Test
    public void testMoveUp() {
        System.out.println("testMoveUp");
        Entity entity = new Entity(new Position(3, 3));
        entity.move(Direction.UP);
        Position expected = new Position(2, 3);
        Position result = entity.getPosition();
        assertEquals(expected, result);
    }

    /**
     * Test of move method from class Entity.
     */
    @Test
    public void testMoveDown() {
        System.out.println("testMoveDown");
        Entity entity = new Entity(new Position(3, 3));
        entity.move(Direction.DOWN);
        Position expected = new Position(4, 3);
        Position result = entity.getPosition();
        assertEquals(expected, result);
    }

    @Test
    public void testCanMove() {
        Dungeon dungeon = new Dungeon();
        Entity entity = new Entity(new Position(3, 3));
        boolean result = entity.canMove(Direction.UP, dungeon);
        assertEquals(false, result);
    }

}
