package usantatecla.tictactoe.views.graphics;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.View;

public class GraphicsView extends View {

    @Override
    protected void start(StartController startController) {
    }

    @Override
    protected void play(PlayController playController) {
    }

    @Override
    protected boolean resume(ResumeController resumeController) {
        return true;
    }

}
