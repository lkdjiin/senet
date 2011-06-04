package senet;

import senet.game.element.Board;
import senet.game.element.Sticks;

public class Controller {

    private UI ui;
    private Sticks sticks;
    private String blackPlayer;
    private String whitePlayer;
    private boolean blackTurn = true;
    private Board board;

    public Controller() {
        sticks = new Sticks();
        board = new Board();
    }

    public void setUI(UI ui) {
        this.ui = ui;
    }

    public void sticksThrowed() {
        int result = sticks.getResultOfThrow();
        ui.displaySticksResult(result);
    }

    public void newGameTwoPlayersClicked() {
        String player1 = ui.getPlayerName("First player's name", "Player1");
        if(player1 == null) return;
        String player2 = ui.getPlayerName("Second player's name", "Player2");
        if(player2 == null) return;

        int random = (int) (Math.random() * 2);
        if(random == 0) {
            blackPlayer = player1;
            whitePlayer = player2;
        } else {
            blackPlayer = player2;
            whitePlayer = player1;
        }

        blackTurn = true;
        ui.setTurn("Black's Turn (" + blackPlayer + ")");
        board.setInitialPosition();
        ui.displayBoard(board);
    }

    public boolean isBlackTurn() {
        return blackTurn;
    }

    public boolean isWhiteTurn() {
        return ! blackTurn;
    }
}
