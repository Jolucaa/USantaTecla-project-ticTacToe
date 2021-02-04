package usantatecla.tictactoe.views.graphics;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.View;

public class GraphicsView extends View {

    public void visitStartController(StartController startController) {
    }

    public void visitPlayController(PlayController playController) {
    }

    public boolean visitResumeController(ResumeController resumeController) {
        return true;
    }

}
