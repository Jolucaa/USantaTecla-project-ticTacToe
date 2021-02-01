package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.console.StartView;

public class StartController extends Controller {

    public StartController(Game game) {
        super(game);
    }

    public void control() {
        new StartView().write();
        this.writeBoard();
    }

}
