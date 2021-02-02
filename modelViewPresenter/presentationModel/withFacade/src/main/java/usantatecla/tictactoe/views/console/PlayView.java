package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.Message;

class PlayView {

    Logic logic;

    PlayView(Logic logic) {
        this.logic = logic;
    }

    void interact() {
        do {
            new PlayerView(this.logic).interact();
            this.logic.next();
            new BoardView().write(this.logic);
        } while (!this.logic.isTicTacToe());
        Message.PLAYER_WIN.writeln(this.logic.getActiveColor().name());
    }

}
