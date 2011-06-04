package senet.game.element;

import senet.game.Move;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    private Board board;

    public BoardTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        board = new Board();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSetInitialPosition() {
        board.setInitialPosition();
        assertTrue(board.getBoxContent(1) == Board.BOX_WHITE);
        assertTrue(board.getBoxContent(3) == Board.BOX_WHITE);
        assertTrue(board.getBoxContent(5) == Board.BOX_WHITE);
        assertTrue(board.getBoxContent(7) == Board.BOX_WHITE);
        assertTrue(board.getBoxContent(9) == Board.BOX_WHITE);
        assertTrue(board.getBoxContent(2) == Board.BOX_BLACK);
        assertTrue(board.getBoxContent(4) == Board.BOX_BLACK);
        assertTrue(board.getBoxContent(6) == Board.BOX_BLACK);
        assertTrue(board.getBoxContent(8) == Board.BOX_BLACK);
        assertTrue(board.getBoxContent(10) == Board.BOX_BLACK);
        for(int i = 11; i <= 30; i++) {
            assertTrue(board.getBoxContent(i) == Board.BOX_VOID);
        }
    }

    @Test
    public void testGetBoxContent() {
        board.setInitialPosition();
        assertTrue(board.getBoxContent(1) == Board.BOX_WHITE);
        assertTrue(board.getBoxContent(2) == Board.BOX_BLACK);
        assertTrue(board.getBoxContent(11) == Board.BOX_VOID);
    }

    @Test
    public void testMoveFrom10To12() {
        board.setInitialPosition();
        board.move(new Move(10, 12));
        assertTrue(board.getBoxContent(10) == Board.BOX_VOID);
        assertTrue(board.getBoxContent(12) == Board.BOX_BLACK);
    }
}