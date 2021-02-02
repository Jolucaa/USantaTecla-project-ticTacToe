package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.View;

public class ConsoleView extends View {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public ConsoleView(Logic logic) {
        super(logic);
        this.startView = new StartView(logic);
        this.playView = new PlayView(logic);
        this.resumeView = new ResumeView(logic);
    }

    @Override
    protected void start() {
        this.startView.interact();
    }

    @Override
    protected void play() {
        this.playView.interact();
    }

    @Override
    protected boolean resume() {
        return this.resumeView.interact();
    }

}
