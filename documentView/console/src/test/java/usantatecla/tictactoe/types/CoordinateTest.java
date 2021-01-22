package usantatecla.tictactoe.types;

import usantatecla.tictactoe.types.Coordinate;
import usantatecla.utils.models.SquaredBoundedCoordinate;
import usantatecla.utils.models.SquaredBoundedCoordinateTest;

public class CoordinateTest extends SquaredBoundedCoordinateTest {

    @Override
    public SquaredBoundedCoordinate getNullCoordinate() {
        return new Coordinate();
    }

    @Override
    public int getDimension() {
        return Coordinate.DIMENSION;
    }

    @Override
    public SquaredBoundedCoordinate getCoordinate(int row, int column) {
        return new Coordinate(row, column);
    }


}
