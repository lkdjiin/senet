package senet.game.element;

public class Board {

    public static final int BOX_VOID = 0;
    public static final int BOX_BLACK = 1;
    public static final int BOX_WHITE = 2;

    protected Integer[] boxes;

    public Board() {
        boxes = new Integer[30];
        for(int i = 0; i < boxes.length; i++) {
            boxes[i] = BOX_VOID;
        }
    }

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
     *
     * @param boxNumber the number of the box from 1 to 30 (1-based !)
     * @return BOX_VOID or BOX_WHITE or BOX_BLACK
     */
    public int getBoxContent(int boxNumber) {
        return boxes[boxNumber-1];
    }

    public void move(int from, int to) {
        boxes[to-1] = boxes[from-1];
        boxes[from-1] = BOX_VOID;
    }

}
