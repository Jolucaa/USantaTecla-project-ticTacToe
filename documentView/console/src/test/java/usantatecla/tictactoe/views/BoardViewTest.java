package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.*;
import usantatecla.tictactoe.types.Color;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class BoardViewTest {

    @Mock
    private Game game;

    @InjectMocks
    private BoardView boardView;

    @Mock
    private Console console;

    @Captor
    private ArgumentCaptor<String> captor;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    void testGivenNewGameViewWhenWriteThenPrintBoard() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.game.getColor(any(Coordinate.class))).thenReturn(Color.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.boardView.write();
            verify(this.console, times(2)).writeln(Message.HORIZONTAL_LINE.toString());
            verify(this.console, times(12)).write(Message.VERTICAL_LINE.toString());
            verify(this.console, times(21)).write(captor.capture());
            assertThat(captor.getAllValues().toString(), is("[ | , X,  | , X,  | , X,  | , " +
                                                                   " | , X,  | , X,  | , X,  | , " +
                                                                   " | , X,  | , X,  | , X,  | ]"));
        }
    }

    @Test
    public void testGivenCompleteBoardWhenWriteThenPrintInCorrectOrder() {
        Console console = mock(Console.class);
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(console);
            InOrder colorPrinted = inOrder(console);
            /*this.game = new GameBuilder().rows(
                    "X X",
                    "XO ",
                    "O O").build();*/
            when(this.game.getColor(any(Coordinate.class))).thenReturn( //TODO ?
                    Color.X,Color.NULL,Color.X,
                    Color.X,Color.O,Color.NULL,
                    Color.O,Color.NULL,Color.O);
            this.boardView.write();
            verify(console, times(2)).writeln("---------------");
            verify(console, times(Coordinate.DIMENSION*Coordinate.DIMENSION + Coordinate.DIMENSION)).write(" | ");
            verify(console, times(Coordinate.DIMENSION)).writeln();
            colorPrinted.verify(console).write("X");
            colorPrinted.verify(console).write(" ");
            colorPrinted.verify(console).write("X");
            colorPrinted.verify(console).write("X");
            colorPrinted.verify(console).write("O");
            colorPrinted.verify(console).write(" ");
            colorPrinted.verify(console).write("O");
            colorPrinted.verify(console).write(" ");
            colorPrinted.verify(console).write("O");
        }
    }

    @Test
    public void testGivenEmptyBoardWhenWriteThenPrint() {
        Console console = mock(Console.class);
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(console);
            /*Board board = new BoardBuilder().rows(
                    "   ",
                    "   ",
                    "   ").build();*/
            when(this.game.getColor(any(Coordinate.class))).thenReturn(Color.NULL);
            this.boardView.write();
            verify(console, times(2)).writeln("---------------");
            verify(console, times(Coordinate.DIMENSION*Coordinate.DIMENSION + Coordinate.DIMENSION)).write(" | ");
            verify(console, times(Coordinate.DIMENSION)).writeln();
            verify(console, times(Coordinate.DIMENSION*Coordinate.DIMENSION)).write(" ");
        }
    }


}
