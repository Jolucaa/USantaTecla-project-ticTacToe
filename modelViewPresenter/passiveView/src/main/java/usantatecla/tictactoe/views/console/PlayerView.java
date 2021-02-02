package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.views.Message;

public class PlayerView implements usantatecla.tictactoe.views.PlayerView {

    public void writeWinner(Color color) {
        Message.PLAYER_WIN.writeln(color.name());
    }

}
