package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.types.Error;
import usantatecla.utils.Console;

public class CoordinateView {

    PlayController playController;

    public CoordinateView(PlayController playController) {
        this.playController = playController;
    }

    public int[] read(String title) {
        Console console = Console.getInstance();
        int[] coordinate = new int[2];
        Error error;
        do {
            console.writeln(title);
            coordinate[0] = (console.readInt("Row: ") - 1);
            coordinate[1] = (console.readInt("Column: ") - 1);
            error = this.playController.isValidCoordinate(coordinate);
            new ErrorView(error).writeln();
        } while (!error.isNull());
        return coordinate;
    }

}
