package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;

public abstract class WithGameView {

    protected Game game;

    public WithGameView(Game game) {
        this.game = game;
    }

}
