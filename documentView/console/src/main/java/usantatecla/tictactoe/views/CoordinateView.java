package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.utils.models.ConcreteCoordinate;
import usantatecla.utils.views.SquareBoundedCoordinateView;
import usantatecla.utils.models.SquaredBoundedCoordinate;

public class CoordinateView extends SquareBoundedCoordinateView {

    @Override
    public SquaredBoundedCoordinate createCoordinate(ConcreteCoordinate concreteCoordinate) {
        return new Coordinate(concreteCoordinate);
    }

}