package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;

public abstract class View {

    public void interact(Logic logic) {
        do {
            if (logic.getController() instanceof StartController) {
                this.start((StartController) logic.getController());
            } else {
                if (logic.getController() instanceof PlayController) {
                    this.play((PlayController) logic.getController());
                } else {
                    this.resume((ResumeController) logic.getController());
                }
            }
        } while (logic.getController() != null);
    }

    protected abstract void start(StartController startController);

    protected abstract void play(PlayController playController);

    protected abstract boolean resume(ResumeController resumeController);

}
