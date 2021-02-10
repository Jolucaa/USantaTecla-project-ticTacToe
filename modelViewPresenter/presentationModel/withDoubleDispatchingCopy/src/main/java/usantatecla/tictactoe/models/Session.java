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
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

    public void next() {
        this.state.next();
    }

    public void setUsers() {
        this.registry = new Registry(this.game);
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
        Error error = this.game.getPutTokenError(coordinate);
        if (error.isNull()) {
            this.registry.register();
        }
        return error;
    }

    public Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        Error error = this.game.getTargetMoveTokenError(origin, target);
        if (error.isNull()) {
            this.registry.register();
        }
        return error;
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

}
