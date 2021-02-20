package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.AcceptorController;
import usantatecla.tictactoe.controllers.ControllersVisitor;
import usantatecla.tictactoe.controllers.Logic;

public abstract class View implements ControllersVisitor {

    public void interact(Logic logic) {
        AcceptorController acceptorController;
        do {
            acceptorController = logic.getController();
            if (acceptorController != null)
                acceptorController.accept(this);
        } while (acceptorController != null);
    }

}
