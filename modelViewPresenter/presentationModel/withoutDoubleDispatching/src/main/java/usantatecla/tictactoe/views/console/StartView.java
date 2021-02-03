package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.Message;

class StartView{

    void interact(StartController startController) {
        Message.TITLE.writeln();
        new BoardView().write(startController);
        startController.nextState();
    }

}
