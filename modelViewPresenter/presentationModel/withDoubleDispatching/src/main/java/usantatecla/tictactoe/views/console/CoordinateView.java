package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.utils.Console;

public class CoordinateView {

    private PlayController playController;

    public CoordinateView(PlayController playController) {
        this.playController = playController;
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
            error = this.playController.isValidCoordinate(coordinate);
            new ErrorView(error).writeln();
        } while (!error.isNull());
        return coordinate;
    }

}
