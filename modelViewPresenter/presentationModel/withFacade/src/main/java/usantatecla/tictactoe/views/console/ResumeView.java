package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.views.YesNoDialog;

class ResumeView {

    Logic logic;

    ResumeView(Logic logic) {
        this.logic = logic;
    }

    boolean interact() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            this.logic.resume();
        }
        return isResumed.isAffirmative();
    }

}
