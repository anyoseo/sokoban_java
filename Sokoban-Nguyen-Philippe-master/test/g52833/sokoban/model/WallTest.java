package g52833.sokoban.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for Wall class.
 *
 * @author G52833
 */
public class WallTest {

    /**
     * Test of getEntity method, of class Wall.
     */
    @Test
    public void testWallGetEntityNull() {
        System.out.println("testWallGetEntityNull");
        Wall instance = new Wall();
        Entity expResult = null;
        Entity result = instance.getEntity();
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class Wall.
     */
    @Test
    public void testWallPutPlayerEmpty() {
        System.out.println("testPutPlayerEmpty");
        Player player = new Player(new Position(1, 1));
        Wall instance = new Wall();
        instance.put(player);
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class Wall.
     */
    @Test
    public void testWallPutBoxEmpty() {
        System.out.println("testWallPutBoxEmpty");
        Box box = new Box(new Position(1, 1));
        Wall instance = new Wall();
        instance.put(box);
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class Wall.
     */
    @Test
    public void testWallPutEntityEmpty() {
        System.out.println("testWallPutEntityEmpty");
        Entity entity = new Entity(new Position(1, 1));
        Wall instance = new Wall();
        instance.put(entity);
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class Wall.
     */
    @Test(expected = IllegalStateException.class)
    public void testWallRemove() {
        System.out.println("testWallRemove");
        Wall instance = new Wall();
        instance.remove();
    }

}
