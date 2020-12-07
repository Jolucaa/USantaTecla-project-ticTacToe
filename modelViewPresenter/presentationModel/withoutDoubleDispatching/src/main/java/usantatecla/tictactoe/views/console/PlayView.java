package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;

class PlayView {

    void interact(PlayController playController) {
        if (!playController.isBoardComplete()) {
            this.put(playController);
        } else {
            this.move(playController);
        }
        new BoardView(playController).write();
        if (playController.isTicTacToe()) {
            new TokenView(playController.getToken()).write();
            Console.getInstance().writeln(Message.PLAYER_WIN.getMessage());
        }
    }

    private void put(PlayController playController) {
        boolean isUser = playController.isUser();
        Coordinate coordinate;
        Error error;
        do {
            if (isUser) {
                coordinate = new CoordinateView(playController).read(Message.COORDINATE_TO_PUT.getMessage());
            } else {
                coordinate = playController.getRandomCoordinate();

            }
            error = playController.put(coordinate);
            if (isUser) {
                new ErrorView(error).writeln();
            }
        } while (!error.isNull());
    }

    private void move(PlayController playController) {
        boolean isUser = playController.isUser();
        Coordinate origin;
        Coordinate target;
        Error error;
        do {
            if (isUser) {
                origin = new CoordinateView(playController).read(Message.COORDINATE_TO_REMOVE.getMessage());
                target = new CoordinateView(playController).read(Message.COORDINATE_TO_MOVE.getMessage());
            } else {
                origin = playController.getRandomCoordinate();
                target = playController.getRandomCoordinate();
            }
            error = playController.move(origin, target);
            if (isUser) {
                new ErrorView(error).writeln();
            }
        } while (!error.isNull());
    }

}
