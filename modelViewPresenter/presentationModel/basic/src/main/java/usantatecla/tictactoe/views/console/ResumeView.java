package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.YesNoDialog;

class ResumeView {

    private final ResumeController resumeController;

    public ResumeView(ResumeController resumeController) {
        this.resumeController = resumeController;
    }

    boolean interact() {
        boolean isResumed = new YesNoDialog().read(Message.RESUME.getMessage());
        if (isResumed) {
            this.resumeController.resume();
        }
        return isResumed;
    }

}
