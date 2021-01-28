package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.Message;
import usantatecla.tictactoe.views.WithGameView;

class StartView extends WithGameView {

    StartView(Game game) {
        super(game);
    }

    void interact() {
        Message.TITLE.writeln();
        new BoardView().write(this.game);
    }

}
