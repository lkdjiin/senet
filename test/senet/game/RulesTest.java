package senet.game;

import senet.game.element.Board;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RulesTest {

    private static final boolean BLACKS_TURN = true;
    private static final boolean WHITES_TURN = false;

    private Rules rules;
    private Board board;
    private boolean turn;

    public RulesTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        rules = new Rules();
        board = new Board();
        board.setInitialPosition();
        turn = BLACKS_TURN;
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllLegalMovesAtStartingPositionWithAThrowOfOne() {
        int threw = 1;
        
        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, turn);

        assertEquals(5, list.size());
        assertTrue(list.contains(new Move(10, 11)));
        assertTrue(list.contains(new Move(8, 9)));
        assertTrue(list.contains(new Move(6, 7)));
        assertTrue(list.contains(new Move(4, 5)));
        assertTrue(list.contains(new Move(2, 3)));
    }

    @Test
    public void testGetAllLegalMovesAtStartingPositionWithAThrowOfTwo() {
        int threw = 2;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, turn);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(10, 12)));
    }

    @Test
    public void testGetAllLegalMovesAtStartingPositionWithAThrowOfThree() {
        int threw = 3;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, turn);

        assertEquals(5, list.size());
        assertTrue(list.contains(new Move(10, 13)));
        assertTrue(list.contains(new Move(8, 11)));
        assertTrue(list.contains(new Move(6, 9)));
        assertTrue(list.contains(new Move(4, 7)));
        assertTrue(list.contains(new Move(2, 5)));
    }

    @Test
    public void testGetAllLegalMovesAtStartingPositionWithAThrowOfFour() {
        int threw = 4;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, turn);

        assertEquals(2, list.size());
        assertTrue(list.contains(new Move(10, 14)));
        assertTrue(list.contains(new Move(8, 12)));
    }

    @Test
    public void testGetAllLegalMovesAtStartingPositionWithAThrowOfFive() {
        int threw = 5;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, turn);

        assertEquals(5, list.size());
        assertTrue(list.contains(new Move(10, 15)));
        assertTrue(list.contains(new Move(8, 13)));
        assertTrue(list.contains(new Move(6, 11)));
        assertTrue(list.contains(new Move(4, 9)));
        assertTrue(list.contains(new Move(2, 7)));
    }
}