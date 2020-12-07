package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.Logic;

public abstract class WithGameView {

    protected Logic logic;

    public WithGameView(Logic logic) {
        this.logic = logic;
    }

}
