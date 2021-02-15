package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.views.Command;
import usantatecla.tictactoe.views.Message;

class UndoCommand extends Command {

    UndoCommand(PlayController playController) {
        super(Message.UNDO_COMMAND.toString(), playController);
    }

    protected void execute() {
        this.playController.undo();
    }

    protected boolean isActive() {
        return this.playController.undoable();
    }

}
