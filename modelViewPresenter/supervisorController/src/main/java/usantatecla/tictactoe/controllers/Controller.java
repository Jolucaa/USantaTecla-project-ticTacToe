package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.views.ViewFactory;
import usantatecla.tictactoe.views.BoardView;

public abstract class Controller {

    protected Game game;
    protected ViewFactory viewFactory;

    Controller(Game game, ViewFactory viewFactory) {
        this.game = game;
        this.viewFactory = viewFactory;
    }

}
