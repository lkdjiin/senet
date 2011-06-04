package senet.game.element;

/**
 * A group of 4 sticks.
 */
public class Sticks {

    private Stick stick;

    /**
     * Sole constructor.
     */
    public Sticks() {
        stick = new Stick();
    }

    /**
     * Returns the throw of 4 sticks.
     * @return the result, ranged from 1 to 5
     */
    public int getResultOfThrow() {
        int result = 0;
        for(int i = 0; i < 4; i++) {
            result += stick.getResultOfThrow();
        }
        return result == 0 ? 5 : result;
    }
    
}
