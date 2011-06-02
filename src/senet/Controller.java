package senet;

import senet.game.element.Sticks;

public class Controller {

    private UI ui;
    private Sticks sticks;

    public Controller() {
        sticks = new Sticks();
    }



    public void setUI(UI ui) {
        this.ui = ui;
    }

    public void sticksThrowed() {
        int result = sticks.getResultOfThrow();
        ui.displaySticksResult(result);
    }
}
