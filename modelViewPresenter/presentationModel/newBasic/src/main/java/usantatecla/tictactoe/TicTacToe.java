package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.View;

public abstract class TicTacToe {

    private Game game;
    private View view;

    protected TicTacToe() {
        this.game = new Game();
        this.view = this.createView(new StartController(this.game),new PlayController(this.game),new ResumeController(this.game));
    }

    protected abstract View createView(StartController startController, PlayController playController, ResumeController resumeController);

    protected void play() {
        this.view.interact();
    }

}
