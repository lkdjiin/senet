package senet;

import javax.swing.JOptionPane;
import senet.game.*;
import senet.game.element.*;

/**
 * Bandmaster of the game.
 */
public class Controller {

    private UI ui;
    private Game game;
    private Sticks sticks;
    private int threw;

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
        threw = sticks.getResultOfThrow();
        ui.displaySticksResult(threw);
        game.setSticksThrowed(true);
        ui.enableThrowing(false);
    }

    /**
     * Initialize a game with two human players.
     */
    public void newGameTwoPlayersClicked() {
        if(!createGameInstance())
            return;
        informUIOfNewGame();
    }

    private boolean createGameInstance() {
        String player1 = ui.getPlayerName("First player's name", "Player1");
        if(player1 == null)
            return false;
        String player2 = ui.getPlayerName("Second player's name", "Player2");
        if(player2 == null)
            return false;
        game = new Game(player1, player2);
        return true;
    }

    private void informUIOfNewGame() {
        ui.setTurn(game.getTurnAsText());
        ui.displayBoard(game.getBoard());
        ui.enableThrowing(true);
    }

    /**
     * A human player clicked on a box of the board.
     * @param id the clicked box
     */
    public void boxClicked(int id) {
        if(null == game) {
            return;
        }
        if(sticksAreNotThrowed()) {
            JOptionPane.showMessageDialog(ui, "Throw the sticks first !");
            return;
        }
        if(game.noLegalMove(threw)) {
            JOptionPane.showMessageDialog(ui, "Forfeit ! No legal moves.");
            sameTurn();
            return;
        }
        if(startingBoxIsNotSelected()) {
            selectBox(id);
            if(game.canMoveOut(id, threw)) {
                ui.mayMoveOut();
            }
        } else {
            if(game.isLegalToMoveTo(id, threw)) {
                if(game.isGoingToTheWater(id)) {
                    id = game.getResurrectionHouse();
                }
                game.moveTo(id);
                ui.displayBoard(game.getBoard());
                if(game.isPlayAgain(threw))
                    sameTurn();
                else
                    nextTurn();
            }
        }
    }

    public void buttonMoveOutClicked() {
        game.moveOut();
        ui.displayBoard(game.getBoard());
        if(game.isPlayAgain(threw))
            sameTurn();
        else
            nextTurn();
    }

    private boolean sticksAreNotThrowed() {
        return ! game.isSticksThrowed();
    }

    private boolean startingBoxIsNotSelected() {
        if(null == game) {
            return false;
        }
        return game.getMoveFrom() == null;
    }

    private void selectBox(int id) {
        if(game.isBoxSelectable(id, threw)) {
            ui.setBoxSelected(game.getBoard(), id);
            game.setMoveFrom(id);
        }
    }

    private void nextTurn() {
        game.nextTurn();
        ui.setTurn(game.getTurnAsText());
        ui.enableThrowing(true);
        ui.cannotMoveOut();
    }

    /**
     * @todo refactor: same as nextTurn
     */
    private void sameTurn() {
        game.sameTurn();
        ui.enableThrowing(true);
        ui.cannotMoveOut();
    }
}
