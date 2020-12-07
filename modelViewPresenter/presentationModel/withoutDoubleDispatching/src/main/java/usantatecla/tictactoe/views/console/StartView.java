package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;
import usantatecla.utils.LimitedIntDialog;

class StartView {

    void interact(StartController startController) {
        Console.getInstance().writeln(Message.TITTLE.getMessage());
        int users = new LimitedIntDialog(0,
                startController.getMaxPlayers()).read(Message.NUMBER_PLAYERS.getMessage());
        startController.setUsers(users);
        new GameView(startController).write();
    }

}
