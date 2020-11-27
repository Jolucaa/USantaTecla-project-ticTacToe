package usantatecla.tictactoe.views.console;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.utils.Console;

@ExtendWith(MockitoExtension.class)
public class CoordinateViewTest {
    static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";

    @Mock
    Console console;

    @InjectMocks
    CoordinateView coordinateView = new CoordinateView();

    @Test
    public void testGivenNewCoordinateViewWhenReadCoordinateThenIsCorrect() {
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt("Row: ")).thenReturn(1);
            when(this.console.readInt("Column: ")).thenReturn(1);
            Coordinate coordinateRead = this.coordinateView.read(ENTER_COORDINATE_TO_PUT);
            Coordinate coordinateExpected = new Coordinate(0, 0);
            assertEquals(coordinateExpected.getRow(), coordinateRead.getRow());
            assertEquals(coordinateExpected.getColumn(), coordinateRead.getColumn());
        }
    }

    @Test
    public void testGivenNewCoordinatesWhenRow4AndColumn4ThenAssertionException() {
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt("Row: ")).thenReturn(4);
            when(this.console.readInt("Column: ")).thenReturn(4);
            assertThrows(AssertionError.class, () -> this.coordinateView.read("Title"));
            verify(this.console).readInt("Row: ");
            verify(this.console).readInt("Column: ");
        }
    }

    @Test
    public void testGivenNewCoordinatesWhenRow0AndColumn0ThenAssertionException() {
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt("Row: ")).thenReturn(0);
            when(this.console.readInt("Column: ")).thenReturn(0);
            assertThrows(AssertionError.class, () -> this.coordinateView.read("Title"));
            verify(this.console).readInt("Row: ");
            verify(this.console).readInt("Column: ");
        }
    }

    @Test
    public void testGivenNewCoordinatesWhenRow1AndColumn1ThenIsCorrect() {
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt("Row: ")).thenReturn(1);
            when(this.console.readInt("Column: ")).thenReturn(1);
            this.coordinateView.read("Title");
            verify(this.console).readInt("Row: ");
            verify(this.console).readInt("Column: ");
        }
    }

    @Test
    public void testGivenNewCoordinatesWhenRow3AndColumn3ThenIsCorrect() {
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt("Row: ")).thenReturn(3);
            when(this.console.readInt("Column: ")).thenReturn(3);
            this.coordinateView.read("Title");
            verify(this.console).readInt("Row: ");
            verify(this.console).readInt("Column: ");
        }
    }
}