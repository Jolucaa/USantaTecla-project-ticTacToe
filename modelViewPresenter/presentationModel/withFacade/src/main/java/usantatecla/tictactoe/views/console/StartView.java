package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.Message;

class StartView{

    private Logic logic;

    StartView(Logic logic) {
        this.logic = logic;
    }

    void interact() {
        Message.TITLE.writeln();
        new BoardView().write(this.logic);
    }

}
