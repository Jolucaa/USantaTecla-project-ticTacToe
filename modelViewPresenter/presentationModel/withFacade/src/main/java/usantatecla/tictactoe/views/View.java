package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.Logic;

public abstract class View extends WithLogicView {

    public View(Logic logic) {
        super(logic);
    }

    public void interact() {
        do {
            this.start();
            this.play();
        } while (this.isResumed());
    }

    protected abstract void start();

    protected abstract void play();

    protected abstract boolean isResumed();

}