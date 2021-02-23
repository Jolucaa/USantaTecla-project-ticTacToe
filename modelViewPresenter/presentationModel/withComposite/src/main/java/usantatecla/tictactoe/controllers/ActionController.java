package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;

class ActionController extends Controller  {

    public ActionController(Session session) {
        super(session);
    }

    public boolean areAllTokensOnBoard() {
        return this.session.areAllTokensOnBoard();
    }

    public boolean isTicTacToe() {
        return this.session.isTicTacToe();
    }

    public Error put(Coordinate coordinate) {
        Error error = this.session.getPutTokenError(coordinate);
        if (error.isNull() && !this.session.isTicTacToe()) {
            this.session.putToken(coordinate);
        }
        return error;
    }

    public Error move(Coordinate origin, Coordinate target) {
        Error error = this.session.getTargetMoveTokenError(origin, target);
        if (error.isNull() && !this.session.isTicTacToe()) {
            this.session.moveToken(origin,target);
            this.session.nextState();
        }
        return error;
    }

    public Error getOriginMoveTokenError(Coordinate coordinate) {
        return this.session.getOriginMoveTokenError(coordinate);
    }

    public Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        return this.session.getTargetMoveTokenError(origin,target);
    }

    public Error getPutTokenError(Coordinate coordinate) {
        return this.session.getPutTokenError(coordinate);
    }

    public void putToken(Coordinate coordinate) {
        this.session.putToken(coordinate);
    }

    public Color getActiveColor() {
        return this.session.getActiveColor();
    }
}
