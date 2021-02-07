package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;

public class StartController extends Controller {

    public StartController(Game game, State state) {
        super(game, state);
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
