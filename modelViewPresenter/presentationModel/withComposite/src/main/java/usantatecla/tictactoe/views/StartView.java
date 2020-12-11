package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.utils.Console;
import usantatecla.utils.LimitedIntDialog;

public class StartView {

    public void interact(StartController startController) {
        Console.getInstance().writeln(Message.TITTLE.getMessage());
        int users = new LimitedIntDialog(0,
                startController.getMaxPlayers()).read(Message.NUMBER_PLAYERS.getMessage());
        startController.setUsers(users);
        new BoardView(startController).write();
    }

}
