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
    public void test2BlackPiecesTogetherAreProtectedBackward() {
        board.setRow(1, "wwbww-bww-");
        board.setRow(2, "----------");
        board.setRow(3, "----------");
        int threw = 1;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(7, 6)));
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
    public void test2WhitePiecesTogetherAreProtectedBackward() {
        board.setRow(1, "bbwbb-wbb-");
        board.setRow(2, "----------");
        board.setRow(3, "----------");
        int threw = 1;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.WHITES_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(7, 6)));
    }
    
    @Test
    public void testAPieceInHouse26IsAlwaysProtected() {
        board.setRow(1, "----------");
        board.setRow(2, "----------");
        board.setRow(3, "---b-w----");
        int threw = 2;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(24, 22)));
    }



    @Test
    public void test3PiecesAreBlockingWall() {
        board.setRow(1, "bwww-bw---");
        board.setRow(2, "----------");
        board.setRow(3, "----------");
        int threw = 4;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(6, 10)));
    }

    @Test
    public void test3PiecesAreBlockingWall2() {
        board.setRow(1, "bwww--bw--");
        board.setRow(2, "----------");
        board.setRow(3, "----------");
        int threw = 5;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(7, 12)));
    }

    @Test
    public void test3PiecesAreBlockingWallBackward() {
        board.setRow(1, "-www-b---w");
        board.setRow(2, "--------ww");
        board.setRow(3, "----------");
        int threw = 4;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(0, list.size());
        
    }

    @Test
    public void test3WhitePiecesAreBlockingWall() {
        board.setRow(1, "wbbb-wb---");
        board.setRow(2, "----------");
        board.setRow(3, "----------");
        int threw = 4;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.WHITES_TURN);

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
    public void testThisIsNotABlockingWall2() {
        board.setRow(1, "bww-w-----");
        board.setRow(2, "----------");
        board.setRow(3, "----------");
        int threw = 5;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(1, 6)));
    }

    @Test
    public void testShouldPlayAgainOnSomeThrewResult() {
        assertTrue(rules.isPlayAgain(1));
        assertTrue(rules.isPlayAgain(4));
        assertTrue(rules.isPlayAgain(5));

        assertFalse(rules.isPlayAgain(2));
        assertFalse(rules.isPlayAgain(3));
    }

    @Test
    public void testShouldPlayBackward() {
        board.setRow(1, "------b-ww");
        board.setRow(2, "----------");
        board.setRow(3, "----------");
        int threw = 2;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(7, 5)));
    }

    @Test
    public void testShouldPlayBackward2() {
        board.setRow(1, "----w-b-ww");
        board.setRow(2, "----------");
        board.setRow(3, "----------");
        int threw = 2;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(7, 5)));
    }

    @Test
    public void testCannotPlayOutOfTheBeginingOfTheBoard() {
        board.setRow(1, "-b-ww-----");
        board.setRow(2, "----------");
        board.setRow(3, "----------");
        int threw = 2;
        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(0, list.size());
    }

    @Test
    public void testNoLegalMoves() {
        board.setRow(1, "-b-ww-b-b-");
        board.setRow(2, "--------ww");
        board.setRow(3, "----------");
        int threw = 2;

        assertEquals(true, rules.noLegalMoves(board, threw, Game.BLACKS_TURN));
    }

    @Test
    public void testLegalMoves() {
        board.setRow(1, "-b-ww-b-b-");
        board.setRow(2, "---b----ww");
        board.setRow(3, "----------");
        int threw = 2;

        assertEquals(false, rules.noLegalMoves(board, threw, Game.BLACKS_TURN));
    }

    @Test
    public void testYouCannotPassTheHouseOfGood() {
        board.setRow(1, "----------");
        board.setRow(2, "----------");
        board.setRow(3, "-b--------");
        int threw = 5;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(22, 17)));
    }

    @Test
    public void testYouCannotPassTheHouseOfGood2() {
        board.setRow(1, "----------");
        board.setRow(2, "----------");
        board.setRow(3, "--b-------");
        int threw = 4;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(23, 19)));
    }

    @Test
    public void testYouCannotPassTheHouseOfGood3() {
        board.setRow(1, "----------");
        board.setRow(2, "----------");
        board.setRow(3, "---b------");
        int threw = 4;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(24, 20)));
    }

    @Test
    public void testYouCannotPassTheHouseOfGood4() {
        board.setRow(1, "----------");
        board.setRow(2, "----------");
        board.setRow(3, "----b-----");
        int threw = 2;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(25, 23)));
    }

    @Test
    public void testWeLandTheHouseOfGoodByAnExactThrow() {
        board.setRow(1, "----------");
        board.setRow(2, "----------");
        board.setRow(3, "----b-----");
        int threw = 1;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(25, 26)));
    }

    @Test
    public void testGoToTheWater() {
        board.setRow(1, "----------");
        board.setRow(2, "----------");
        board.setRow(3, "-----b----");
        int threw = 1;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(26, 27)));
    }

    @Test
    public void testIsGoingToTheWater() {
        assertEquals(true, rules.isGoingToTheWater(26, 27));
        assertEquals(false, rules.isGoingToTheWater(25, 26));
        assertEquals(true, rules.isGoingToTheWater(29, 26));
    }

    @Test
    public void testResurrection() {
        board.setRow(1, "----------");
        board.setRow(2, "----------");
        board.setRow(3, "-----b----");

        int house = rules.getResurrectionHouse(board);
        assertEquals(15, house);
    }

    @Test
    public void testResurrection2() {
        board.setRow(1, "----------");
        board.setRow(2, "-----w----");
        board.setRow(3, "-----b----");

        int house = rules.getResurrectionHouse(board);
        assertEquals(16, house);
    }

    @Test
    public void testResurrection3() {
        board.setRow(1, "----------");
        board.setRow(2, "-----b----");
        board.setRow(3, "-----b----");

        int house = rules.getResurrectionHouse(board);
        assertEquals(16, house);
    }

    @Test
    public void testResurrection4() {
        board.setRow(1, "----------");
        board.setRow(2, "----ww----");
        board.setRow(3, "-----b----");

        int house = rules.getResurrectionHouse(board);
        assertEquals(17, house);
    }

    @Test
    public void testResurrection5() {
        board.setRow(1, "----------");
        board.setRow(2, "wwwwww----");
        board.setRow(3, "w----b----");

        int house = rules.getResurrectionHouse(board);
        assertEquals(22, house);
    }

    @Test
    public void testExitFromHouse30Black() {
        board.setRow(1, "----------");
        board.setRow(2, "----------");
        board.setRow(3, "---------b");
        int threw = 1;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(30, 0)));
    }

    @Test
    public void testExitFromHouse30White() {
        board.setRow(1, "----------");
        board.setRow(2, "----------");
        board.setRow(3, "---------w");
        int threw = 1;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.WHITES_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(30, 0)));
    }
    
    @Test
    public void testExitFromHouse29Black() {
        board.setRow(1, "----------");
        board.setRow(2, "----------");
        board.setRow(3, "--------b-");
        int threw = 2;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(29, 0)));
    }

    @Test
    public void testExitFromHouse28Black() {
        board.setRow(1, "----------");
        board.setRow(2, "----------");
        board.setRow(3, "-------b--");
        int threw = 3;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(28, 0)));
    }

    @Test
    public void testExitFromHouse26Black() {
        board.setRow(1, "----------");
        board.setRow(2, "----------");
        board.setRow(3, "-----b----");
        int threw = 5;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(26, 0)));
    }

    /***************** Bugs seen during development time ******************/
    
    @Test
    public void testMove1() {
        board.setRow(1, "---------b");
        board.setRow(2, "---w------");
        board.setRow(3, "w---ww-b-b");
        int threw = 4;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.WHITES_TURN);
   
        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(26, 30)));
    }

    @Test
    public void testMove2() {
        board.setRow(1, "----------");
        board.setRow(2, "w-w-------");
        board.setRow(3, "b--bbw-w-w");
        int threw = 5;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.BLACKS_TURN);

        assertEquals(3, list.size());
        assertTrue(list.contains(new Move(25, 20)));
        assertTrue(list.contains(new Move(24, 19)));
        assertTrue(list.contains(new Move(21, 16)));
    }

    @Test
    public void testMove3() {
        board.setRow(1, "----------");
        board.setRow(2, "----------");
        board.setRow(3, "-------bw-");
        int threw = 3;

        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, Game.WHITES_TURN);

        assertEquals(1, list.size());
        assertTrue(list.contains(new Move(29, 26)));
    }
}