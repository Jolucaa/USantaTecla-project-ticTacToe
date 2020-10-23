package usantatecla.tictactoe.models;

import usantatecla.utils.ClosedInterval;
import usantatecla.utils.ConcreteCoordinate;
import usantatecla.utils.Direction;

import java.util.Random;

public class Coordinate extends ConcreteCoordinate {

	private static final Coordinate NULL_COORDINATE = new Coordinate();
	public static final int DIMENSION = 3;
	private static final ClosedInterval LIMITS =
		new ClosedInterval(0, Coordinate.DIMENSION - 1);

	public Coordinate() {
		super();
	}

	public Coordinate(int row, int column) {
		super(row, column);
		assert Coordinate.LIMITS.isIncluded(row);
		assert Coordinate.LIMITS.isIncluded(column);
	}

	@Override
	public boolean isNull() {
		return this == Coordinate.NULL_COORDINATE;
	}

	public Error isValid() {
		if (!LIMITS.isIncluded(this.row) || !LIMITS.isIncluded(this.column)){
			return Error.WRONG_COORDINATES;
		}
		return Error.NULL_ERROR;
	}
	
	@Override
	public Direction getDirection(usantatecla.utils.Coordinate coordinate) {
		assert coordinate != null;

		if (coordinate.isNull()){
			return Direction.NULL;
		}
		if (this.inInverseDiagonal() && ((Coordinate) coordinate).inInverseDiagonal()) {
			return Direction.INVERSE_DIAGONAL;
		}
		return super.getDirection(coordinate);
	}

	private boolean inInverseDiagonal() {
		if (this.isNull()){
			return false;
		}
		return this.row + this.column == Coordinate.DIMENSION - 1;
	}

	public void random() {
		Random random = new Random(System.currentTimeMillis());
		this.row = random.nextInt(Coordinate.DIMENSION);
		this.column = random.nextInt(Coordinate.DIMENSION);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (this.isNull() || other.isNull()){
			return false;
		}
		return super.equals(other);
	}

}
