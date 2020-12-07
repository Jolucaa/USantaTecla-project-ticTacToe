package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;

public abstract class View {

    protected StartController startController;
    protected PlayController playController;
    protected ResumeController resumeController;

    public View(StartController startController, PlayController playController, ResumeController resumeController) {
        this.startController = startController;
        this.playController = playController;
        this.resumeController = resumeController;
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
