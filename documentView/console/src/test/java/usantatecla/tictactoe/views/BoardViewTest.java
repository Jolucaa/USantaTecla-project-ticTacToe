package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class BoardViewTest {
    /*
    @Mock
    private Game game;

    @InjectMocks
    private BoardView gameView;

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
            when(this.game.getToken(any(Coordinate.class))).thenReturn(Token.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.gameView.write();
            verify(this.console, times(2)).writeln(Message.SEPARATOR.getMessage());
            verify(this.console, times(3)).write(Message.VERTICAL_LINE_LEFT.getMessage());
            verify(this.console, times(9)).write(Message.VERTICAL_LINE_CENTERED.getMessage());
            verify(this.console, times(3)).writeln(Message.VERTICAL_LINE_RIGHT.getMessage());
            verify(this.console, times(21)).write(captor.capture());
            assertThat(captor.getAllValues().toString(), is("[| , X,  | , X,  | , X,  | , " +
                                                                   "| , X,  | , X,  | , X,  | , " +
                                                                   "| , X,  | , X,  | , X,  | ]"));
        }
    }

    /*
    @Test
    public void testGivenCompleteBoardWhenWriteThenPrintInCorrectOrder() {
        Console console = mock(Console.class);
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(console);
            InOrder colorPrinted = inOrder(console);
            Board board = new BoardBuilder().rows(
                    "X X",
                    "XO ",
                    "O O").build();
            board.write();
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
            Board board = new BoardBuilder().rows(
                    "   ",
                    "   ",
                    "   ").build();
            board.write();
            verify(console, times(2)).writeln("---------------");
            verify(console, times(Coordinate.DIMENSION*Coordinate.DIMENSION + Coordinate.DIMENSION)).write(" | ");
            verify(console, times(Coordinate.DIMENSION)).writeln();
            verify(console, times(Coordinate.DIMENSION*Coordinate.DIMENSION)).write(" ");
        }
    }
    */

}
