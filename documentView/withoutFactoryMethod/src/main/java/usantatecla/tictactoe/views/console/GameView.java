package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;

class GameView {

    private Game game;

    GameView(Game game) {
        this.game = game;
    }

    void write() {
        Console.instance().writeln(Message.SEPARATOR.getMessage());
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            Console.instance().write(Message.VERTICAL_LINE_LEFT.getMessage());
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                new TokenView(this.game.getToken(new Coordinate(i, j))).write();
                Console.instance().write(Message.VERTICAL_LINE_CENTERED.getMessage());
            }
            Console.instance().writeln(Message.VERTICAL_LINE_RIGHT.getMessage());
        }
        Console.instance().writeln(Message.SEPARATOR.getMessage());
    }

}