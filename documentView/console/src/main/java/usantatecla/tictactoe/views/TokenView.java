package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Token;
import usantatecla.utils.Console;

class TokenView {

	private Token token;

	TokenView(Token token){
		this.token = token;
	}

	void write() {
		Console.getInstance().write(token.toString());
	}

}