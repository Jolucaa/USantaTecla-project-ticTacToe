package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.Message;
import usantatecla.tictactoe.views.WithGameView;
import usantatecla.utils.Console;
import usantatecla.utils.LimitedIntDialog;

class StartView extends WithGameView {

    StartView(Game game) {
        super(game);
    }

    void interact() {
        Console.getInstance().writeln(Message.TITTLE.getMessage());
        int users = new LimitedIntDialog(0,
                this.game.getMaxPlayers()).read(Message.NUMBER_PLAYERS.getMessage());
        this.game.setUsers(users);
        new BoardView(this.game).write();
    }

}