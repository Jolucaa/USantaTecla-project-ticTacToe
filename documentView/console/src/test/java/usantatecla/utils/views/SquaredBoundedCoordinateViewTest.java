package usantatecla.utils.views;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.models.ClosedInterval;
import usantatecla.utils.models.ConcreteCoordinate;
import usantatecla.utils.models.SquaredBoundedCoordinate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SquaredBoundedCoordinateViewTest {

    @Mock
    Console console;

    private static final int DIMENSION = 7;
    private static final String ERROR = "error";

    public SquaredBoundedCoordinate getNullCoordinate() {
        return new SquaredBoundedCoordinate() {
            @Override
            protected int getDimension() {
                return SquaredBoundedCoordinateViewTest.DIMENSION;
            }
        };
    }

    public int getDimension() {
        return SquaredBoundedCoordinateViewTest.DIMENSION;
    }

    public SquaredBoundedCoordinate getCoordinate(int row, int column) {
        return new SquaredBoundedCoordinate(row, column) {
            @Override
            protected int getDimension() {
                return SquaredBoundedCoordinateViewTest.DIMENSION;
            }
        };
    }

    public SquaredBoundedCoordinateView getCoordinateView() {
        return new SquaredBoundedCoordinateView() {

            @Override
            public SquaredBoundedCoordinate createCoordinate(ConcreteCoordinate concreteCoordinate) {
                return getCoordinate(1, 2);
            }

            @Override
            public String getErrorMessage() {
                return SquaredBoundedCoordinateViewTest.ERROR;
            }

        };
    }

    @Test
    public void testGivenSquaredBoundedCoordinateWhenGetLimitsThenCorrect() {
        int row = 0;
        int column = this.getDimension() - 1;
        SquaredBoundedCoordinate coordinate = this.getCoordinate(row + 1, column - 1);
        assertThat(coordinate.getLimits(), is(new ClosedInterval(row, column)));
    }

    @Test
    public void testGivenSquareBoundedCoordinateWhenReadThenCorrect() {
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(this.getDimension());
            SquaredBoundedCoordinateView coordinate = this.getCoordinateView();

            assertThat(coordinate.read("").getRow(), is(1));
            assertThat(coordinate.read("").getColumn(), is(2));
        }
    }

    //TODO ?Revisar metodo read SquareBoundedCoordinate y ver assert en constructor
    /*@Test
    public void testGivenSquareBoundedCoordinateWhenReadThenIncorrect() {
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(this.getDimension() + 1, this.getDimension());
            SquaredBoundedCoordinateView coordinate = this.getCoordinateView();
            coordinate.read("");
            verify(this.console).writeln(coordinate.getErrorMessage());
        }
    }*/

}
