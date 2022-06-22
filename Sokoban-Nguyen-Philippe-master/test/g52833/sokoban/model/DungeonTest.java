package g52833.sokoban.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Binh-Philippe
 */
public class DungeonTest {

    /**
     * Test for the getWidth method from the class Dungeon.
     */
    @Test
    public void getWidth() {
        System.out.println("getWidth");
        Dungeon dungeon = new Dungeon();
        int result = dungeon.getWidth();
        assertEquals(11, result);
    }

    /**
     * Test for the getHeight method from the class Dungeon.
     */
    @Test
    public void getHeight() {
        System.out.println("getHeight");
        Dungeon dungeon = new Dungeon();
        int result = dungeon.getWidth();
        assertEquals(11, result);
    }

    /**
     * Test for the getSquare method from class Dungeon.
     */
    @Test
    public void getSquare() {
        System.out.println("getSquare");
        Dungeon dungeon = new Dungeon();
        Square result = dungeon.getSquare(new Position(0, 0));
        Square expected = new Square();
        assertEquals(expected, result);
    }

    /**
     * Test for the getSquare method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void getSquareExceptionX() {
        System.out.println("getSquareException");
        Dungeon dungeon = new Dungeon();
        Square result = dungeon.getSquare(new Position(12, 0));
        Square expected = new Square();
        assertEquals(expected, result);
    }

    /**
     * Test for the getSquare method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void getSquareExceptionY() {
        System.out.println("getSquareExceptionY");
        Dungeon dungeon = new Dungeon();
        Square result = dungeon.getSquare(new Position(0, 12));
        Square expected = new Square();
        assertEquals(expected, result);
    }

    /**
     * Test for the getSquare method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void getSquareExceptionXY() {
        System.out.println("getSquareExceptionXY");
        Dungeon dungeon = new Dungeon();
        Square result = dungeon.getSquare(new Position(12, 12));
        Square expected = new Square();
        assertEquals(expected, result);
    }

    /**
     * Test for the getSquare method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void getSquareExceptionXNegative() {
        System.out.println("getSquareExceptionXNegative");
        Dungeon dungeon = new Dungeon();
        Square result = dungeon.getSquare(new Position(-2, 0));
        Square expected = new Square();
        assertEquals(expected, result);
    }

    /**
     * Test for the getSquare method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void getSquareExceptionYNegative() {
        System.out.println("getSquareExceptionYNegative");
        Dungeon dungeon = new Dungeon();
        Square result = dungeon.getSquare(new Position(0, -2));
        Square expected = new Square();
        assertEquals(expected, result);
    }

    /**
     * Test for the getSquare method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void getSquareExceptionXYNegative() {
        System.out.println("getSquareExceptionXYNegative");
        Dungeon dungeon = new Dungeon();
        Square result = dungeon.getSquare(new Position(-1, -2));
        Square expected = new Square();
        assertEquals(expected, result);
    }

    /**
     * Test for the setSquare method from class Dungeon.
     */
    @Test
    public void setSquareFloorWithBox() {
        System.out.println("setSquareFloorWithBox");
        Dungeon dungeon = new Dungeon();
        Square expected = new Floor(new Box(new Position(0, 0)));
        dungeon.setSquare(expected, new Position(0, 0));
        Square result = dungeon.getSquare(new Position(0, 0));
        assertEquals(expected, result);
    }

    /**
     * Test for the setSquare method from class Dungeon.
     */
    @Test
    public void setSquareFloor() {
        System.out.println("setSquareFloor");
        Dungeon dungeon = new Dungeon();
        Square expected = new Floor();
        dungeon.setSquare(expected, new Position(0, 0));
        Square result = dungeon.getSquare(new Position(0, 0));
        assertEquals(expected, result);
    }

    /**
     * Test for the setSquare method from class Dungeon.
     */
    @Test
    public void setSquareWall() {
        System.out.println("setSquareWall");
        Dungeon dungeon = new Dungeon();
        Square expected = new Wall();
        dungeon.setSquare(expected, new Position(0, 0));
        Square result = dungeon.getSquare(new Position(0, 0));
        assertEquals(expected, result);
    }

    /**
     * Test for the setSquare method from class Dungeon.
     */
    @Test
    public void setSquarePlayer() {
        System.out.println("setSquarePlayer");
        Dungeon dungeon = new Dungeon();
        Square expected = new Floor(new Player(new Position(0, 0)));
        dungeon.setSquare(expected, new Position(0, 0));
        Square result = dungeon.getSquare(new Position(0, 0));
        assertEquals(expected, result);
    }

