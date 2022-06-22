package g52833.sokoban.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for Position class.
 *
 * @author G52833
 */
public class PositionTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorPositionWidthNegative() {
        System.out.println("testConstructorPositionWidthNegative");
        new Position(-1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorPositionHeightNegative() {
        System.out.println("testConstructorPositionHeightNegative");
        new Position(1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorPositionBothNegative() {
        System.out.println("testConstructorPositionBothNegative");
        new Position(-1, -1);
    }

    /**
     * Test of getX method, of class Position.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Position instance = new Position(1, 2);
        int expResult = 1;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Position.
     */
    @Test
    public void testGetY() {
        System.out.println("testGetY");
        Position instance = new Position(1, 2);
        int expResult = 2;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of next method, of class Position.
     */
    @Test
    public void testNextRight() {
        System.out.println("testNextRight");
        Direction direction = Direction.RIGHT;
        Position instance = new Position(2, 2);
        Position expResult = new Position(2, 3);
        Position result = instance.next(direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of next method, of class Position.
     */
    @Test
    public void testNextLeft() {
        System.out.println("testNextLeft");
        Direction direction = Direction.LEFT;
        Position instance = new Position(2, 2);
        Position expResult = new Position(2, 1);
        Position result = instance.next(direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of next method, of class Position.
     */
    @Test
    public void testNextUp() {
        System.out.println("testNextUp");
        Direction direction = Direction.UP;
        Position instance = new Position(2, 2);
        Position expResult = new Position(1, 2);
        Position result = instance.next(direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of next method, of class Position.
     */
    @Test
    public void testNextDown() {
        System.out.println("testNextDown");
        Direction direction = Direction.DOWN;
        Position instance = new Position(2, 2);
        Position expResult = new Position(3, 2);
        Position result = instance.next(direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Position.
     */
    @Test
    public void testMoveRight() {
        System.out.println("testMoveRight");
        Direction direction = Direction.RIGHT;
        Position instance = new Position(2, 2);
        Position expResult = new Position(2, 3);
        instance.move(direction);
        assertEquals(expResult, instance);
    }

    /**
     * Test of move method, of class Position.
     */
    @Test
    public void testMoveLeft() {
        System.out.println("testMoveLeft");
        Direction direction = Direction.LEFT;
        Position instance = new Position(2, 2);
        Position expResult = new Position(2, 1);
        instance.move(direction);
        assertEquals(expResult, instance);
    }

    /**
     * Test of move method, of class Position.
     */
    @Test
    public void testMoveUp() {
        System.out.println("testMoveUp");
        Direction direction = Direction.UP;
        Position instance = new Position(2, 2);
        Position expResult = new Position(1, 2);
        instance.move(direction);
        assertEquals(expResult, instance);
    }

    /**
     * Test of move method, of class Position.
     */
    @Test
    public void testMoveDown() {
        System.out.println("testMoveDown");
        Direction direction = Direction.DOWN;
        Position instance = new Position(2, 2);
        Position expResult = new Position(3, 2);
        instance.move(direction);
        assertEquals(expResult, instance);
    }

}
