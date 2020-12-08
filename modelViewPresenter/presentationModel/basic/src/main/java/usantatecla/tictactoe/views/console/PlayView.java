package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;

class PlayView {

    private PlayController playController;

    PlayView(PlayController playController) {
        this.playController = playController;
    }

    void interact() {
        do {
            if (!this.playController.isBoardComplete()) {
                this.put();
            } else {
                this.move();
            }
            new BoardView(this.playController).write();
        } while (!this.playController.isTicTacToe());
        new TokenView(this.playController.getToken()).write();
        Console.getInstance().writeln(Message.PLAYER_WIN.getMessage());
    }

    private void put() {
        boolean isUser = this.playController.isUser();
        Coordinate coordinate;
        Error error;
        do {
            if (isUser) {
                coordinate = new CoordinateView(this.playController).read(Message.COORDINATE_TO_PUT.getMessage());
            } else {
                coordinate = createRandomCoordinate();
            }
            error = this.playController.put(coordinate);
            if (isUser) {
                new ErrorView(error).writeln();
            }
        } while (!error.isNull());
    }

    private void move() {
        boolean isUser = this.playController.isUser();
        Coordinate origin;
        Coordinate target;
        Error error;
        do {
            if (isUser) {
                origin = new CoordinateView(this.playController).read(Message.COORDINATE_TO_REMOVE.getMessage());
                target = new CoordinateView(this.playController).read(Message.COORDINATE_TO_MOVE.getMessage());
            } else {
                origin = createRandomCoordinate();
                target = createRandomCoordinate();
            }
            error = this.playController.move(origin, target);
            if (isUser) {
                new ErrorView(error).writeln();
            }
        } while (!error.isNull());
    }

    public Coordinate createRandomCoordinate() {
        Coordinate coordinate = new Coordinate();
        coordinate.random();
        return coordinate;
    }

}
