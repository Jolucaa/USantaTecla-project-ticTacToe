package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;

public class StartController extends Controller implements AcceptorController {

    public StartController(Session session) {
        super(session);
    }

    public Color getColor(Coordinate coordinate) {
        return this.session.getColor(coordinate);
    }

    @Override
    public void accept(ControllersVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
}
