package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.PlayerType;

public class UserPlayer extends Player {

    UserPlayer(Color color, Board board) {
        super(color, board);
        this.type = PlayerType.USER;
    }

}
