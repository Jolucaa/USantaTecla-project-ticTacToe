package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.utils.ClosedInterval;
import usantatecla.utils.Console;

public class CoordinateView {

    public Coordinate read(String title) {
        Console console = Console.getInstance();
        Coordinate coordinate;
        Error error;
        do {
            console.writeln(title);
            int row = console.readInt("Row: ") - 1;
            int column = console.readInt("Column: ") - 1;
            coordinate = new Coordinate(row, column);
            ClosedInterval limits = new ClosedInterval(0, Coordinate.DIMENSION - 1);
            if (!limits.isIncluded(coordinate.getRow()) || !limits.isIncluded(coordinate.getColumn())) {
                error = Error.NOT_VALID;
            } else {
                error = Error.NULL;
            }
            new ErrorView(error).writeln();
        } while (!error.isNull());
        return coordinate;
    }

}