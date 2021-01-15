package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.Message;

public class UserPlayer extends Player {

	public UserPlayer(Color color, Board board) {
		super(color, board);
	}

	protected Coordinate getCoordinate(Message message){//TODO PlayerView con Doble Despacho
		assert message != null;
		
		Coordinate coordinate = new Coordinate();
		coordinate.read(message.toString());
		return coordinate;
	}

	@Override
	protected Error getPutTokenError(Coordinate coordinate) {
		assert coordinate != null;
		
		Error error = super.getPutTokenError(coordinate);
		return error;
	}
	
	@Override
	protected Error getOriginMoveTokenError(Coordinate coordinate) {
		assert !coordinate.isNull();
		
		Error error = super.getOriginMoveTokenError(coordinate);
		return error;
	}

	@Override
	protected Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
		assert !origin.isNull() && !target.isNull();
		
		Error error = super.getTargetMoveTokenError(origin, target);
		return error;
	}

}
