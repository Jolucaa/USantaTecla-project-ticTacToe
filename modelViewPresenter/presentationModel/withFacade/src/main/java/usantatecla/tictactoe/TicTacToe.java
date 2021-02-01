package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.View;

public abstract class TicTacToe {

    private final View view;

    protected TicTacToe() {
        this.view = this.createView(new Logic(new Game()));
    }

    protected abstract View createView(Logic logic);

    protected void play() {
        this.view.interact();
    }

}
