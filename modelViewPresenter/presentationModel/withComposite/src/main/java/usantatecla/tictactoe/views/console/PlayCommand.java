package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.views.Message;

class PlayCommand extends Command {

    PlayCommand(PlayController playController) {
        super(Message.ACTION_COMMAND.toString(), playController);
    }

    @Override
    public void execute() {
        if (!this.playController.areAllTokensOnBoard()) {
            this.put();
        } else {
            this.move();
        }
        new BoardView().write(this.playController);
        if (playController.isTicTacToe()) {
            new ColorView().write(playController.getActiveColor());
            new MessageView().writeln(Message.PLAYER_WIN,playController.getActiveColor().name());
        }
    }

    private void put() {
        this.playController.put(new PlayerView(this.playController).getCoordinate(Message.ENTER_COORDINATE_TO_PUT));
    }

    private void move() {
        this.playController.move(new PlayerView(this.playController).getCoordinate(Message.COORDINATE_TO_REMOVE),
                new PlayerView(this.playController).getCoordinate(Message.COORDINATE_TO_MOVE));
    }

    @Override
    public boolean isActive() {
        return true;
    }

}
