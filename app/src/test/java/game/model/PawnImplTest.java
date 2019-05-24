package game.model;

import org.junit.Test;

import game.gameExceptions.PawnCannotMoveException;

import static org.junit.Assert.*;

public class PawnImplTest {

    Pawn pawn = new PawnImpl(PawnColor.Red);

    @Test
    public void newPawnImpl(){
        assertNotNull(new PawnImpl(PawnColor.Red));
    }

    @Test
    public void getIndexAtIndex() {
        for (int i = 0; i < 4; i++) {
            assertEquals(0, pawn.getIndexAtIndex(i));
        }
    }

    @Test
    public void getColor() {
        assertEquals(PawnColor.Red,pawn.getColor());
    }

    @Test
    public void getsEaten() {
        pawn.getsEaten(0);
        assertEquals(0,pawn.getIndexAtIndex(0));
    }

    @Test
    public void movePawn() {
        pawn.movePawn(6,0);
        assertEquals(6,pawn.getIndexAtIndex(0));
    }

    @Test
    public void canMoveSpecificPawn1() {
        assertEquals(false,pawn.canMoveSpecificPawn(1,0));
    }
    @Test
    public void canMoveSpecificPawn6() {
        assertEquals(true,pawn.canMoveSpecificPawn(6,0));
    }

    @Test
    public void canMove1() {
        for(int i=0;i<4;i++){
            assertEquals(false,pawn.canMoveSpecificPawn(1,i));
        }
    }

    @Test
    public void canMove6() {
        for(int i=0;i<4;i++){
            assertEquals(true,pawn.canMoveSpecificPawn(6,i));
        }
    }
}