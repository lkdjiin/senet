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
        
        turn = BLACKS_TURN;
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllLegalMovesAtStartingPositionWithAThrowOfOne() {
        board.setInitialPosition();
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
        board.setInitialPosition();
        int threw = 2;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, turn);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(10, 12)));
    }

    @Test
    public void testGetAllLegalMovesAtStartingPositionWithAThrowOfThree() {
        board.setInitialPosition();
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
        board.setInitialPosition();
        int threw = 4;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, turn);

        assertEquals(2, list.size());
        assertTrue(list.contains(new Move(10, 14)));
        assertTrue(list.contains(new Move(8, 12)));
    }

    @Test
    public void testGetAllLegalMovesAtStartingPositionWithAThrowOfFive() {
        board.setInitialPosition();
        int threw = 5;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, turn);

        assertEquals(5, list.size());
        assertTrue(list.contains(new Move(10, 15)));
        assertTrue(list.contains(new Move(8, 13)));
        assertTrue(list.contains(new Move(6, 11)));
        assertTrue(list.contains(new Move(4, 9)));
        assertTrue(list.contains(new Move(2, 7)));
    }

    @Test
    public void test2BlackPiecesTogetherAreProtected() {
        board.setRow(1, "b-ww-bw---");
        board.setRow(2, "----------");
        board.setRow(3, "----------");
        int threw = 2;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(6, 8)));
    }

    @Test
    public void test2WhitePiecesTogetherAreProtected() {
        board.setRow(1, "w-bb-wb---");
        board.setRow(2, "----------");
        board.setRow(3, "----------");
        int threw = 2;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.WHITES_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(6, 8)));
    }

    @Test
    public void test3BlackPiecesAreBlockingWall() {
        board.setRow(1, "bwww-bw---");
        board.setRow(2, "----------");
        board.setRow(3, "----------");
        int threw = 4;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(6, 10)));
    }

    @Test
    public void testThisIsNotABlockingWall() {
        board.setRow(1, "bww--bw---");
        board.setRow(2, "----------");
        board.setRow(3, "----------");
        int threw = 4;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(2, list.size());
        assertTrue(list.contains(new Move(1, 5)));
        assertTrue(list.contains(new Move(6, 10)));
    }

    @Test
    public void testShouldPlayAgainOnSomeThrewResult() {
        assertTrue(rules.isPlayAgain(1));
        assertTrue(rules.isPlayAgain(4));
        assertTrue(rules.isPlayAgain(5));

        assertFalse(rules.isPlayAgain(2));
        assertFalse(rules.isPlayAgain(3));
    }
}