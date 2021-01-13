package usantatecla.tictactoe.views;

import usantatecla.tictactoe.types.Color;
import usantatecla.utils.Console;

public class ColorView {

    private Color color;

	ColorView(Color color){
		this.color = color;
	}

    void write() {
		String string = this.color.name();
		if (this.color.isNull()) {
			string = " ";
		}
		Console.getInstance().write(string);
	}
}
