package g52833.sokoban.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for Floor class.
 * @author G52833
 */
public class FloorTest {

    /**
     * Test of getEntity method, of class Floor.
     */
    @Test
    public void testFloorGetEntityNull() {
        System.out.println("testFloorGetEntityNull");
        Floor instance = new Floor();
        Entity expResult = null;
        Entity result = instance.getEntity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntity method, of class Square.
     */
    @Test
    public void testFloorGetEntityBox() {
        System.out.println("testFloorGetEntityBox");
        Box expResult = new Box(new Position(1, 1));
        Floor instance = new Floor(expResult);
        Entity result = instance.getEntity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntity method, of class Square.
     */
    @Test
    public void testFloorGetEntityPlayer() {
        System.out.println("testFloorGetEntityPlayer");
        Player expResult = new Player(new Position(1, 1));
        Floor instance = new Floor(expResult);
        Entity result = instance.getEntity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntity method, of class Square.
     */
    @Test
    public void testFloorGetEntity() {
        System.out.println("testFloorGetEntity");
        Entity expResult = new Entity(new Position(1, 1));
        Floor instance = new Floor(expResult);
        Entity result = instance.getEntity();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFree method, of class Floor.
     */
    @Test
    public void testFloorIsFree() {
        System.out.println("testFloorIsFree");
        Floor instance = new Floor();
        boolean expResult = true;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFree method, of class Floor.
     */
    @Test
    public void testFloorIsNotFreeBox() {
        System.out.println("testFloorIsNotFreeBox");
        Floor instance = new Floor(new Box(new Position(1, 1)));
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFree method, of class Floor.
     */
    @Test
    public void testFloorIsNotFreePlayer() {
        System.out.println("testFloorIsNotFreePlayer");
        Floor instance = new Floor(new Player(new Position(1, 1)));
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class Floor.
     */
    @Test
    public void testFloorPutPlayerEmpty() {
        System.out.println("testFloorPutPlayerEmpty");
        Player player = new Player(new Position(1, 1));
        Floor instance = new Floor();
        instance.put(player);
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class Floor.
     */
    @Test
    public void testFloorPutBoxEmpty() {
        System.out.println("testFloorPutBoxEmpty");
        Box box = new Box(new Position(1, 1));
        Floor instance = new Floor();
        instance.put(box);
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class Floor.
     */
    @Test
    public void testFloorPutEntityEmpty() {
        System.out.println("testFloorPutEntityEmpty");
        Entity entity = new Entity(new Position(1, 1));
        Floor instance = new Floor();
        instance.put(entity);
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class Floor.
     */
    @Test(expected = IllegalStateException.class)
    public void testFloorPutPlayerOccupiedBox() {
        System.out.println("testFloorPutPlayerOccupiedBox");
        Player player = new Player(new Position(1, 1));
        Floor instance = new Floor(new Box(new Position(1, 1)));
        instance.put(player);
    }

    /**
     * Test of put method, of class Floor.
     */
    @Test(expected = IllegalStateException.class)
    public void testFloorPutPlayerOccupiedPlayer() {
        System.out.println("testFloorPutPlayerOccupiedPlayer");
        Player player = new Player(new Position(1, 1));
        Floor instance = new Floor(new Player(new Position(1, 1)));
        instance.put(player);
    }

    /**
     * Test of put method, of class Floor.
     */
    @Test(expected = IllegalStateException.class)
    public void testFloorPutPlayerOccupiedEntity() {
        System.out.println("testFloorPutPlayerOccupiedEntity");
        Player player = new Player(new Position(1, 1));
        Floor instance = new Floor(new Entity(new Position(1, 1)));
        instance.put(player);
    }

    /**
     * Test of put method, of class Square.
     */
    @Test(expected = IllegalStateException.class)
    public void testFloorPutBoxOccupiedBox() {
        System.out.println("testFloorPutBoxOccupiedBox");
        Box box = new Box(new Position(1, 1));
        Floor instance = new Floor(new Box(new Position(1, 1)));
        instance.put(box);
    }

    /**
     * Test of put method, of class Floor.
     */
    @Test(expected = IllegalStateException.class)
    public void testFloorPutBoxOccupiedPlayer() {
        System.out.println("testFloorPutBoxOccupiedPlayer");
        Box box = new Box(new Position(1, 1));
        Floor instance = new Floor(new Player(new Position(1, 1)));
        instance.put(box);
    }

    /**
     * Test of put method, of class Floor.
     */
    @Test(expected = IllegalStateException.class)
    public void testFloorPutBoxOccupiedEntity() {
        System.out.println("testFloorPutBoxOccupiedEntity");
        Box box = new Box(new Position(1, 1));
        Floor instance = new Floor(new Entity(new Position(1, 1)));
        instance.put(box);
    }

    /**
     * Test of put method, of class Floor.
     */
    @Test(expected = IllegalStateException.class)
    public void testFloorPutEntityOccupiedBox() {
        System.out.println("testFloorPutEntityOccupiedBox");
        Entity entity = new Entity(new Position(1, 1));
        Floor instance = new Floor(new Box(new Position(1, 1)));
        instance.put(entity);
    }

    /**
     * Test of put method, of class Floor.
     */
    @Test(expected = IllegalStateException.class)
    public void testFloorPutEntityOccupiedPlayer() {
        System.out.println("testFloorPutEntityOccupiedPlayer");
        Entity entity = new Entity(new Position(1, 1));
        Floor instance = new Floor(new Player(new Position(1, 1)));
        instance.put(entity);
    }

    /**
     * Test of put method, of class Floor.
     */
    @Test(expected = IllegalStateException.class)
    public void testFloorPutEntityOccupiedEntity() {
        System.out.println("testFloorPutEntityOccupiedEntity");
        Entity entity = new Entity(new Position(1, 1));
        Floor instance = new Floor(new Entity(new Position(1, 1)));
        instance.put(entity);
    }

    /**
     * Test of remove method, of class Floor.
     */
    @Test(expected = IllegalStateException.class)
    public void testFloorRemove() {
        System.out.println("testFloorRemove");
        Floor instance = new Floor();
        instance.remove();
    }

    /**
     * Test of remove method, of class Floor.
     */
    @Test
    public void testFloorRemovePlayer() {
        System.out.println("testFloorRemovePlayer");
        Floor instance = new Floor(new Player(new Position(1, 1)));
        instance.remove();
        boolean expResult = true;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class Floor.
     */
    @Test
    public void testFloorRemoveBox() {
        System.out.println("testFloorRemoveBox");
        Floor instance = new Floor(new Box(new Position(1, 1)));
        instance.remove();
        boolean expResult = true;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class Floor.
     */
    @Test
    public void testFloorRemoveEntity() {
        System.out.println("testFloorRemoveEntity");
        Floor instance = new Floor(new Entity(new Position(1, 1)));
        instance.remove();
        boolean expResult = true;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

}
