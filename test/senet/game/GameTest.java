package senet.game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import senet.game.element.Board;

public class GameTest {

    private Game game;

    public GameTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        game = new Game("player1", "player2");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSticksShouldNotBeThrowedAtBeginingOfTheGame() {
        assertFalse(game.isSticksThrowed());
    }

    @Test
    public void testSetSticksThrowed() {
        game.setSticksThrowed(true);
        assertTrue(game.isSticksThrowed());
        game.setSticksThrowed(false);
        assertFalse(game.isSticksThrowed());
    }

    @Test
    public void testGetBoard() {
        assertNotNull(game.getBoard());
    }

    @Test
    public void testItIsBlackTurnAtBegining() {
        assertTrue(game.isBlackTurn());
    }

    @Test
    public void testItIsNotWhiteTurnAtBegining() {
        assertFalse(game.isWhiteTurn());
    }

    @Test
    public void testGetMoveFromShouldReturnNullAtBegining() {
        assertNull(game.getMoveFrom());
    }

    @Test
    public void testSetMoveFrom() {
        game.setMoveFrom(12);
        assertTrue(12 == game.getMoveFrom());
    }

    @Test
    public void testIsBoxSelectable() {
        assertTrue(game.isBoxSelectable(10));
        assertFalse(game.isBoxSelectable(9));
        assertFalse(game.isBoxSelectable(30));
    }

    @Test
    public void testIsBoxVoid() {
        assertTrue(game.isBoxVoid(30));
        assertFalse(game.isBoxVoid(1));
    }

    @Test
    public void testMoveTo() {
        game.setMoveFrom(10);
        game.moveTo(12);
        assertTrue(game.isBoxVoid(10));
        assertTrue(game.getBoard().getBoxContent(12) == Board.BOX_BLACK);
    }

    @Test
    public void testNextTurn() {
        game.nextTurn();
        assertTrue(game.isWhiteTurn());
        assertNull(game.getMoveFrom());
        assertFalse(game.isSticksThrowed());
    }

    @Test
    public void testGetTurnAsText() {
        assertTrue(game.getTurnAsText().startsWith("Blacks Turn (player"));
    }

}