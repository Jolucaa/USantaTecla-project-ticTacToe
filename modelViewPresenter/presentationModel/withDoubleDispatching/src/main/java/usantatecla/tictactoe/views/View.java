package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.*;

// TODO ¿Por qué cambia tanto respecto a la versión anterior?
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
