package usantatecla.tictactoe.views;

import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.utils.models.ConcreteCoordinate;
import usantatecla.utils.models.SquaredBoundedCoordinate;
import usantatecla.utils.views.SquareBoundedCoordinateView;

public class CoordinateView extends SquareBoundedCoordinateView {

    @Override
    public SquaredBoundedCoordinate createCoordinate(ConcreteCoordinate concreteCoordinate) {
        return new Coordinate(concreteCoordinate);
    }

    @Override
    public String getErrorMessage() {
        return ErrorView.MESSAGES[Error.WRONG_COORDINATES.ordinal()];
    }

}