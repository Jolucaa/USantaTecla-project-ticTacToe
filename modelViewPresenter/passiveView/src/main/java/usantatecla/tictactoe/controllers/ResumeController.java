package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.console.ResumeView;

public class ResumeController extends Controller {

    public ResumeController(Game game) {
        super(game);
    }

    public boolean control() {
        boolean isResumed = new ResumeView().read();
        if (isResumed) {
            this.game.reset();
        }
        return isResumed;
    }

}
