package usantatecla.tictactoe.views;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.utils.views.SquaredBoundedCoordinateView;
import usantatecla.utils.views.SquaredBoundedCoordinateViewTest;

@ExtendWith(MockitoExtension.class)
public class CoordinateViewTest extends SquaredBoundedCoordinateViewTest {

    @Override
    public int getDimension() {
        return Coordinate.DIMENSION;
    }

    @Override
    public SquaredBoundedCoordinateView getCoordinateView() {
        return new CoordinateView();
    }

}