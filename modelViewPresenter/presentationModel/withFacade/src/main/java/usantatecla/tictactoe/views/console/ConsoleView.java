package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.View;

public class ConsoleView extends View {

    private final StartView startView;
    private final PlayView playView;
    private final ResumeView resumeView;

    public ConsoleView(Logic logic) {
        super(logic);
        this.startView = new StartView(this.logic);
        this.playView = new PlayView(this.logic);
        this.resumeView = new ResumeView(this.logic);
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
    protected boolean isResumed() {
        return this.resumeView.interact();
    }

}