package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.models.ConcreteCoordinate;
import usantatecla.utils.models.SquaredBoundedCoordinate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class CoordinateViewTest {

    @InjectMocks
    private CoordinateView coordinateView;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    void testGivenNewCoordinateViewWhenCreateCoordinateThenReturnCoordinate() {
            SquaredBoundedCoordinate coordinate = this.coordinateView.createCoordinate(new ConcreteCoordinate(0,0));
            assertThat(coordinate.getColumn(), is(0));
            assertThat(coordinate.getRow(), is(0));
    }

}