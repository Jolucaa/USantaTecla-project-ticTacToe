package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;

class PlayCommand extends Command {

    PlayCommand(PlayController playController) {
        super(Message.ACTION_COMMAND.getMessage(), playController);
    }

    @Override
    protected void execute() {
        if (!playController.isBoardComplete()) {
            this.put(playController);
        } else {
            this.move(playController);
        }
        if (playController.isTicTacToe()) {
            new TokenView(playController.getToken()).write();
            Console.getInstance().writeln(Message.PLAYER_WIN.getMessage());
        }
    }

    private void put(PlayController playController) {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = new CoordinateView(playController).read(Message.COORDINATE_TO_PUT.getMessage());
            error = playController.put(coordinate);
            new ErrorView(error).writeln();
        } while (!error.isNull());
    }

    private void move(PlayController playController) {
        Coordinate origin;
        Coordinate target;
        Error error;
        do {
            origin = new CoordinateView(playController).read(Message.COORDINATE_TO_REMOVE.getMessage());
            target = new CoordinateView(playController).read(Message.COORDINATE_TO_MOVE.getMessage());
            error = playController.move(origin, target);
            new ErrorView(error).writeln();
        } while (!error.isNull());
    }

    @Override
    protected boolean isActive() {
        return true;
    }

}
