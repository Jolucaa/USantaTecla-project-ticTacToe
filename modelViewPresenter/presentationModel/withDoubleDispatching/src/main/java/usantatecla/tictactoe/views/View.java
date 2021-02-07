package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.Controller;
import usantatecla.tictactoe.controllers.ControllersVisitor;
import usantatecla.tictactoe.controllers.Logic;

public abstract class View implements ControllersVisitor {

    public void interact(Logic logic) {
        Controller controller;
        do {
            controller = logic.getController();
            if (controller != null)
                controller.accept(this);
        } while (controller != null);
    }

}
