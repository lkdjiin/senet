package senet.game;

import java.util.ArrayList;
import senet.game.element.*;

/**
 * Course of the game.
 */
public class Game {

    public static final boolean BLACKS_TURN = true;
    public static final boolean WHITES_TURN = false;

    private Board board;
    private boolean sticksThrowed;
    private String blackPlayer;
    private String whitePlayer;
    private boolean blackTurn = true;
    private Integer moveFrom;
    private Rules rules;

    /**
     * Create a new game with two human players.
     * @param player1Name the name of the first human player
     * @param player2Name the name of the second human player
     */
    public Game(String player1Name, String player2Name) {
        board = new Board();
        rules = new Rules();
        int random = (int) (Math.random() * 2);
        if(random == 0) {
            blackPlayer = player1Name;
            whitePlayer = player2Name;
        } else {
            blackPlayer = player2Name;
            whitePlayer = player1Name;
        }
        blackTurn = true;
        board.setInitialPosition();
        moveFrom = null;
        sticksThrowed = false;
    }

    public void nextTurn() {
        blackTurn = ! blackTurn;
        moveFrom = null;
        sticksThrowed = false;
    }

    /**
     * @todo refactor: same as nextTurn
     */
    public void sameTurn() {
        moveFrom = null;
        sticksThrowed = false;
    }

    public boolean isSticksThrowed() {
        return sticksThrowed;
    }

    public void setSticksThrowed(boolean sticksThrowed) {
        this.sticksThrowed = sticksThrowed;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isBlacksTurn() {
        return blackTurn;
    }

    public boolean isWhitesTurn() {
        return ! blackTurn;
    }

    /**
     * Get the starting box for the move, that is the box the
     * player have selected.
     * @return a box id (1 - 30)
     */
    public Integer getMoveFrom() {
        return moveFrom;
    }

    /**
     * Set the starting box for the move.
     * @param moveFrom a box id (1 - 30)
     */
    public void setMoveFrom(Integer moveFrom) {
        this.moveFrom = moveFrom;
    }

    /**
     * Returns true if this box can be selected as a valid starting point for
     * a move by the current player.
     * @param id a box id (1 - 30)
     */
    public boolean isBoxSelectable(int id, int threw) {
        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, getTurn());
        for(Move e : list) {
            if(e.getFrom() == id)
                return true;
        }
        return false;
    }

    /**
     * Check if it is legal to move to the house +id+.
     * @param id The house we want to move to.
     * @param threw the result of threw sticks
     * @return true if this move is legal
     */
    public boolean isLegalToMoveTo(int id, int threw) {
        ArrayList<Move> list = rules.getAllLegalMoves(board, threw, getTurn());
        for(Move e : list) {
            if(e.equals(new Move(getMoveFrom(), id)))
                return true;
        }
        return false;
    }

    public boolean noLegalMove(int threw) {
        return rules.noLegalMoves(board, threw, getTurn());
    }

    /**
     * Returns true if this box doesn't contain any piece.
     * @param id a box id (1 - 30)
     */
    public boolean isBoxVoid(int id) {
        return board.getBoxContent(id) == Board.BOX_VOID;
    }

    /**
     * Make a move from the previously setted starting box ({@link #setMoveFrom}) to
     * the ending box given as parameter.
     * <p>
     * The move is supposed to be a legal one, no checks are performed.
     * @param id the ending box of the move
     */
    public void moveTo(int id) {
        board.move(new Move(moveFrom, id));
    }

    public void moveOut() {
        board.move(new Move(moveFrom, 0));
    }

    /**
     * Returns a human readeable string telling what turn is it.
     */
    public String getTurnAsText() {
        if(isBlacksTurn())
            return "Blacks Turn (" + blackPlayer + ")";
        else
            return "Whites Turn (" + whitePlayer + ")";
    }

    public boolean getTurn() {
        return blackTurn;
    }

    public boolean isPlayAgain(int threw) {
        return rules.isPlayAgain(threw);
    }

    public boolean isGoingToTheWater(int id) {
        return rules.isGoingToTheWater(id);
    }

    public int getResurrectionHouse() {
        return rules.getResurrectionHouse(board);
    }

    public boolean canMoveOut(int id, int threw) {
        return rules.canMoveOut(id, threw);
    }
}
