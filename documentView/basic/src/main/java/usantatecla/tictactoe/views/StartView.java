package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Turn;
import usantatecla.utils.views.BoundedIntDialog;

class StartView extends WithGameView {

    StartView(Game game) {
		super(game);
	}

    void interact() {
		Message.TITLE.writeln();
		this.game.setUsers();
		new BoardView().write(this.game);
	}

}
