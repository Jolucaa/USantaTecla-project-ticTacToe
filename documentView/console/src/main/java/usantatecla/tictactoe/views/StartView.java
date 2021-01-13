package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;
import usantatecla.utils.Console;

class StartView extends WithGameView {

    StartView(Game game) {
		super(game);
	}

    void interact() {
		Console.getInstance().writeln(Message.TITLE.toString());
		this.game.reset();
	}

}
