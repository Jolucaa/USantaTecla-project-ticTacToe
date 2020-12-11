package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.AcceptorController;
import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.View;

public class TicTacToe {

    private Logic logic;
    private View view;

    protected TicTacToe() {
        this.logic = new Logic();
        this.view = new View();
    }

    protected void play() {
        AcceptorController controller;
        do {
            controller = this.logic.getController();
            if (controller != null) {
                this.view.interact(controller);
            }
        } while (controller != null);
    }

    public static void main(String[] args) {
        new TicTacToe().play();
    }

}
