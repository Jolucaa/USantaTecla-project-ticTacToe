package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;

class PlayerView {

    protected Game game;

    public PlayerView(Game game) {
        this.game = game;
    }

    void interact(Game game) {
        this.game = game;
        if (!this.game.areAllTokensOnBoard()) {
            this.putToken();
        } else {
            this.moveToken();
        }
    }

    private void putToken() {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = this.getCoordinate(Message.ENTER_COORDINATE_TO_PUT);
            error = this.getPutTokenError(coordinate);
        } while (!error.isNull());
        this.game.putToken(coordinate);
    }

    protected Coordinate getCoordinate(Message message) {
        assert message != null;

        return (Coordinate) new CoordinateView().read(message.toString());
    }

    protected Error getPutTokenError(Coordinate coordinate) {
        assert coordinate != null;

        Error error = this.game.getPutTokenError(coordinate);
        new ErrorView().writeln(error);
        return error;
    }

    private void moveToken() {
        Coordinate origin;
        Error error;
        do {
            origin = this.getCoordinate(Message.COORDINATE_TO_REMOVE);
            error = this.getOriginMoveTokenError(origin);
        } while (error != Error.NULL);
        Coordinate target;
        do {
            target = this.getCoordinate(Message.COORDINATE_TO_MOVE);
            error = this.getTargetMoveTokenError(origin, target);
        } while (error != Error.NULL);
        this.game.moveToken(origin, target);
    }

    protected Error getOriginMoveTokenError(Coordinate origin) {
        assert !origin.isNull();

        Error error = this.game.getOriginMoveTokenError(origin);
        new ErrorView().writeln(error);
        return error;
    }

    protected Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        assert !origin.isNull() && !target.isNull();

        Error error = this.game.getTargetMoveTokenError(origin, target);
        new ErrorView().writeln(error);
        return error;
    }
}
