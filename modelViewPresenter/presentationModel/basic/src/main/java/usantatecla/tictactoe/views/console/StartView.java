package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.Message;

class StartView{

    StartController startController;

    StartView(StartController startController) {
        this.startController = startController;
    }

    void interact() {
        Message.TITLE.writeln();
        new BoardView(this.startController).write();
    }

}