    /**
     * Test for the setSquare method from class Dungeon.
     */
    @Test
    public void setSquareStorageWithPlayer() {
        System.out.println("setSquareStorageWithPlayer");
        Dungeon dungeon = new Dungeon();
        Square expected = new Storage(new Player(new Position(0, 0)));
        dungeon.setSquare(expected, new Position(0, 0));
        Square result = dungeon.getSquare(new Position(0, 0));
        assertEquals(expected, result);
    }

    /**
     * Test for the setSquare method from class Dungeon.
     */
    @Test
    public void setSquareStorage() {
        System.out.println("setSquareStorage");
        Dungeon dungeon = new Dungeon();
        Square expected = new Storage();
        dungeon.setSquare(expected, new Position(0, 0));
        Square result = dungeon.getSquare(new Position(0, 0));
        assertEquals(expected, result);
    }

    /**
     * Test for the setSquare method from class Dungeon.
     */
    @Test
    public void setSquareStorageWithBox() {
        System.out.println("setSquareStorageWithBox");
        Dungeon dungeon = new Dungeon();
        Square expected = new Storage(new Box(new Position(0, 0)));
        dungeon.setSquare(expected, new Position(0, 0));
        Square result = dungeon.getSquare(new Position(0, 0));
        assertEquals(expected, result);
    }

    /**
     * Test for the put method from class Dungeon.
     */
    @Test
    public void putPlayer() {
        System.out.println("putPlayer");
        Dungeon dungeon = new Dungeon();
        Entity expected = new Player(new Position(0, 0));
        dungeon.put(expected, new Position(0, 0));
        Entity result = dungeon.getEntity(new Position(0, 0));
        assertEquals(expected, result);
    }

    /**
     * Test for the put method from class Dungeon.
     */
    @Test
    public void putBox() {
        System.out.println("putBox");
        Dungeon dungeon = new Dungeon();
        Entity expected = new Box(new Position(0, 0));
        dungeon.put(expected, new Position(0, 0));
        Entity result = dungeon.getEntity(new Position(0, 0));
        assertEquals(expected, result);
    }

    /**
     * Test for the put method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void putExceptionXOutOfBound() {
        System.out.println("putExceptionXOutOfBound");
        Dungeon dungeon = new Dungeon();
        Entity expected = new Box(new Position(0, 0));
        dungeon.put(expected, new Position(12, 0));
    }

    /**
     * Test for the put method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void putExceptionYOutOfBound() {
        System.out.println("putExceptionYOutOfBound");
        Dungeon dungeon = new Dungeon();
        Entity expected = new Box(new Position(0, 0));
        dungeon.put(expected, new Position(0, 12));
    }

    /**
     * Test for the put method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void putExceptionXYOutOfBound() {
        System.out.println("putExceptionXYOutOfBound");
        Dungeon dungeon = new Dungeon();
        Entity expected = new Box(new Position(0, 0));
        dungeon.put(expected, new Position(12, 12));
    }

    /**
     * Test for the put method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void putExceptionXNegative() {
        System.out.println("putExceptionXNegative");
        Dungeon dungeon = new Dungeon();
        Entity expected = new Box(new Position(0, 0));
        dungeon.put(expected, new Position(-1, 0));
    }

    /**
     * Test for the put method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void putExceptionYNegative() {
        System.out.println("putExceptionXNegative");
        Dungeon dungeon = new Dungeon();
        Entity expected = new Box(new Position(0, 0));
        dungeon.put(expected, new Position(0, -1));
    }

    /**
     * Test for the put method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void putExceptionXYNegative() {
        System.out.println("putExceptionXYNegative");
        Dungeon dungeon = new Dungeon();
        Entity expected = new Box(new Position(0, 0));
        dungeon.put(expected, new Position(-1, -1));
    }

    /**
     * Test for the getEntity method from class Dungeon.
     */
    @Test
    public void getEntityBox() {
        System.out.println("getEntityBox");
        Dungeon dungeon = new Dungeon();
        Entity expected = new Box(new Position(0, 0));
        dungeon.put(expected, new Position(0, 0));
        Entity result = dungeon.getEntity(new Position(0, 0));
        assertEquals(expected, result);
    }

    /**
     * Test for the getEntity method from class Dungeon.
     */
    @Test
    public void getEntityPlayer() {
        System.out.println("getEntityPlayer");
        Dungeon dungeon = new Dungeon();
        Entity expected = new Player(new Position(0, 0));
        dungeon.put(expected, new Position(0, 0));
        Entity result = dungeon.getEntity(new Position(0, 0));
        assertEquals(expected, result);
    }

