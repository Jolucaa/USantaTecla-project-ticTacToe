package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.types.Error;
import usantatecla.utils.Console;

public class CoordinateView {

    Logic logic;

    public CoordinateView(Logic logic) {
        this.logic = logic;
    }

    public int[] read(String title) {
        Console console = Console.getInstance();
        int[] coordinate = new int[2];
        Error error;
        do {
            console.writeln(title);
            coordinate[0] = (console.readInt("Row: ") - 1);
            coordinate[1] = (console.readInt("Column: ") - 1);
            error = this.logic.isValidCoordinate(coordinate);
            new ErrorView(error).writeln();
        } while (!error.isNull());
        return coordinate;
    }

}