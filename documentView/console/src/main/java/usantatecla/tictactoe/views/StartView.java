package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Turn;
import usantatecla.utils.views.BoundedIntDialog;
import usantatecla.utils.views.Console;

class StartView extends WithGameView {

    StartView(Game game) {
		super(game);
	}

    void interact() {
		Console.getInstance().writeln(Message.TITLE.toString());
		this.game.setUsers(this.getUsers());
	}

	private int getUsers() {
		BoundedIntDialog dialog = new BoundedIntDialog(0, Turn.NUMBER_PLAYERS);
		return dialog.read(Message.NUMBER_PLAYERS.toString());
	}

}
