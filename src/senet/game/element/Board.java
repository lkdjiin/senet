package senet.game.element;

import org.apache.commons.lang.StringUtils;
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
    protected Integer[] boxes;

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

    public void setRow(int rowId, String rowContent) {
        if(rowId == 1) {
            setFirstRow(rowContent);
        } else if(rowId == 2) {
            setSecondRow(rowContent);
        } else {
            setThirdRow(rowContent);
        }
    }

    private void setFirstRow(String rowContent) {
        for(int i = 0; i < 10; i++) {
            setBoxFromChar(i, rowContent.charAt(i));
        }
    }

    private void setSecondRow(String rowContent) {
        String reversed = StringUtils.reverse(rowContent);
        for(int i = 10; i < 20; i++) {
            setBoxFromChar(i, reversed.charAt(i-10));
        }
    }

    private void setThirdRow(String rowContent) {
        for(int i = 20; i < 30; i++) {
            setBoxFromChar(i, rowContent.charAt(i-20));
        }
    }

    private void setBoxFromChar(int id, char c) {
        if(c == '-') {
            boxes[id] = BOX_VOID;
        } else if(c == 'b') {
            boxes[id] = BOX_BLACK;
        } else if(c == 'w') {
            boxes[id] = BOX_WHITE;
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
        Integer temp = boxes[move.getTo()-1];
        boxes[move.getTo()-1] = boxes[move.getFrom()-1];
        boxes[move.getFrom()-1] = temp;
    }

    @Override
    public String toString() {
        // @todo refactoring
        String ret = "";
        for(int i = 0; i < 10; i++) {
            if(boxes[i] == Board.BOX_VOID) {
                ret += "-";
            } else if(boxes[i] == Board.BOX_BLACK) {
                ret += "b";
            } else if(boxes[i] == Board.BOX_WHITE) {
                ret += "w";
            }
        }
        ret += "\n";

        String temp = "";
        for(int i = 10; i < 20; i++) {
            if(boxes[i] == Board.BOX_VOID) {
                temp += "-";
            } else if(boxes[i] == Board.BOX_BLACK) {
                temp += "b";
            } else if(boxes[i] == Board.BOX_WHITE) {
                temp += "w";
            }
        }
        temp = StringUtils.reverse(temp);
        ret += temp;
        ret += "\n";

        for(int i = 20; i < 30; i++) {
            if(boxes[i] == Board.BOX_VOID) {
                ret += "-";
            } else if(boxes[i] == Board.BOX_BLACK) {
                ret += "b";
            } else if(boxes[i] == Board.BOX_WHITE) {
                ret += "w";
            }
        }
        return ret;
    }

}
