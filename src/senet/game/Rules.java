package senet.game;

import java.util.ArrayList;
import senet.game.element.Board;

public class Rules {

    private Board board;
    private int threw;
    private boolean turn;
    private ArrayList<Move> legalMoves;

    /**
     *
     * @param board the board with pieces
     * @param threw the number threw by the sticks
     * @param turn true for blacks turn, false for whites turn
     * @return the list of legal moves
     */
    public ArrayList<Move> getAllLegalMoves(Board board, int threw, boolean turn) {
        initArguments(board, threw, turn);
        checkAllBoxes();
        return legalMoves;
    }

    private void initArguments(Board board, int threw, boolean turn) {
        legalMoves = new ArrayList<Move>();
        this.board = board;
        this.threw = threw;
        this.turn = turn;
    }

    private void checkAllBoxes() {
        for(int i = 1; i <= 30; i++) {
            checkBox(i);
        }
    }

    private void checkBox(int id) {
        if(isCandidateForBlack(id)) {
            addThisBoxIfLegalMove(id);
        } else {

        }
    }

    private boolean isCandidateForBlack(int id) {
        return isBlacksTurn() && isBlackPieceInBox(id);
    }

    private boolean isBlacksTurn() {
        return turn;
    }

    private boolean isBlackPieceInBox(int id) {
        return board.getBoxContent(id) == Board.BOX_BLACK;
    }

    private boolean isWhitePieceOrVoidInBox(int id) {
        return board.getBoxContent(id) != Board.BOX_BLACK;
    }

    private void addThisBoxIfLegalMove(int id) {
        int endingBox = id + threw;
        if(isWhitePieceOrVoidInBox(endingBox)) {
            legalMoves.add(new Move(id, endingBox));
        }
    }
}
