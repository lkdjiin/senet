package senet.game.element;

/**
 * Abstraction of one throwing stick.
 */
public class Stick {

    /**
     * Returns the throw of one stick.
     * @return 0 or 1
     */
    public int getResultOfThrow() {
        int random = (int) (Math.random() * 2);
        return random;
    }
}
