package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.View;

public abstract class TicTacToe {

    private final View view;

    protected TicTacToe() {
        Game game = new Game();
        this.view = this.createView(new StartController(game), new PlayController(game), new ResumeController(game));
    }

    protected abstract View createView(StartController startController, PlayController playController, ResumeController resumeController2);

    protected void play() {
        this.view.interact();
    }
}
