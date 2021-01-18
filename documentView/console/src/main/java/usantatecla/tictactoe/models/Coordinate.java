package usantatecla.tictactoe.models;

import usantatecla.utils.models.ConcreteCoordinate;
import usantatecla.utils.models.SquaredBoundedCoordinate;
import usantatecla.tictactoe.types.Error;

public class Coordinate extends SquaredBoundedCoordinate {

  public static final int DIMENSION = 3;
  
  public Coordinate() {
    super();
  }

  public Coordinate(int row, int column) {
    super(row, column);
  }

  public Coordinate(ConcreteCoordinate concreteCoordinate) {
    super(concreteCoordinate);
  }

  @Override
  protected int getDimension() {
    return Coordinate.DIMENSION;
  }

  @Override
  public String getErrorMessage() {
    return Error.WRONG_COORDINATES.toString();
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
    if(!other.isNull()) {
      if (this.getRow() != other.getRow())
        return false;
      if (this.getColumn() != other.getColumn())
        return false;
    }
    return true;
  }

}
