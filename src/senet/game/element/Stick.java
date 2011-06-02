package senet.game.element;

public class Stick {

    public int getResultOfThrow() {
        int random = (int) (Math.random() * 2);
        return random;
    }
}
