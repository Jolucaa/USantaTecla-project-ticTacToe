package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.utils.Console;

public class CoordinateView {

    Logic logic;

    public CoordinateView(Logic logic) {
        this.logic = logic;
    }

    public Coordinate read(String title) {
        Console console = Console.getInstance();
        Coordinate coordinate;
        Error error;
        do {
            console.writeln(title);
            int row = (console.readInt("Row: ") - 1);
            int column = (console.readInt("Column: ") - 1);
            coordinate = new Coordinate(row, column);
            error = this.logic.isValidCoordinate(coordinate);
            new ErrorView(error).writeln();
        } while (!error.isNull());
        return coordinate;
    }

}