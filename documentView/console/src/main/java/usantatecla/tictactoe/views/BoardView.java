package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.utils.Console;

class BoardView extends WithGameView {

    BoardView(Game game) {
        super(game);
    }

    void write() {
        Console.getInstance().writeln(Message.SEPARATOR.getMessage());
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            Console.getInstance().write(Message.VERTICAL_LINE_LEFT.getMessage());
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                new TokenView(this.game.getToken(new Coordinate(i, j))).write();
                Console.getInstance().write(Message.VERTICAL_LINE_CENTERED.getMessage());
            }
            Console.getInstance().writeln(Message.VERTICAL_LINE_RIGHT.getMessage());
        }
        Console.getInstance().writeln(Message.SEPARATOR.getMessage());
    }

}
