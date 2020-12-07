package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.Token;
import usantatecla.utils.ClosedInterval;

public class PlayController extends Controller {

    public PlayController(Game game, State state) {
        super(game, state);
    }

    public boolean isBoardComplete() {
        return this.game.isBoardComplete();
    }

    public boolean isTicTacToe() {
        return this.game.isTicTacToe();
    }

    public Token getToken() {
        return this.game.getToken();
    }

    public boolean isUser() {
        return this.game.isUser();
    }

    public Error isValidCoordinate(Coordinate coordinate) {
        ClosedInterval limits = new ClosedInterval(0, Coordinate.DIMENSION - 1);
        if (!limits.isIncluded(coordinate.getRow()) || !limits.isIncluded(coordinate.getColumn())) {
            return Error.NOT_VALID;
        }
        return Error.NULL;
    }

    public Coordinate getRandomCoordinate() {
        Coordinate coordinate = new Coordinate();
        coordinate.random();
        return coordinate;
    }

    public Error put(Coordinate coordinate) {
        Error error = this.game.put(coordinate);
        if (error.isNull() && this.game.isTicTacToe()) {
            this.state.next();
        }
        return error;
    }

    public Error move(Coordinate origin, Coordinate target) {
        Error error = this.game.move(origin, target);
        if (error.isNull() && this.game.isTicTacToe()) {
            this.state.next();
        }
        return error;
    }

}
