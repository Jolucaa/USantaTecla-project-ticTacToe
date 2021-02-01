package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.views.Message;
import usantatecla.utils.views.Console;

public class BoardView {

    public void writeln() {
        Console.getInstance().writeln();
    }

    public void writeVerticalLine() {
        Message.VERTICAL_LINE.write();
    }

    public void writeHorizontalLine() {
        Message.HORIZONTAL_LINE.writeln();
    }

}
