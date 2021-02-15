package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.models.State;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;

import java.net.ProtocolFamily;

public class PlayController extends Controller implements AcceptorController {
    private ActionController actionController;
    private UndoController undoController;
    private RedoController redoController;

    public PlayController(Session session) {
        super(session);
        this.actionController = new ActionController(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);
    }

    public boolean areAllTokensOnBoard() {
        return this.actionController.areAllTokensOnBoard();
    }

    public boolean isTicTacToe() {
        return this.actionController.isTicTacToe();
    }

    public void put(Coordinate coordinate) {
        this.actionController.put(coordinate);
    }

    public void move(Coordinate origin, Coordinate target) {
        this.actionController.move(origin,target);
    }

    public Error getOriginMoveTokenError(Coordinate coordinate) {
        return this.actionController.getOriginMoveTokenError(coordinate);
    }

    public Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        return this.actionController.getTargetMoveTokenError(origin, target);
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

    public void moveToken(Coordinate origin, Coordinate target) {
        this.actionController.move(origin,target);

    }

    public Error getPutTokenError(Coordinate coordinate) {
        return this.actionController.getPutTokenError(coordinate);
    }

    public void putToken(Coordinate coordinate) {
        this.actionController.putToken(coordinate);
    }

    public Color getActiveColor() {
        return this.actionController.getActiveColor();
    }

    public void undo(){
        this.undoController.undo();
    }

    public boolean undoable(){
        return this.undoController.undoable();
    }

    public void redo(){
        this.redoController.redo();
    }

    public boolean redoable(){
        return this.redoController.redoable();
    }

}
