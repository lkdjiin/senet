package senet.game;

/**
 * Simple abstraction of a move with the very minimum logic.
 */
public class Move {

    private int from, to;

    /**
     * Sole constructor.
     * @param from the starting box (1 - 30)
     * @param to the ending box (1 - 30)
     */
    public Move(int from, int to) {
        if(from < 1 || from > 30 || to < 1 || to > 30)
            throw new IllegalArgumentException();
        this.from = from;
        this.to = to;
    }

    /**
     * @return the starting box (1 - 30)
     */
    public int getFrom() {
        return from;
    }

    /**
     * @return the ending box (1 - 30)
     */
    public int getTo() {
        return to;
    }

}