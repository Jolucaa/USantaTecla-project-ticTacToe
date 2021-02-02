package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.views.Console;


public class BoardView extends usantatecla.tictactoe.views.BoardView {

    @Override
    public void write() {
        Message.HORIZONTAL_LINE.writeln();
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                new ColorView().write(this.colors.get(i * Coordinate.DIMENSION + j));
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }

}
