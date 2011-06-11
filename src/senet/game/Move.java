package senet.game;

/**
 * Simple abstraction of a move with the very minimum logic.
 */
public class Move {

    private int from, to;

    /**
     * Sole constructor.
     * @param from the starting box (1 - 30)
     * @param to the ending box (0 - 30). A value of zero means "go out".
     */
    public Move(int from, int to) {
        if(from < 1 || from > 30 || to < 0 || to > 30)
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Move other = (Move) obj;
        if (this.from != other.from) {
            return false;
        }
        if (this.to != other.to) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.from;
        hash = 37 * hash + this.to;
        return hash;
    }

    @Override
    public String toString() {
        return "Move: from " + from + " to " + to;
    }

}