package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.YesNoDialog;

public class ResumeView {

    public boolean interact(ResumeController resumeController) {
        boolean isResumed = new YesNoDialog().read(Message.RESUME.getMessage());
        if (isResumed) {
            resumeController.reset();
        } else {
            resumeController.next();
        }
        return isResumed;
    }

}
