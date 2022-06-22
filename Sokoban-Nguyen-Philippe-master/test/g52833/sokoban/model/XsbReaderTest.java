package g52833.sokoban.model;

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Binh-Philippe
 */
public class XsbReaderTest {

    /**
     * Test of loadLevel method, of class Game.
     */
    @Test
    public void testLoadLevel() throws Exception {
        System.out.println("testLoadLevel");
        XsbReader instance = new XsbReader();
        Dungeon dungeon = new Dungeon();
        Player result = instance.loadLevel(dungeon, "0");
        Player expected = new Player(new Position(2, 4));
        assertEquals(expected, result);
    }

    /**
     * Test of loadLevel method, of class Game.
     */
    @Test(expected = IOException.class)
    public void testLoadLevelNotFound() throws Exception {
        System.out.println("testLoadLevelNotFound");
        XsbReader instance = new XsbReader();
        Dungeon dungeon = new Dungeon();
        instance.loadLevel(dungeon, "11");
    }
}
