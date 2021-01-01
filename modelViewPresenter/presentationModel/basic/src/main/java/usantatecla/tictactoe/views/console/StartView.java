package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;
import usantatecla.utils.LimitedIntDialog;

class StartView {

    private final StartController startController;

    StartView(StartController startController) {
        assert startController != null;

        this.startController = startController;
    }

    void interact() {
        Console.getInstance().writeln(Message.TITTLE.getMessage());
        int users = new LimitedIntDialog(0,
                this.startController.getMaxPlayers()).read(Message.NUMBER_PLAYERS.getMessage());
        this.startController.setUsers(users);
        new BoardView(startController).write();
    }

}