    /**
     * Test for the getEntity method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEntityExceptionXOutOfBound() {
        System.out.println("getEntityExceptionXOutOfBound");
        Dungeon dungeon = new Dungeon();
        dungeon.getEntity(new Position(12, 0));
    }

    /**
     * Test for the getEntity method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEntityExceptionYOutOfBound() {
        System.out.println("getEntityExceptionYOutOfBound");
        Dungeon dungeon = new Dungeon();
        dungeon.getEntity(new Position(0, 12));
    }

    /**
     * Test for the getEntity method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEntityExceptionXYOutOfBound() {
        System.out.println("getEntityExceptionYOutOfBound");
        Dungeon dungeon = new Dungeon();
        dungeon.getEntity(new Position(12, 12));
    }

    /**
     * Test for the getEntity method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEntityExceptionXNegative() {
        System.out.println("getEntityExceptionXNegative");
        Dungeon dungeon = new Dungeon();
        dungeon.getEntity(new Position(-1, 0));
    }

    /**
     * Test for the getEntity method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEntityExceptionYNegative() {
        System.out.println("getEntityExceptionYNegative");
        Dungeon dungeon = new Dungeon();
        dungeon.getEntity(new Position(0, -1));
    }

    /**
     * Test for the getEntity method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void getEntityExceptionXYNegative() {
        System.out.println("getEntityExceptionXYNegative");
        Dungeon dungeon = new Dungeon();
        dungeon.getEntity(new Position(-1, -1));
    }

    /**
     * Test for the isFree method from class Dungeon.
     */
    @Test
    public void isFreeTrue() {
        System.out.println("isFreeTrue");
        Dungeon dungeon = new Dungeon();
        boolean result = dungeon.isFree(new Position(0, 0));
        assertEquals(true, result);
    }

    /**
     * Test for the isFree method from class Dungeon.
     */
    @Test
    public void isFreeBoxFalse() {
        System.out.println("isFreeBoxFalse");
        Dungeon dungeon = new Dungeon();
        dungeon.put(new Box(new Position(0, 0)), new Position(0, 0));
        boolean result = dungeon.isFree(new Position(0, 0));
        assertEquals(false, result);
    }

    /**
     * Test for the isFree method from class Dungeon.
     */
    @Test
    public void isFreePlayerFalse() {
        System.out.println("isFreePlayerFalse");
        Dungeon dungeon = new Dungeon();
        dungeon.put(new Player(new Position(0, 0)), new Position(0, 0));
        boolean result = dungeon.isFree(new Position(0, 0));
        assertEquals(false, result);
    }

    /**
     * Test for the isInside method from class Dungeon.
     */
    @Test
    public void isInsideTrue() {
        System.out.println("isInsideTrue");
        Dungeon dungeon = new Dungeon();
        boolean result = dungeon.isInside(new Position(5, 5));
        assertEquals(true, result);
    }

    /**
     * Test for the isInside method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void isInsideFalseXNegative() {
        System.out.println("isInsideFalseXNegative");
        Dungeon dungeon = new Dungeon();
        boolean result = dungeon.isInside(new Position(-1, 0));
    }

    /**
     * Test for the isInside method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void isInsideFalseYNegative() {
        System.out.println("isInsideFalseYNegative");
        Dungeon dungeon = new Dungeon();
        boolean result = dungeon.isInside(new Position(0, -1));
    }

    /**
     * Test for the isInside method from class Dungeon.
     */
    @Test(expected = IllegalArgumentException.class)
    public void isInsideFalseXYNegative() {
        System.out.println("isInsideFalseXYNegative");
        Dungeon dungeon = new Dungeon();
        boolean result = dungeon.isInside(new Position(-1, -1));

    }

    /**
     * Test for the isInside method from class Dungeon.
     */
    @Test
    public void isInsideFalseXOutOfBound() {
        System.out.println("isInsideFalseXOutOfBound");
        Dungeon dungeon = new Dungeon();
        boolean result = dungeon.isInside(new Position(12, 0));
        assertEquals(false, result);
    }

    /**
     * Test for the isInside method from class Dungeon.
     */
    @Test
    public void isInsideFalseYOutOfBound() {
        System.out.println("isInsideFalseYOutOfBound");
        Dungeon dungeon = new Dungeon();
        boolean result = dungeon.isInside(new Position(0, 13));
        assertEquals(false, result);
    }

    /**
     * Test for the isInside method from class Dungeon.
     */
    @Test
    public void isInsideFalseXYOutOfBound() {
        System.out.println("isInsideFalseXYOutOfBound");
        Dungeon dungeon = new Dungeon();
        boolean result = dungeon.isInside(new Position(12, 13));
        assertEquals(false, result);
    }

}
