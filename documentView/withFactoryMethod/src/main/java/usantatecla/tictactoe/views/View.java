package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;

public abstract class View extends WithGameView {

    public View(Game game) {
        super(game);
    }

    public void interact() {
        do {
            this.start();
            this.play();
        } while (this.isNewGame());
    }

    protected abstract void start();

    protected abstract void play();

    protected abstract boolean isNewGame();

}