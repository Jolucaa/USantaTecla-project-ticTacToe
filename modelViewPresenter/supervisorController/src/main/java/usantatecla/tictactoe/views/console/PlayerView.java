package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.views.Message;
import usantatecla.tictactoe.views.WithGameView;

public class PlayerView extends WithGameView implements usantatecla.tictactoe.views.PlayerView {

    PlayerView(Game game) {
        super(game);
    }

    public void writeWinner() {
        new MessageView().writeln(Message.PLAYER_WIN, this.game.getActiveColor().name());
    }

}
