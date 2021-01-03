package usantatecla.tictactoe;

import usantatecla.utils.SquaredBoundedCoordinate;

class Coordinate extends SquaredBoundedCoordinate {

  public static final int DIMENSION = 3;
  
  Coordinate() {
    super();
  }

  Coordinate(int row, int column) {
    super(row, column);
  }

  @Override
  protected int getDimension() {
    return Coordinate.DIMENSION;
  }

  @Override
  protected String getErrorMessage() {
    return Error.WRONG_COORDINATES.toString();
  }

}
