package senet.game;

import senet.game.element.*;

public class Game {

    private Board board;
    private boolean sticksThrowed;
    private String blackPlayer;
    private String whitePlayer;
    private boolean blackTurn = true;
    private Integer moveFrom;

    public Game() {
        board = new Board();
    }

    public boolean isSticksThrowed() {
        return sticksThrowed;
    }

    public void setSticksThrowed(boolean sticksThrowed) {
        this.sticksThrowed = sticksThrowed;
    }

    public void newGame(String player1Name, String player2Name) {
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

    public String getBlackPlayerName() {
        return blackPlayer;
    }

    public String getWhitePlayerName() {
        return whitePlayer;
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

    public Integer getMoveFrom() {
        return moveFrom;
    }

    public void setMoveFrom(Integer moveFrom) {
        this.moveFrom = moveFrom;
    }

    public boolean isBoxSelectable(int id) {
        return (isBlackTurn() && board.getBoxContent(id) == Board.BOX_BLACK)
                    || (isWhiteTurn() && board.getBoxContent(id) == Board.BOX_WHITE);
    }

    public boolean isBoxVoid(int id) {
        return board.getBoxContent(id) == Board.BOX_VOID;
    }

    public void moveTo(int id) {
        board.move(new Move(moveFrom, id));
    }

    public void nextTurn() {
        blackTurn = ! blackTurn;
        moveFrom = null;
        sticksThrowed = false;
    }

    public String getTurnAsText() {
        if(isBlackTurn())
            return "Black's Turn (" + blackPlayer + ")";
        else
            return "White's Turn (" + whitePlayer + ")";
    }
}
