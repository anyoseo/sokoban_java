package g52833.sokoban.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for Storage class.
 *
 * @author G52833
 */
public class StorageTest {

    /**
     * Test of getEntity method, of class Storage.
     */
    @Test
    public void testStorageGetEntityNull() {
        System.out.println("testStorageGetEntityNull");
        Storage instance = new Storage();
        Entity expResult = null;
        Entity result = instance.getEntity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntity method, of class Storage.
     */
    @Test
    public void testStorageGetEntityBox() {
        System.out.println("testStorageGetEntityBox");
        Box expResult = new Box(new Position(1, 1));
        Storage instance = new Storage(expResult);
        Entity result = instance.getEntity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntity method, of class Storage.
     */
    @Test
    public void testStorageGetEntityPlayer() {
        System.out.println("testStorageGetEntityPlayer");
        Player expResult = new Player(new Position(1, 1));
        Storage instance = new Storage(expResult);
        Entity result = instance.getEntity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntity method, of class Storage.
     */
    @Test
    public void testStorageGetEntity() {
        System.out.println("testStorageGetEntity");
        Entity expResult = new Entity(new Position(1, 1));
        Storage instance = new Storage();
        instance.put(expResult);
        Entity result = instance.getEntity();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFree method, of class Storage.
     */
    @Test
    public void testStorageIsFree() {
        System.out.println("isFree");
        Storage instance = new Storage();
        boolean expResult = true;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFree method, of class Storage.
     */
    @Test
    public void testStorageIsNotFreeBox() {
        System.out.println("testStorageIsNotFree");
        Storage instance = new Storage(new Box(new Position(1, 1)));
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFree method, of class Storage.
     */
    @Test
    public void testStorageIsNotFreePlayer() {
        System.out.println("testStorageIsNotFree");
        Storage instance = new Storage(new Player(new Position(1, 1)));
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class Storage.
     */
    @Test
    public void testStoragePutPlayerEmpty() {
        System.out.println("testStoragePutPlayerEmpty");
        Player player = new Player(new Position(1, 1));
        Storage instance = new Storage();
        instance.put(player);
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class Storage.
     */
    @Test
    public void testStoragePutBoxEmpty() {
        System.out.println("testStoragePutBoxEmpty");
        Box box = new Box(new Position(1, 1));
        Storage instance = new Storage();
        instance.put(box);
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class Storage.
     */
    @Test
    public void testStoragePutEntityEmpty() {
        System.out.println("testStoragePutEntityEmpty");
        Entity entity = new Entity(new Position(1, 1));
        Storage instance = new Storage();
        instance.put(entity);
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class Storage.
     */
    @Test(expected = IllegalStateException.class)
    public void testStoragePutPlayerOccupiedBox() {
        System.out.println("testStoragePutPlayerOccupiedBox");
        Player player = new Player(new Position(1, 1));
        Storage instance = new Storage(new Box(new Position(1, 1)));
        instance.put(player);
    }

    /**
     * Test of put method, of class Storage.
     */
    @Test(expected = IllegalStateException.class)
    public void testStoragePutPlayerOccupiedPlayer() {
        System.out.println("testStoragePutPlayerOccupiedPlayer");
        Player player = new Player(new Position(1, 1));
        Storage instance = new Storage(new Player(new Position(1, 1)));
        instance.put(player);
    }

    /**
     * Test of put method, of class Storage.
     */
    @Test(expected = IllegalStateException.class)
    public void testStoragePutPlayerOccupiedEntity() {
        System.out.println("testStoragePutPlayerOccupiedEntity");
        Player player = new Player(new Position(1, 1));
        Storage instance = new Storage();
        instance.put(new Entity(new Position(1, 1)));
        instance.put(player);
    }

    /**
     * Test of put method, of class Storage.
     */
    @Test(expected = IllegalStateException.class)
    public void testStoragePutBoxOccupiedBox() {
        System.out.println("testStoragePutBoxOccupied");
        Box box = new Box(new Position(1, 1));
        Storage instance = new Storage(new Box(new Position(1, 1)));
        instance.put(box);
    }

    /**
     * Test of put method, of class Storage.
     */
    @Test(expected = IllegalStateException.class)
    public void testStoragePutBoxOccupiedPlayer() {
        System.out.println("testStoragePutBoxOccupiedPlayer");
        Box box = new Box(new Position(1, 1));
        Storage instance = new Storage(new Player(new Position(1, 1)));
        instance.put(box);
    }

    /**
     * Test of put method, of class Storage.
     */
    @Test(expected = IllegalStateException.class)
    public void testStoragePutBoxOccupiedEntity() {
        System.out.println("testStoragePutBoxOccupiedEntity");
        Box box = new Box(new Position(1, 1));
        Storage instance = new Storage();
        instance.put(new Entity(new Position(1, 1)));
        instance.put(box);
    }

    /**
     * Test of put method, of class Storage.
     */
    @Test(expected = IllegalStateException.class)
    public void testStoragePutEntityOccupiedBox() {
        System.out.println("testStoragePutEntityOccupied");
        Entity entity = new Entity(new Position(1, 1));
        Storage instance = new Storage(new Box(new Position(1, 1)));
        instance.put(entity);
    }

    /**
     * Test of put method, of class Storage.
     */
    @Test(expected = IllegalStateException.class)
    public void testStoragePutEntityOccupiedPlayer() {
        System.out.println("testStoragePutEntityOccupiedPlayer");
        Entity entity = new Entity(new Position(1, 1));
        Storage instance = new Storage(new Player(new Position(1, 1)));
        instance.put(entity);
    }

    /**
     * Test of put method, of class Storage.
     */
    @Test(expected = IllegalStateException.class)
    public void testStoragePutEntityOccupiedEntity() {
        System.out.println("testStoragePutEntityOccupiedEntity");
        Entity entity = new Entity(new Position(1, 1));
        Storage instance = new Storage();
        instance.put(new Entity(new Position(1, 1)));
        instance.put(entity);
    }

    /**
     * Test of remove method, of class Storage.
     */
    @Test(expected = IllegalStateException.class)
    public void testStorageRemove() {
        System.out.println("testStorageRemove");
        Storage instance = new Storage();
        instance.remove();
    }

    /**
     * Test of remove method, of class Storage.
     */
    @Test
    public void testStorageRemovePlayer() {
        System.out.println("testStorageRemovePlayer");
        Storage instance = new Storage(new Player(new Position(1, 1)));
        instance.remove();
        boolean expResult = true;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class Storage.
     */
    @Test
    public void testStorageRemoveBox() {
        System.out.println("testStorageRemoveBox");
        Storage instance = new Storage(new Box(new Position(1, 1)));
        instance.remove();
        boolean expResult = true;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class Storage.
     */
    @Test
    public void testStorageRemoveEntity() {
        System.out.println("testStorageRemoveEntity");
        Storage instance = new Storage();
        instance.put(new Entity(new Position(1, 1)));
        instance.remove();
        boolean expResult = true;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

}
