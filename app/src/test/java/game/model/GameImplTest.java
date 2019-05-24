package game.model;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class GameImplTest {

    Game game = new GameImpl();

    @Test
    public void newGameImpl() {
        assertNotNull(new GameImpl());
    }

    @Test
    public void saveField() {
        game.getPlayer(0).getPawns().movePawn(6,0);
        try {
            game.saveField("filename");
        } catch (FileNotFoundException e) {
            fail();
        }
    }

    @Test
    public void loadField() {
        game.getPlayer(0).getPawns().movePawn(6,0);
        try {
            game.saveField("filename");
            game.getPlayer(0).getPawns().movePawn(6,0);
            game.loadField("filename");
            assertEquals(6,game.getPlayer(0).getPawns().getIndexAtIndex(0));
        } catch (FileNotFoundException e) {
            fail();
        }
    }

    @Test
    public void eat() {
        game.getPlayer(0).getPawns().movePawn(6,0);
        game.getPlayer(1).getPawns().movePawn(6,0);
        game.getPlayer(1).getPawns().movePawn(6,0);
        game.getPlayer(1).getPawns().movePawn(6,0);
        game.getPlayer(1).getPawns().movePawn(6,0);
        game.getPlayer(1).getPawns().movePawn(2,0);
        game.eat(1,0);
        assertEquals(0,game.getPlayer(0).getPawns().getIndexAtIndex(0));
    }
}