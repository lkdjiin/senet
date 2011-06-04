package senet.game;

public class Move {

    private int from, to;

    public Move(int from, int to) {
        if(from < 1 || from > 30 || to < 1 || to > 30)
            throw new IllegalArgumentException();
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

}