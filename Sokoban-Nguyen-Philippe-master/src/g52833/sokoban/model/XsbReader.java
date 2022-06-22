package g52833.sokoban.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Binh-Philippe
 */
public class XsbReader {

    private final char PLAYER = '@';
    private final char FLOOR = ' ';
    private final char WALL = '#';
    private final char BOXSTORED = '*';
    private final char BOX = '$';
    private final char STORAGE = '.';
    private final char PLAYERSTORE = '+';

    void dungeonDimension() {

    }

    /**
     * Method which load the level of the game.
     *
     * @param dungeon the dungeon to initialize.
     * @param level the level to load.
     * @throws FileNotFoundException if the file cannot be found.
     * @throws IOException if an error occured.
     */
    Player loadLevel(Dungeon dungeon, String level)
            throws FileNotFoundException, IOException {
        Position position = null;
        Player p1 = null;
        BufferedReader file;
        file = new BufferedReader(new FileReader("level\\level" + level
                + ".xsb"));
        int i = 0;
        String line = file.readLine();
        while (line != null) {
            for (int j = 0; j < Math.min(11, line.length()); j++) {
                Square square = dungeon.getSquare(new Position(i, j));
                switch (line.charAt(j)) {
                    case PLAYER:
                        position = new Position(i, j);
                        p1 = new Player(position);
                        square = new Floor(p1);
                        dungeon.setSquare(square, position);
                        break;
                    case FLOOR:
                        square = new Floor();
                        dungeon.setSquare(square, new Position(i, j));
                        break;
                    case WALL:
                        square = new Wall();
                        dungeon.setSquare(square, new Position(i, j));
                        break;
                    case BOXSTORED:
                        square = new Storage(new Box(new Position(i, j)));
                        dungeon.setSquare(square, new Position(i, j));
                        break;
                    case BOX:
                        square = new Floor(new Box(new Position(i, j)));
                        dungeon.setSquare(square, new Position(i, j));
                        break;
                    case STORAGE:
                        square = new Storage();
                        dungeon.setSquare(square, new Position(i, j));
                        break;
                    case PLAYERSTORE:
                        position = new Position(i, j);
                        p1 = new Player(position);
                        square = new Floor(p1);
                        dungeon.setSquare(square, new Position(i, j));
                        break;
                }
                for (int k = Math.min(11, line.length()); k < 11; k++) {
                    square = dungeon.getSquare(new Position(i, k));
                    square = new Square();
                    dungeon.setSquare(square, new Position(i, k));
                }
            }
            i++;
            line = file.readLine();
        }
        file.close();
        return p1;
    }

}
