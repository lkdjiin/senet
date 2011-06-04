package senet.game.element;

import senet.game.Move;

/**
 * This is the board of the game of senet.
 * It manages the contents of the boxes.
 */
public class Board {

    /**
     * A box (also knows as an house in the game of senet) with nothing in it.
     */
    public static final int BOX_VOID = 0;

    /**
     * A box (also knows as an house in the game of senet) with a black piece in it.
     */
    public static final int BOX_BLACK = 1;

    /**
     * A box (also knows as an house in the game of senet) with a white piece in it.
     */
    public static final int BOX_WHITE = 2;

    /**
     * Keep track of the content of the boxes. Internally, this is a normal array,
     * ranged from 0 to 29, but, the public API should use a more human-readable
     * abstraction with boxes ranged from 1 to 30.
     */
    private Integer[] boxes;

    /**
     * Sole constructor, it initialize all the boxes to hold no piece.
     */
    public Board() {
        boxes = new Integer[30];
        for(int i = 0; i < boxes.length; i++) {
            boxes[i] = BOX_VOID;
        }
    }

    /**
     * Set the board to start the game.
     * <p>
     * Senet game have several variations. In this variation,
     * we have 5 pieces per players and the pieces are on the
     * board.
     */
    public void setInitialPosition() {
        boxes[0] = BOX_WHITE;
        boxes[2] = BOX_WHITE;
        boxes[4] = BOX_WHITE;
        boxes[6] = BOX_WHITE;
        boxes[8] = BOX_WHITE;
        boxes[1] = BOX_BLACK;
        boxes[3] = BOX_BLACK;
        boxes[5] = BOX_BLACK;
        boxes[7] = BOX_BLACK;
        boxes[9] = BOX_BLACK;
        for(int i = 10; i < 30; i++) {
            boxes[i] = BOX_VOID;
        }
    }

    /**
     * Returns the piece in this box.
     * @param boxNumber the number of the box, from 1 to 30 (1-based !)
     * @return BOX_VOID or BOX_WHITE or BOX_BLACK
     */
    public int getBoxContent(int boxNumber) {
        return boxes[boxNumber-1];
    }

    /**
     * Effectively make this move.
     * <p>
     * The move is supposed to be a legal one, no checks are performed.
     *
     * @param move the move to do
     */
    public void move(Move move) {
        boxes[move.getTo()-1] = boxes[move.getFrom()-1];
        boxes[move.getFrom()-1] = BOX_VOID;
    }

}
