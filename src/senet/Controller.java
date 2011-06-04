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
    private Integer moveFrom;
    private boolean sticksThrowed;

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
        sticksThrowed = true;
        ui.enableThrowing(false);
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
        moveFrom = null;
        sticksThrowed = false;
        ui.enableThrowing(true);
    }

    public boolean isBlackTurn() {
        return blackTurn;
    }

    public boolean isWhiteTurn() {
        return ! blackTurn;
    }

    public void boxClicked(int id) {
        if(! sticksThrowed) {
            System.out.println("Throw the sticks first !");
            return;
        }
        if(moveFrom == null) {
            if( (isBlackTurn() && board.getBoxContent(id) == Board.BOX_BLACK)
                    || (isWhiteTurn() && board.getBoxContent(id) == Board.BOX_WHITE) ) {
                ui.setBoxSelected(board, id);
                moveFrom = id;
            }
        } else {
            if(board.getBoxContent(id) == Board.BOX_VOID) {
                board.move(moveFrom, id);
                ui.displayBoard(board);
            }
        }
    }
}
