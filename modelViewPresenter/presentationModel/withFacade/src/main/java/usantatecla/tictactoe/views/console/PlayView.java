package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;

class PlayView extends SubView {

    PlayView(Logic logic) {
        super(logic);
    }

    void interact() {
        do {
            if (!this.logic.isBoardComplete()) {
                this.put();
            } else {
                this.move();
            }
            new GameView(this.logic).write();
        } while (!this.logic.isTicTacToe());
        new TokenView(this.logic.getToken()).write();
        Console.getInstance().writeln(Message.PLAYER_WIN.getMessage());
    }

    private void put() {
        boolean isUser = this.logic.isUser();
        Coordinate coordinate;
        Error error;
        do {
            if (isUser) {
                coordinate = new CoordinateView(this.logic).read(Message.COORDINATE_TO_PUT.getMessage());
            } else {
                coordinate = this.logic.getRandomCoordinate();
            }
            error = this.logic.put(coordinate);
            if (isUser) {
                new ErrorView(error).writeln();
            }
        } while (!error.isNull());
    }

    private void move() {
        boolean isUser = this.logic.isUser();
        Coordinate origin;
        Coordinate target;
        Error error;
        do {
            if (isUser) {
                origin = new CoordinateView(this.logic).read(Message.COORDINATE_TO_REMOVE.getMessage());
                target = new CoordinateView(this.logic).read(Message.COORDINATE_TO_MOVE.getMessage());
            } else {
                origin = this.logic.getRandomCoordinate();
                target = this.logic.getRandomCoordinate();
            }
            error = this.logic.move(origin, target);
            if (isUser) {
                new ErrorView(error).writeln();
            }
        } while (!error.isNull());
    }

}