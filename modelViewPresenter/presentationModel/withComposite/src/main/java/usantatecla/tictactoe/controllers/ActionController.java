package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.Token;
import usantatecla.utils.ClosedInterval;

public class ActionController extends Controller {

    public ActionController(Session session) {
        super(session);
    }

    public boolean isBoardComplete() {
        return this.session.isBoardComplete();
    }

    public boolean isTicTacToe() {
        return this.session.isTicTacToe();
    }

    public Token getToken() {
        return this.session.getToken();
    }

    public boolean isUser() {
        return this.session.isUser();
    }

    public Error isValidCoordinate(Coordinate coordinate) {
        ClosedInterval limits = new ClosedInterval(0, Coordinate.DIMENSION - 1);
        if (!limits.isIncluded(coordinate.getRow()) || !limits.isIncluded(coordinate.getColumn())) {
            return Error.NOT_VALID;
        }
        return Error.NULL;
    }

    public Error put(Coordinate coordinate) {
        Error error = this.session.put(coordinate);
        if (error.isNull() && this.session.isTicTacToe()) {
            this.session.next();
        }
        return error;
    }

    public Error move(Coordinate origin, Coordinate target) {
        Error error = this.session.move(origin, target);
        if (error.isNull() && this.session.isTicTacToe()) {
            this.session.next();
        }
        return error;
    }

}
