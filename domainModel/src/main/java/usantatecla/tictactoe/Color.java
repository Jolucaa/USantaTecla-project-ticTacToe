package usantatecla.tictactoe;

import usantatecla.utils.Console;

enum Color {

	X,
	O,
	NULL;

	boolean isNull() {
		return this.equals(Color.NULL);
	}

	void write() {
		String string = this.name();
		if (this == Color.NULL){
			string = " ";
		}
		Console.instance().write(string);
	}

	static Color get(int ordinal){
		assert ordinal < Color.NULL.ordinal();
		
		return Color.values()[ordinal];
	}

}
