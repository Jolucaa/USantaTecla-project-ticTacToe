package usantatecla.tictactoe;

import usantatecla.utils.SquaredBoundedCoordinate;
import usantatecla.utils.SquaredBoundedCoordinateTest;

public class CoordinateTest extends SquaredBoundedCoordinateTest {

    protected static final int BOUND = 3;
    protected static final String ERROR = "ERROR";

    @Override
    public SquaredBoundedCoordinate getNullCoordinate() {
        return new SquaredBoundedCoordinate() {
            @Override
            public int getDimension() {
                return CoordinateTest.BOUND;
            }

            @Override
            protected String getErrorMessage() {
                return CoordinateTest.ERROR;
            }
        };
    }

    @Override
    public int getDimension() {
        return CoordinateTest.BOUND;
    }

    @Override
    public SquaredBoundedCoordinate getCoordinate(int row, int column) {
        return new SquaredBoundedCoordinate(row, column) {
            @Override
            public int getDimension() {
                return CoordinateTest.BOUND;
            }

            @Override
            protected String getErrorMessage() {
                return CoordinateTest.ERROR;
            }
        };
    }


}
