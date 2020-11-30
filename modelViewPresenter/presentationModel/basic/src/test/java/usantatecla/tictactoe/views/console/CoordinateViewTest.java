package usantatecla.tictactoe.views.console;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.types.Error;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class CoordinateViewTest {

    @Mock
    private Console console;

    @Mock
    private PlayController playController;

    @InjectMocks
    private CoordinateView coordinateView;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    void testGivenNewCoordinateViewWhenReadCoordinateThenReturnCoordinate() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.console.readInt(anyString())).thenReturn(1);
            when(this.playController.isValidCoordinate(any(int[].class))).thenReturn(Error.NULL);
            console.when(Console::getInstance).thenReturn(this.console);
            int[] coordinate = this.coordinateView.read("");
            verify(this.console).writeln("");
            assertThat(coordinate, is(new int[]{0, 0}));
        }
    }

    @Test
    void testGivenNewCoordinateViewWhenReadInvalidCoordinateThenReadValidCoordinateAndReturnValidCoordinate() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.console.readInt(anyString())).thenReturn(4, 1);
            when(this.playController.isValidCoordinate(any(int[].class))).thenReturn(Error.NOT_VALID, Error.NULL);
            console.when(Console::getInstance).thenReturn(this.console);
            int[] coordinate = this.coordinateView.read("");
            verify(this.console, times(2)).writeln("");
            verify(this.console, times(4)).readInt(anyString());
            assertThat(coordinate, is(new int[]{0, 0}));
        }
    }

}
