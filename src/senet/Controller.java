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

    /**
     * Sole constructor.
     */
    public Controller() {
        sticks = new Sticks();
    }

    /**
     * Set the User Interface, from where Controller gets messages and to
     * where it sends messages.
     * @param ui the main JFrame
     */
    public void setUI(UI ui) {
        this.ui = ui;
    }

    /**
     * A player (through GUI or AI) want to throw the sticks.
     */
    public void throwTheSticks() {
        int result = sticks.getResultOfThrow();
        ui.displaySticksResult(result);
        game.setSticksThrowed(true);
        ui.enableThrowing(false);
    }

    /**
     * Initialize a game with two human players.
     */
    public void newGameTwoPlayersClicked() {
        String player1 = ui.getPlayerName("First player's name", "Player1");
        if(player1 == null) return;
        String player2 = ui.getPlayerName("Second player's name", "Player2");
        if(player2 == null) return;

        game = new Game(player1, player2);

        ui.setTurn(game.getTurnAsText());
        ui.displayBoard(game.getBoard());
        ui.enableThrowing(true);
    }

    /**
     * A human player clicked on a box of the board.
     * @param id the clicked box
     */
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
