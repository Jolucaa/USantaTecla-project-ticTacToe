package usantatecla.tictactoe.models;

import usantatecla.utils.SquaredBoundedCoordinate;
import usantatecla.utils.SquaredBoundedCoordinateTest;

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
