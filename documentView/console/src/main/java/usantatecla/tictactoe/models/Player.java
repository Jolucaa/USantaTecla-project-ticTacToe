package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.views.Message;

public abstract class Player {

	protected Color color;
	protected Board board;
	private int putTokens;

	Player(Color color, Board board) {
		assert !color.isNull();
		assert board != null;

		this.color = color;
		this.board = board;
		this.putTokens = 0;
	}

	public int getPutTokens() {
		return this.putTokens;
	}

	public void putToken(Coordinate coordinate) {
		this.board.put(coordinate, this.color);
		this.putTokens++;
	}

	public abstract PlayerType getType();

	public Error getPutTokenError(Coordinate coordinate) {
		if (!this.board.isEmpty(coordinate)) {
			return Error.NOT_EMPTY;
		}
		return Error.NULL;
	}

	public void moveToken(Coordinate origin, Coordinate target) {
		this.board.move(origin, target);
	}

	public Error getOriginMoveTokenError(Coordinate origin) {
		if (!this.board.isOccupied(origin, this.color)) {
			return Error.NOT_OWNER;
		}
		return Error.NULL;
	}

	public Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
		if (origin.equals(target)) {
			return Error.SAME_COORDINATES;
		}
		if (!this.board.isEmpty(target)) {
			return Error.NOT_EMPTY;
		}
		return Error.NULL;
	}

	Color getColor() {
		return this.color;
	}

}
