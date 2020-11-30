package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;
import usantatecla.utils.LimitedIntDialog;

class StartView extends SubView {

    StartView(Logic logic) {
        super(logic);
    }

    void interact() {
        Console.getInstance().writeln(Message.TITLE.getMessage());
        int users = new LimitedIntDialog(0,
                this.logic.getMaxPlayers()).read(Message.NUMBER_PLAYERS.getMessage());
        this.logic.setUsers(users);
        new GameView(this.logic).write();
    }

}