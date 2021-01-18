package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.views.Message;

public class UserPlayer extends Player {

	public UserPlayer(Color color, Board board) {
		super(color, board);
	}

	@Override
	public PlayerType getType() {
		return PlayerType.USER;
	}

}
