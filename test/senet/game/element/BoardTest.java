package senet.game.element;

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
        assertTrue(board.boxes[0] == Board.BOX_WHITE);
        assertTrue(board.boxes[2] == Board.BOX_WHITE);
        assertTrue(board.boxes[4] == Board.BOX_WHITE);
        assertTrue(board.boxes[6] == Board.BOX_WHITE);
        assertTrue(board.boxes[8] == Board.BOX_WHITE);
        assertTrue(board.boxes[1] == Board.BOX_BLACK);
        assertTrue(board.boxes[3] == Board.BOX_BLACK);
        assertTrue(board.boxes[5] == Board.BOX_BLACK);
        assertTrue(board.boxes[7] == Board.BOX_BLACK);
        assertTrue(board.boxes[9] == Board.BOX_BLACK);
        for(int i = 10; i < 30; i++) {
            assertTrue(board.boxes[i] == Board.BOX_VOID);
        }
    }

    @Test
    public void testGetBoxContent() {
        board.setInitialPosition();
        assertTrue(board.getBoxContent(1) == Board.BOX_WHITE);
        assertTrue(board.getBoxContent(2) == Board.BOX_BLACK);
        assertTrue(board.getBoxContent(11) == Board.BOX_VOID);
    }

}