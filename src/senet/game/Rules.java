package senet.game;

import java.util.ArrayList;
import senet.game.element.Board;

/**
 * The set of basic rules.
 */
public class Rules {

    private Board board;
    private int threw;
    private boolean turn;
    private ArrayList<Move> legalMoves;

    public boolean isPlayAgain(int threw) {
        switch(threw) {
            case 1:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }
    
    public boolean noLegalMoves(Board board, int threw, boolean turn) {
        return getAllLegalMoves(board, threw, Game.BLACKS_TURN).isEmpty();
    }

    /**
     *
     * @param board the board with pieces
     * @param threw the number threw by the sticks
     * @param turn true for blacks turn, false for whites turn
     * @return the list of legal moves
     */
    public ArrayList<Move> getAllLegalMoves(Board board, int threw, boolean turn) {
        initArguments(board, threw, turn);
        // Les coups en avant
        checkAllBoxes();
        if(legalMoves.isEmpty()) {
            // Les coups en arrière
            this.threw = -threw;
            checkAllBoxes();
        }
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
        return isBlacksTurn() && board.isBlackPieceInBox(id);
    }

    private boolean isCandidateForWhite(int id) {
        return isWhitesTurn() && board.isWhitePieceInBox(id);
    }

    private boolean isBlacksTurn() {
        return turn;
    }

    private boolean isWhitesTurn() {
        return ! turn;
    }

    private void addThisBoxIfLegalMove(int id, int color) {
        int endingBox = id + threw;
        if(endingBox < 1)
            return;
        if(board.isVoidBox(endingBox)) {
            if(weCannotPassOverThreeOpponents(id, endingBox, getOpponentColor(color)))
                return;
            if(weTrytPassOverTheHouseOfGood(id, endingBox))
                return;
            legalMoves.add(new Move(id, endingBox));
        } else if(board.isPieceInBox(endingBox, getOpponentColor(color))) {
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
     * @todo Board devrait contenir une méthode pour savoir si il y a un groupe de 3 d'une certaine couleur entre 2 cases
     */
    private boolean weCannotPassOverThreeOpponents(int startBox, int endBox, int opponentColor) {
        if(endBox > startBox)
            return weCannotPassOverThreeOpponentsForeward(startBox, endBox, opponentColor);
        else
            return weCannotPassOverThreeOpponentsBackward(startBox, endBox, opponentColor);
        
    }

    private boolean weTrytPassOverTheHouseOfGood(int startBox, int endBox) {
        return startBox < 26 && endBox > 26;
    }

    private boolean weCannotPassOverThreeOpponentsForeward(int startBox, int endBox, int opponentColor) {
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

    private boolean weCannotPassOverThreeOpponentsBackward(int startBox, int endBox, int opponentColor) {
        if(startBox-endBox <= 3)
            return false;
        for(int i = startBox-2; i >= endBox+2; i--) {
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

    /**
     * Checks if the destination lands to the water (house 27).
     * @param destination the destination house
     * @return true if the destination equals 27
     */
    public boolean isGoingToTheWater(int destination) {
        if(destination == 27) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get to a resurrection house.
     * @param board the board content
     * @param move a move that lands to the water
     * @return the move with the destination changed
     */
    public int getResurrectionHouse(Board board) {
        int destination = 15;
        for(int i = 15; i < 26; i++) {
            if(board.isVoidBox(i)) {
                break;
            }
            destination = i + 1;
        }
        return destination;
    }
}
