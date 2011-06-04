package senet;

import senet.game.*;
import senet.game.element.*;

/**
 * Bandmaster of the game.
 */
public class Controller {

    private UI ui;
    private Game game;
    private Sticks sticks;
    
    public Controller() {
        game = new Game();
        sticks = new Sticks();
    }

    public void setUI(UI ui) {
        this.ui = ui;
    }

    public void sticksThrowed() {
        int result = sticks.getResultOfThrow();
        ui.displaySticksResult(result);
        game.setSticksThrowed(true);
        ui.enableThrowing(false);
    }

    public void newGameTwoPlayersClicked() {
        String player1 = ui.getPlayerName("First player's name", "Player1");
        if(player1 == null) return;
        String player2 = ui.getPlayerName("Second player's name", "Player2");
        if(player2 == null) return;

        game.newGame(player1, player2);

        ui.setTurn("Black's Turn (" + game.getBlackPlayerName() + ")");
        ui.displayBoard(game.getBoard());
        ui.enableThrowing(true);
    }


    public void boxClicked(int id) {
        if(! game.isSticksThrowed()) {
            System.out.println("Throw the sticks first !");
            return;
        }
        if(game.getMoveFrom() == null) {
            if(game.isBoxSelectable(id)) {
                ui.setBoxSelected(game.getBoard(), id);
                game.setMoveFrom(id);
            }
        } else {
            if(game.isBoxVoid(id)) {
                game.moveTo(id);
                ui.displayBoard(game.getBoard());
                nextTurn();
            }
        }
    }

    private void nextTurn() {
        game.nextTurn();
        ui.setTurn(game.getTurnAsText());
        ui.enableThrowing(true);
    }
}
