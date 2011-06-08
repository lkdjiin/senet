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
    public void testToString() {
        board.setInitialPosition();
        String expected = "wbwbwbwbwb\n" + "----------\n" + "----------";
        assertEquals(expected, board.toString());
    }

    @Test
    public void testToString2() {
        board.boxes[10] = Board.BOX_BLACK;
        board.boxes[19] = Board.BOX_WHITE;
        String expected = "----------\n" + "w--------b\n" + "----------";
        assertEquals(expected, board.toString());
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

    @Test
    public void testSetFirstRow() {
        board.setRow(1, "w--------b");
        assertEquals("w--------b\n----------\n----------", board.toString());
    }

    @Test
    public void testSetFirstRow2() {
        // Should be same output as testSetFirstRow
        board.boxes[0] = Board.BOX_WHITE;
        board.boxes[9] = Board.BOX_BLACK;
        assertEquals("w--------b\n----------\n----------", board.toString());
    }

    @Test
    public void testSetSecondRow() {
        board.setRow(2, "w--------b");
        assertEquals("----------\nw--------b\n----------", board.toString());
    }

    @Test
    public void testSetSecondRow2() {
        // Should be same output as testSetSecondRow
        board.boxes[10] = Board.BOX_BLACK;
        board.boxes[19] = Board.BOX_WHITE;
        assertEquals("----------\nw--------b\n----------", board.toString());

    }

    @Test
    public void testSetThirdRow() {
        board.setRow(3, "w--------b");
        assertEquals("----------\n----------\nw--------b", board.toString());
    }

    @Test
    public void testSetThirdRow2() {
        // Should be same output as testSetThirdRow
        board.boxes[20] = Board.BOX_WHITE;
        board.boxes[29] = Board.BOX_BLACK;
        assertEquals("----------\n----------\nw--------b", board.toString());
    }

    @Test
    public void testIsBlackPieceInBox() {
        board.setInitialPosition();
        assertTrue(board.isBlackPieceInBox(2));
        assertFalse(board.isBlackPieceInBox(1));
        assertFalse(board.isBlackPieceInBox(23));
    }

    @Test
    public void testIsWhitePieceInBox() {
        board.setInitialPosition();
        assertTrue(board.isWhitePieceInBox(3));
        assertFalse(board.isWhitePieceInBox(4));
        assertFalse(board.isWhitePieceInBox(23));
    }

    @Test
    public void testIsVoidBox() {
        board.setInitialPosition();
        assertTrue(board.isVoidBox(23));
        assertFalse(board.isVoidBox(4));
        assertFalse(board.isVoidBox(5));
    }

    @Test
    public void testIsPieceInBox() {
        board.setInitialPosition();
        assertTrue(board.isPieceInBox(1, Board.BOX_WHITE));
        assertFalse(board.isPieceInBox(1, Board.BOX_BLACK));

        assertFalse(board.isPieceInBox(2, Board.BOX_WHITE));
        assertTrue(board.isPieceInBox(2, Board.BOX_BLACK));

        assertFalse(board.isPieceInBox(23, Board.BOX_WHITE));
        assertFalse(board.isPieceInBox(23, Board.BOX_BLACK));
    }
}