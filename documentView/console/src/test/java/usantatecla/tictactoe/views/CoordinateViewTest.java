package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CoordinateViewTest {

    @Mock
    private Console console;
    private CoordinateView coordinateView;

    @BeforeEach
    void before() {
        this.coordinateView = new CoordinateView();
    }

    @Test
    void testGivenNewCoordinateViewWhenReadThenIsValidCoordinate() {
        when(this.console.readInt(anyString())).thenReturn(1);
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.coordinateView.read(""), is(new Coordinate(0, 0)));
        }
    }

}