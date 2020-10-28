package usantatecla.tictactoe.models;

import usantatecla.utils.Direction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Board {

	private Token[][] tokens;

	Board() {
		this.tokens = new Token[Coordinate.DIMENSION][Coordinate.DIMENSION];
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			//for (int j = 0; j < Coordinate.DIMENSION; j++) {
				//this.tokens[i][j] = Token.NULL;
			this.tokens[0][i] = Token.NULL;
			this.tokens[1][i] = Token.NULL;
			this.tokens[2][i] = Token.NULL;
			//}
		}
	}

	private Board(Board board) {
		this();
		assert board != null;
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			//for (int j = 0; j < Coordinate.DIMENSION; j++) {
				//this.tokens[i][j] = board.tokens[i][j];
			this.tokens[0][i] = board.tokens[0][i];
			this.tokens[1][i] = board.tokens[1][i];
			this.tokens[2][i] = board.tokens[2][i];
			//}
		}
	}

	Board copy() {
		return new Board(this);
	}

	Token getToken(Coordinate coordinate) {
		assert coordinate != null && !coordinate.isNull();
		return this.tokens[coordinate.getRow()][coordinate.getColumn()];
	}

	void put(Coordinate coordinate, Token token) {
		this.tokens[coordinate.getRow()][coordinate.getColumn()] = token;
	}

	void move(Coordinate origin, Coordinate target) {
		Token token = this.getToken(origin);
		this.tokens[origin.getRow()][origin.getColumn()] = Token.NULL;
		this.put(target, token);
	}

	boolean isCompleted() {
		int tokensCount = 0;
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (!this.tokens[i][j].isNull()) {
					tokensCount++;
				}
			}
		}
		return tokensCount == Coordinate.DIMENSION * 2;
	}

	boolean isOccupied(Coordinate coordinate, Token token) {
		assert coordinate != null && !coordinate.isNull();
		return this.getToken(coordinate) == token;
	}

	boolean isEmpty(Coordinate coordinate) {
		assert coordinate != null && !coordinate.isNull();
		return this.isOccupied(coordinate, Token.NULL);
	}

	boolean isTicTacToe(Token token) {
		assert token != null && !token.isNull();
		List<Coordinate> coordinates = this.getCoordinates(token);
		if (coordinates.size() < Coordinate.DIMENSION) {
			return false;
		}
		Direction[] directions = new Direction[Coordinate.DIMENSION - 1];
		for (int i = 0; i < Coordinate.DIMENSION - 1; i++) {
			directions[i] = coordinates.get(i).getDirection(coordinates.get(i + 1));
			if (directions[i] == Direction.NULL || i > 0 && directions[i - 1] != directions[i]) {
				return false;
			}
		}
		return true;
	}

	private List<Coordinate> getCoordinates(Token token) {
		assert token != null && !token.isNull();
		List<Coordinate> coordinates = new ArrayList<Coordinate>();
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.tokens[i][j] == token) {
					coordinates.add(new Coordinate(i, j));
				}
			}
		}
		return coordinates;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (!Arrays.deepEquals(tokens, other.tokens))
			return false;
		return true;
	}	

}