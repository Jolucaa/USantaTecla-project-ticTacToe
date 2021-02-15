package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;

public class Session {

    private Game game;
    private Registry registry;
    private State state;

    public Session() {
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(game);
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

    public void nextState() {
        this.state.next();
    }

    public void reset() {
        this.game.reset();
        this.state.reset();
    }

    public boolean areAllTokensOnBoard() {
        return this.game.areAllTokensOnBoard();
    }

    public boolean isTicTacToe() {
        return this.game.isTicTacToe();
    }

    public Color getActiveColor() {
        return this.game.getActiveColor();
    }

    public Error getPutTokenError(Coordinate coordinate) {
        return this.game.getPutTokenError(coordinate);

    }

    public void putToken(Coordinate coordinate) {
        this.game.putToken(coordinate);
        this.game.next();
        this.registry.register();
    }

    public Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        return this.game.getTargetMoveTokenError(origin, target);
    }

    public Error getOriginMoveTokenError(Coordinate coordinate) {
        return this.game.getOriginMoveTokenError(coordinate);
    }

    public void move(Coordinate origin, Coordinate target) {
        this.game.moveToken(origin,target);
        this.game.next();
        this.registry.register();
    }

    public void undo() {
        this.registry.undo();
    }

    public boolean undoable() {
        return this.registry.isUndoable();
    }

    public void redo() {
        this.registry.redo();
    }

    public boolean redoable() {
        return this.registry.isRedoable();
    }


    public void next() {
        this.game.next();
    }
}
