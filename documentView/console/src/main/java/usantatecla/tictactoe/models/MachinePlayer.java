package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.views.Message;

public class MachinePlayer extends Player {

	public MachinePlayer(Color color, Board board) {
		super(color, board);
	}

	public Coordinate getRandomCoordinate(){
		Coordinate coordinate = new Coordinate();
		coordinate.random();
		return coordinate;
	}

	@Override
	public PlayerType getType() {
		return PlayerType.MACHINE;
	}

}
