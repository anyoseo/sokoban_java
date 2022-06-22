package g52833.sokoban.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for Square class.
 *
 * @author G52833
 */
public class SquareTest {

    /**
     * Test of getEntity method, of class Square.
     */
    @Test
    public void testGetEntityNull() {
        System.out.println("testGetEntityNull");
        Square instance = new Square();
        Entity expResult = null;
        Entity result = instance.getEntity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntity method, of class Square.
     */
    @Test
    public void testGetEntityBox() {
        System.out.println("testGetEntityBox");
        Box expResult = new Box(new Position(1, 1));
        Square instance = new Square(expResult);
        Entity result = instance.getEntity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntity method, of class Square.
     */
    @Test
    public void testGetEntityPlayer() {
        System.out.println("testGetEntityPlayer");
        Player expResult = new Player(new Position(1, 1));
        Square instance = new Square(expResult);
        Entity result = instance.getEntity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntity method, of class Square.
     */
    @Test
    public void testGetEntity() {
        System.out.println("testGetEntity");
        Entity expResult = new Entity(new Position(1, 1));
        Square instance = new Square(expResult);
        Entity result = instance.getEntity();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFree method, of class Square.
     */
    @Test
    public void testIsFree() {
        System.out.println("isFree");
        Square instance = new Square();
        boolean expResult = true;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFree method, of class Square.
     */
    @Test
    public void testIsNotFreeBox() {
        System.out.println("testIsNotFree");
        Square instance = new Square(new Box(new Position(1, 1)));
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFree method, of class Square.
     */
    @Test
    public void testIsNotFreePlayer() {
        System.out.println("testIsNotFree");
        Square instance = new Square(new Player(new Position(1, 1)));
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class Square.
     */
    @Test
    public void testPutPlayerEmpty() {
        System.out.println("testPutPlayerEmpty");
        Player player = new Player(new Position(1, 1));
        Square instance = new Square();
        instance.put(player);
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class Square.
     */
    @Test
    public void testPutBoxEmpty() {
        System.out.println("testPutBoxEmpty");
        Box box = new Box(new Position(1, 1));
        Square instance = new Square();
        instance.put(box);
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class Square.
     */
    @Test
    public void testPutEntityEmpty() {
        System.out.println("testPutEntityEmpty");
        Entity entity = new Entity(new Position(1, 1));
        Square instance = new Square();
        instance.put(entity);
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class Square.
     */
    @Test(expected = IllegalStateException.class)
    public void testPutPlayerOccupiedBox() {
        System.out.println("testPutPlayerOccupiedBox");
        Player player = new Player(new Position(1, 1));
        Square instance = new Square(new Box(new Position(1, 1)));
        instance.put(player);
    }

    /**
     * Test of put method, of class Square.
     */
    @Test(expected = IllegalStateException.class)
    public void testPutPlayerOccupiedPlayer() {
        System.out.println("testPutPlayerOccupiedPlayer");
        Player player = new Player(new Position(1, 1));
        Square instance = new Square(new Player(new Position(1, 1)));
        instance.put(player);
    }

    /**
     * Test of put method, of class Square.
     */
    @Test(expected = IllegalStateException.class)
    public void testPutPlayerOccupiedEntity() {
        System.out.println("testPutPlayerOccupiedEntity");
        Player player = new Player(new Position(1, 1));
        Square instance = new Square(new Entity(new Position(1, 1)));
        instance.put(player);
    }

    /**
     * Test of put method, of class Square.
     */
    @Test(expected = IllegalStateException.class)
    public void testPutBoxOccupiedBox() {
        System.out.println("testPutBoxOccupied");
        Box box = new Box(new Position(1, 1));
        Square instance = new Square(new Box(new Position(1, 1)));
        instance.put(box);
    }

    /**
     * Test of put method, of class Square.
     */
    @Test(expected = IllegalStateException.class)
    public void testPutBoxOccupiedPlayer() {
        System.out.println("testPutBoxOccupiedPlayer");
        Box box = new Box(new Position(1, 1));
        Square instance = new Square(new Player(new Position(1, 1)));
        instance.put(box);
    }

    /**
     * Test of put method, of class Square.
     */
    @Test(expected = IllegalStateException.class)
    public void testPutBoxOccupiedEntity() {
        System.out.println("testPutBoxOccupiedEntity");
        Box box = new Box(new Position(1, 1));
        Square instance = new Square(new Entity(new Position(1, 1)));
        instance.put(box);
    }

    /**
     * Test of put method, of class Square.
     */
    @Test(expected = IllegalStateException.class)
    public void testPutEntityOccupiedBox() {
        System.out.println("testPutEntityOccupied");
        Entity entity = new Entity(new Position(1, 1));
        Square instance = new Square(new Box(new Position(1, 1)));
        instance.put(entity);
    }

    /**
     * Test of put method, of class Square.
     */
    @Test(expected = IllegalStateException.class)
    public void testPutEntityOccupiedPlayer() {
        System.out.println("testPutEntityOccupiedPlayer");
        Entity entity = new Entity(new Position(1, 1));
        Square instance = new Square(new Player(new Position(1, 1)));
        instance.put(entity);
    }

    /**
     * Test of put method, of class Square.
     */
    @Test(expected = IllegalStateException.class)
    public void testPutEntityOccupiedEntity() {
        System.out.println("testPutEntityOccupiedEntity");
        Entity entity = new Entity(new Position(1, 1));
        Square instance = new Square(new Entity(new Position(1, 1)));
        instance.put(entity);
    }

    /**
     * Test of remove method, of class Square.
     */
    @Test(expected = IllegalStateException.class)
    public void testRemove() {
        System.out.println("testRemove");
        Square instance = new Square();
        instance.remove();
    }

    /**
     * Test of remove method, of class Square.
     */
    @Test
    public void testRemovePlayer() {
        System.out.println("testRemovePlayer");
        Square instance = new Square(new Player(new Position(1, 1)));
        instance.remove();
        boolean expResult = true;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class Square.
     */
    @Test
    public void testRemoveEntity() {
        System.out.println("testRemoveEntity");
        Square instance = new Square(new Entity(new Position(1, 1)));
        instance.remove();
        boolean expResult = true;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    public void testRemoveBox() {
        System.out.println("testRemoveBox");
        Square instance = new Square(new Box(new Position(1, 1)));
        instance.remove();
        boolean expResult = true;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

}
