package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;

public abstract class View {


    public View() {

    }

    //TODO necesario instance of??
    public void interact(Logic logic) {
        do {
            this.start((StartController) logic.getController());
            this.play((PlayController) logic.getController());
        } while (this.resume((ResumeController) logic.getController()));
    }

    protected abstract void start(StartController startController);

    protected abstract void play(PlayController playController);

    protected abstract boolean resume(ResumeController resumeController);

}
