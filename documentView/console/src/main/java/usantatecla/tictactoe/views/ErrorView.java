package usantatecla.tictactoe.views;

import usantatecla.utils.views.Console;
import usantatecla.tictactoe.types.Error;

class ErrorView {
	
	void writeln(Error error) {
		if (!error.isNull()){
			Console.getInstance().writeln(error.toString());
		}
	}

}
