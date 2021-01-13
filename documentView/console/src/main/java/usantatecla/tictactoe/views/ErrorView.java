package usantatecla.tictactoe.views;

import usantatecla.utils.Console;
import usantatecla.tictactoe.types.Error;

class ErrorView {

	private Error error;

	ErrorView(Error error) {
		this.error = error;
	}
	
	void writeln() {
		if (!error.isNull()){
			Console.getInstance().writeln(this.error.ordinal());
		}
	}

}
