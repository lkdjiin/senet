package senet.game;

import senet.game.element.*;

/**
 * Course of the game.
 */
public class Game {

    private Board board;
    private boolean sticksThrowed;
    private String blackPlayer;
    private String whitePlayer;
    private boolean blackTurn = true;
    private Integer moveFrom;

    /**
     * Create a new game with two human players.
     * @param player1Name the name of the first human player
     * @param player2Name the name of the second human player
     */
    public Game(String player1Name, String player2Name) {
        board = new Board();
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

    public boolean isSticksThrowed() {
        return sticksThrowed;
    }

    public void setSticksThrowed(boolean sticksThrowed) {
        this.sticksThrowed = sticksThrowed;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isBlackTurn() {
        return blackTurn;
    }

    public boolean isWhiteTurn() {
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
    public boolean isBoxSelectable(int id) {
        return (isBlackTurn() && board.getBoxContent(id) == Board.BOX_BLACK)
                    || (isWhiteTurn() && board.getBoxContent(id) == Board.BOX_WHITE);
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
     * @param id the ending box of the move
     */
    public void moveTo(int id) {
        board.move(new Move(moveFrom, id));
    }

    /**
     * Returns a human readeable string telling what turn is it.
     */
    public String getTurnAsText() {
        if(isBlackTurn())
            return "Blacks Turn (" + blackPlayer + ")";
        else
            return "Whites Turn (" + whitePlayer + ")";
    }
}
