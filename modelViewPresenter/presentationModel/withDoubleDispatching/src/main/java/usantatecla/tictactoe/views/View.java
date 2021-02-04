package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.*;

public abstract class View implements ControllersVisitor {

    public void interact(Logic logic) {
        Controller controller;
        do {
            controller = logic.getController();
            if (controller != null) {
                controller.accept(this);
                this.interact(logic);
            }
        } while (controller != null);
    }

}
