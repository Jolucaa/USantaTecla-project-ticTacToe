package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Token;
import usantatecla.utils.Console;

public class TokenView {

	private Token token;

	TokenView(Token token){
		this.token = token;
	}

	void write() {
		Console.getInstance().write(token.toString());
	}

}
