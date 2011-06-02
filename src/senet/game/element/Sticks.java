package senet.game.element;

public class Sticks {

    Stick stick;

    public Sticks() {
        stick = new Stick();
    }
    
    public int getResultOfThrow() {
        int result = 0;
        for(int i = 0; i < 4; i++) {
            result += stick.getResultOfThrow();
        }
        return result == 0 ? 5 : result;
    }
    
}
