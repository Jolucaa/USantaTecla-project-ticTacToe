package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.WithLogicView;
import usantatecla.utils.Console;

public class CoordinateView extends WithLogicView {

    public CoordinateView(Logic logic) {
        super(logic);
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