package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Controller;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;

class GameView {

	private Controller controller;

	GameView(Controller controller) {
    this.controller = controller;
  }

	void write() {
		Console.getInstance().writeln(Message.SEPARATOR.toString());
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			Console.getInstance().write(Message.VERTICAL_LINE_LEFT.toString());
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				new TokenView(this.controller.getToken(new Coordinate(i, j))).write();
				Console.getInstance().write(Message.VERTICAL_LINE_CENTERED.toString());
			}
			Console.getInstance().writeln(Message.VERTICAL_LINE_RIGHT.toString());
		}
		Console.getInstance().writeln(Message.SEPARATOR.toString());
	}

}
