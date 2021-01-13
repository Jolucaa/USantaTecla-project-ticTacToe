package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.views.Message;

public class MachinePlayer extends Player {

	public MachinePlayer(Color color, Board board) {
		super(color, board);
	}

	protected Coordinate getCoordinate(Message message){
		Coordinate coordinate = new Coordinate();
		coordinate.random();
		return coordinate;
	}	
	
}
