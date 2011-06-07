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
            addThisBoxIfLegalMove(id, Board.BOX_BLACK);
        } else if(isCandidateForWhite(id)){
            addThisBoxIfLegalMove(id, Board.BOX_WHITE);
        }
    }

    private boolean isCandidateForBlack(int id) {
        return isBlacksTurn() && isBlackPieceInBox(id);
    }

    private boolean isCandidateForWhite(int id) {
        return isWhitesTurn() && isWhitePieceInBox(id);
    }

    private boolean isBlacksTurn() {
        return turn;
    }

    private boolean isWhitesTurn() {
        return ! turn;
    }

    /**
     * @todo refactor; should be a Board method
     */
    private boolean isBlackPieceInBox(int id) {
        return board.getBoxContent(id) == Board.BOX_BLACK;
    }

    /**
     * @todo refactor; should be a Board method
     */
    private boolean isWhitePieceInBox(int id) {
        return board.getBoxContent(id) == Board.BOX_WHITE;
    }

    /**
     * @todo refactor; should be a Board method
     */
    private boolean isVoidBox(int id) {
        return board.getBoxContent(id) == Board.BOX_VOID;
    }

    private void addThisBoxIfLegalMove(int id, int color) {
        int endingBox = id + threw;
        if(isVoidBox(endingBox)) {
            if(weCannotPassOverThreeOpponents(id, endingBox, getOpponentColor(color)))
                return;
            legalMoves.add(new Move(id, endingBox));
        } else if(isPieceInBox(endingBox, getOpponentColor(color))) {
            if(! isThisPieceProtected(endingBox)) {
                legalMoves.add(new Move(id, endingBox));
            }
        }
    }

    /**
     *
     * @param startBox the id of the start of the move
     * @param endBox the id of the end of the move
     * @param opponentColor
     * @return true if there is a group of three ennemies between +startBox+ and +endBox+
     */
    private boolean weCannotPassOverThreeOpponents(int startBox, int endBox, int opponentColor) {
        if(endBox-startBox <= 3)
            return false;
        for(int i = startBox+2; i <= endBox-2; i++) {
            if(board.getBoxContent(i) == opponentColor
                    && board.getBoxContent(i-1) == opponentColor
                    && board.getBoxContent(i+1) == opponentColor) {
                return true;
            }
        }
        return false;
    }

    private int getOpponentColor(int color) {
        return color == Board.BOX_BLACK ? Board.BOX_WHITE : Board.BOX_BLACK;
    }

    /**
     * @todo refactor; should be a Board method
     */
    private boolean isPieceInBox(int id, int color) {
        return board.getBoxContent(id) == color;
    }

    /**
     * A piece is considered protected if there is another piece of the same color
     * next to it.
     * @param id the box id to watch
     * @return true if there is a piece in box +id+ and this piece is protected
     */
    private boolean isThisPieceProtected(int id) {
        int color = board.getBoxContent(id);
        int after = board.getBoxContent(id+1);
        int before = board.getBoxContent(id-1);
        if(color ==  after || color == before)
            return true;
        else
            return false;
    }
}
