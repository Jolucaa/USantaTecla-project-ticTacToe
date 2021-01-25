package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;

public class View extends WithGameView {

    private final StartView startView;
    private final PlayView playView;
    private final ResumeView resumeView;

    public View(Game game) {
        super(game);
        this.startView = new StartView(this.game);
        this.playView = new PlayView(this.game);
        this.resumeView = new ResumeView(this.game);
    }

    public void interact() {
        do {
            this.startView.interact();
            this.playView.interact();
        } while (this.resumeView.interact());
    }
}
