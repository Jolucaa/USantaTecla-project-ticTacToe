package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.Message;

class StartView{

    private Logic logic;

    StartView(Logic logic) {
        this.logic = logic;
    }

    void interact() {
        new MessageView().writeln(Message.TITLE);
        new BoardView().write(this.logic);
    }

}
