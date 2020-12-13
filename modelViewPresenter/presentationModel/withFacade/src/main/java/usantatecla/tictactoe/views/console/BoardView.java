package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.views.Message;
import usantatecla.tictactoe.views.WithLogicView;
import usantatecla.utils.Console;

class BoardView extends WithLogicView {

    BoardView(Logic logic) {
        super(logic);
    }

    void write() {
        Console.getInstance().writeln(Message.SEPARATOR.getMessage());
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            Console.getInstance().write(Message.VERTICAL_LINE_LEFT.getMessage());
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                new TokenView(this.logic.getToken(new Coordinate(i, j))).write();
                Console.getInstance().write(Message.VERTICAL_LINE_CENTERED.getMessage());
            }
            Console.getInstance().writeln(Message.VERTICAL_LINE_RIGHT.getMessage());
        }
        Console.getInstance().writeln(Message.SEPARATOR.getMessage());
    }

}