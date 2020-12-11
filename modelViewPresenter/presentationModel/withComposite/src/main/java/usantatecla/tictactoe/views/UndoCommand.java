package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.PlayController;

class UndoCommand extends Command {

    UndoCommand(PlayController playController) {
        super(Message.UNDO_COMMAND.getMessage(), playController);
    }

    protected void execute() {
        this.playController.undo();
    }

    protected boolean isActive() {
        return this.playController.undoable();
    }

}