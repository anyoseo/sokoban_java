package g52833.sokoban.model;

import java.io.IOException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for Game class.
 *
 * @author G52833
 */
public class GameTest {

    @Test
    public void testGetLevel() {
        System.out.println("testGetLevel");
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        String expResult = "0";
        String result = instance.getLevel();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntity method, of class Game.
     */
    @Test
    public void testGetEntityBox() {
        System.out.println("testGetEntityBox");
        int x = 2;
        int y = 2;
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        Box expResult = new Box(new Position(2, 2));
        Entity result = instance.getEntity(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntity method, of class Game.
     */
    @Test
    public void testGetEntityPlayer() {
        System.out.println("testGetEntityPlayer");
        int x = 2;
        int y = 4;
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        Player expResult = new Player(new Position(2, 4));
        Entity result = instance.getEntity(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSquare method, of class Game.
     */
    @Test
    public void testGetSquareFloor() {
        System.out.println("testGetSquareFloor");
        int x = 2;
        int y = 3;
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        Floor expResult = new Floor();
        Square result = instance.getSquare(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSquare method, of class Game.
     */
    @Test
    public void testGetSquareWall() {
        System.out.println("getSquareWall");
        int x = 0;
        int y = 0;
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        Wall expResult = new Wall();
        Square result = instance.getSquare(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSquare method, of class Game.
     */
    @Test
    public void testGetSquareWithPlayer() {
        System.out.println("testGetSquareWithPlayer");
        int x = 2;
        int y = 4;
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        Floor expResult = new Floor(new Player(new Position(2, 4)));
        Square result = instance.getSquare(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSquare method, of class Game.
     */
    @Test
    public void testGetSquareWithBox() {
        System.out.println("testGetSquareWithBox");
        int x = 2;
        int y = 5;
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        Floor expResult = new Floor(new Box(new Position(2, 5)));
        Square result = instance.getSquare(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSquare method, of class Game.
     */
    @Test
    public void testGetSquareStorage() {
        System.out.println("testGetSquareStorage");
        int x = 2;
        int y = 1;
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        Storage expResult = new Storage();
        Square result = instance.getSquare(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSquare method, of class Game.
     */
    @Test
    public void testGetSquareStorageWithBox() {
        System.out.println("testGetSquareStorageWithBox");
        int x = 2;
        int y = 1;
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        Storage expResult = new Storage(new Box(new Position(2, 1)));
        Square result = instance.getSquare(x, y);
        result.put(new Box(new Position(2, 1)));
        assertEquals(expResult, result);
    }

    /**
     * Test of getSquare method, of class Game.
     */
    @Test
    public void testGetSquareStorageWithPlayer() {
        System.out.println("testGetSquareStorageWithPlayer");
        int x = 2;
        int y = 1;
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        Storage expResult = new Storage(new Player(new Position(2, 1)));
        Square result = instance.getSquare(x, y);
        result.put(new Player(new Position(2, 1)));
        assertEquals(expResult, result);
    }

    /**
     * Test of dungeonLength method, of class Game.
     */
    @Test
    public void testDungeonLength() {
        System.out.println("testDungeonLength");
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        int expResult = 11;
        int result = instance.dungeonLength();
        assertEquals(expResult, result);
    }

    /**
     * Test of resetAll method, of class Game.
     */
    @Test
    public void testResetAll() {
        System.out.println("testResetAll");
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        instance.resetAll();
        assertNull(instance.getLevel());

    }

    /**
     * Test of restart method, of class Game.
     */
    @Test
    public void testRestart() {
        System.out.println("testRestart");
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        instance.restart();
        int expResult = 0;
        int result = instance.nbMoves();
        assertEquals(expResult, result);
    }

    /**
     * Test of loadLevel method, of class Game.
     */
    @Test
    public void testLoadLevel() throws Exception {
        System.out.println("testLoadLevel");
        Game instance = new Game();
        instance.loadLevel("0");

    }

    /**
     * Test of loadLevel method, of class Game.
     */
    @Test(expected = IOException.class)
    public void testLoadLevelNotFound() throws Exception {
        System.out.println("testLoadLevel");
        Game instance = new Game();
        instance.loadLevel("11");

    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveRight() {
        System.out.println("testMoveRight");
        Direction direction = Direction.RIGHT;
        Game instance = new Game();
        try {
            instance.loadLevel("7");
        } catch (IOException ex) {
        }
        instance.move(direction);
        Floor expResult = new Floor(new Player(new Position(8, 3)));
        Square result = instance.getSquare(8, 3);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveLeft() {
        System.out.println("testMoveLeft");
        Direction direction = Direction.LEFT;
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        instance.move(direction);
        Floor expResult = new Floor(new Player(new Position(2, 3)));
        Square result = instance.getSquare(2, 3);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveUp() {
        System.out.println("testMoveUp");
        Direction direction = Direction.UP;
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        instance.move(direction);
        Floor expResult = new Floor(new Player(new Position(1, 4)));
        Square result = instance.getSquare(1, 4);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveDown() {
        System.out.println("testMoveDown");
        Direction direction = Direction.DOWN;
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        instance.move(direction);
        Floor expResult = new Floor(new Player(new Position(3, 4)));
        Square result = instance.getSquare(3, 4);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveDownWithBox() {
        System.out.println("testMoveDownWithBox");
        Direction direction = Direction.DOWN;
        Game instance = new Game();
        try {
            instance.loadLevel("3");
        } catch (IOException ex) {
        }
        instance.move(direction);
        Floor expResult = new Floor(new Box(new Position(3, 6)));
        Square result = instance.getSquare(3, 6);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveUpWithBox() {
        System.out.println("testMoveUpWithBox");
        Direction direction = Direction.UP;
        Game instance = new Game();
        try {
            instance.loadLevel("7");
        } catch (IOException ex) {
        }
        instance.move(direction);
        Floor expResult = new Floor(new Box(new Position(6, 2)));
        Square result = instance.getSquare(6, 2);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveLeftWithBox() {
        System.out.println("testMoveLeftWithBox");
        Direction direction = Direction.LEFT;
        Game instance = new Game();
        try {
            instance.loadLevel("3");
        } catch (IOException ex) {
        }
        instance.move(direction);
        Floor expResult = new Floor(new Box(new Position(1, 4)));
        Square result = instance.getSquare(1, 4);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveRightWithBox() {
        System.out.println("testMoveRightWithBox");
        Direction direction = Direction.RIGHT;
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        instance.move(direction);
        Storage expResult = new Storage(new Box(new Position(2, 6)));
        Square result = instance.getSquare(2, 6);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveRightWall() {
        System.out.println("testMoveRightWall");
        Direction direction = Direction.RIGHT;
        Game instance = new Game();
        try {
            instance.loadLevel("3");
        } catch (IOException ex) {
        }
        instance.move(direction);
        Floor expResult = new Floor(new Player(new Position(1, 6)));
        Square result = instance.getSquare(1, 6);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveUpWall() {
        System.out.println("testMoveUpWall");
        Direction direction = Direction.UP;
        Game instance = new Game();
        try {
            instance.loadLevel("3");
        } catch (IOException ex) {
        }
        instance.move(direction);
        Floor expResult = new Floor(new Player(new Position(1, 6)));
        Square result = instance.getSquare(1, 6);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveDownWall() {
        System.out.println("testMoveDownWall");
        Direction direction = Direction.DOWN;
        Game instance = new Game();
        try {
            instance.loadLevel("7");
        } catch (IOException ex) {
        }
        instance.move(direction);
        Floor expResult = new Floor(new Player(new Position(8, 2)));
        Square result = instance.getSquare(8, 2);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveLeftWall() {
        System.out.println("testMoveLeftWall");
        Direction direction = Direction.LEFT;
        Game instance = new Game();
        try {
            instance.loadLevel("7");
        } catch (IOException ex) {
        }
        instance.move(direction);
        Floor expResult = new Floor(new Player(new Position(8, 2)));
        Square result = instance.getSquare(8, 2);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveLeftStorage() {
        System.out.println("testMoveLeftStorage");
        Direction direction = Direction.LEFT;
        Game instance = new Game();
        try {
            instance.loadLevel("8");
        } catch (IOException ex) {
        }
        instance.move(direction);
        Storage expResult = new Storage(new Player(new Position(1, 5)));
        Square result = instance.getSquare(1, 5);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveDownStorage() {
        System.out.println("testMoveDownStorage");
        Direction direction = Direction.DOWN;
        Game instance = new Game();
        try {
            instance.loadLevel("8");
        } catch (IOException ex) {
        }
        instance.move(direction);
        Storage expResult = new Storage(new Player(new Position(2, 6)));
        Square result = instance.getSquare(2, 6);
        assertEquals(expResult, result);
    }

    /**
     * Test of levelComplete method, of class Game.
     */
    @Test
    public void testLevelNotComplete() {
        System.out.println("testLevelNotComplete");
        Game game = new Game();
        try {
            game.loadLevel("0");
        } catch (IOException ex) {
        }
        System.out.println("testExecuteRightWithBox");
        boolean expResult = false;
        boolean result = game.levelComplete();
        assertEquals(expResult, result);

    }

    /**
     * Test of levelComplete method, of class Game.
     */
    @Test
    public void testLevelComplete() {
        System.out.println("levelComplete");
        Game game = new Game();
        try {
            game.loadLevel("0");
        } catch (IOException ex) {
        }
        System.out.println("testExecuteRightWithBox");
        game.move(Direction.RIGHT);
        game.move(Direction.LEFT);
        game.move(Direction.LEFT);
        game.move(Direction.LEFT);
        boolean expResult = true;
        boolean result = game.levelComplete();
        assertEquals(expResult, result);

    }

    /**
     * Test of nbMoves method, of class Game.
     */
    @Test
    public void testNbMoves() {
        System.out.println("testNbMoves");
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        instance.move(Direction.DOWN);
        int expResult = 1;
        int result = instance.nbMoves();
        assertEquals(expResult, result);
    }

    /**
     * Test of nbMoves method, of class Game.
     */
    @Test
    public void testNbMovesZero() {
        System.out.println("testNbMovesZero");
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        int expResult = 0;
        int result = instance.nbMoves();
        assertEquals(expResult, result);
    }

    /**
     * Test of undo method, of class Game.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        instance.move(Direction.DOWN);
        instance.undo();
        boolean expResult = false;
        boolean result = instance.getSquare(2, 4).isFree();
        assertEquals(expResult, result);
        instance.undo();
    }

    /**
     * Test of redo method, of class Game.
     */
    @Test
    public void testRedo() {
        System.out.println("redo");
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        instance.move(Direction.DOWN);
        instance.undo();
        instance.redo();
        boolean expResult = false;
        boolean result = instance.getSquare(2, 5).isFree();
        assertEquals(expResult, result);

    }

    /**
     * Test for objectif method from Game class.
     */
    @Test
    public void testObjectif() {
        System.out.println("testObjectif");
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        int result = instance.objectif();
        assertEquals(2, result);
    }

    /**
     * Test for objectif method from Game class.
     */
    @Test
    public void testObjectifReached() {
        System.out.println("testObjectifReached");
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        instance.move(Direction.RIGHT);
        instance.move(Direction.LEFT);
        instance.move(Direction.LEFT);
        instance.move(Direction.LEFT);
        int result = instance.objectif();
        assertEquals(2, result);
    }

    /**
     *
     * Test for historyUndo method from Game class.
     */
    @Test
    public void testHistoryUndo() {
        System.out.println("testHistoryUndo");
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        instance.move(Direction.RIGHT);
        List<MoveCommand> list = instance.historyUndo();
        int result = list.size();
        int expected = 1;
        assertEquals(expected, result);
    }

    /**
     *
     * Test for historyRedo method from Game class.
     */
    @Test
    public void testHistoryRedo() {
        System.out.println("testHistoryRedo");
        Game instance = new Game();
        try {
            instance.loadLevel("0");
        } catch (IOException ex) {
        }
        instance.move(Direction.RIGHT);
        instance.undo();
        List<MoveCommand> list = instance.historyRedo();
        int result = list.size();
        int expected = 1;
        assertEquals(expected, result);
    }

}
