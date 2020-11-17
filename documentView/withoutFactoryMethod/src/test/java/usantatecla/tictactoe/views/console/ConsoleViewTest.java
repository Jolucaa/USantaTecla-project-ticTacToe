package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.*;
import usantatecla.tictactoe.models.Error;
import usantatecla.utils.Console;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsoleViewTest {
    @Mock
    Game game;

    @Mock
    Console console;

    @Captor
    ArgumentCaptor<String> captor;

    ConsoleView consoleView;

    @BeforeEach
    void before() {
        consoleView = new ConsoleView(game);
    }

    @Test
    void testGivenConsoleWhenIsNewGameThenIsFalse() {
        when(this.console.readChar(anyString())).thenReturn('n');
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.consoleView.isNewGame(), is(false));
        }
    }

    @Test
    void testGivenNewGameIsTrueWhenInteractThenIsTrue() {
        when(this.console.readChar(anyString())).thenReturn('y');
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.consoleView.isNewGame(), is(true));
        }
    }

    @Test
    void testGivenNewGameThenStart() {
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.game.getToken(any(Coordinate.class))).thenReturn(Token.NULL);
            consoleView.start();
            Mockito.verify(this.console, times(21)).getInstance().write(captor.capture());
            List<String> captorValue = captor.getAllValues();
            String emptyBoard = "[| , .,  | , .,  | , .,  | , | , .,  | , .,  | , .,  | , | , .,  | , .,  | , .,  | ]";
            assertThat(captorValue.toString(), is(emptyBoard));
        }
        //TODO no coge el título en el capture
    }
    @Test
    void testGivenNewGameWhenPlayThenIsTicTacToe() {
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.game.isUser()).thenReturn(false);
            when(this.game.getToken(any(Coordinate.class))).thenReturn(Token.X, Token.X, Token.X, Token.NULL, Token.O, Token.O, Token.O, Token.NULL, Token.NULL);
            when(this.game.move(any(Coordinate.class), any(Coordinate.class))).thenReturn(Error.NULL);
            when(this.game.isTicTacToe()).thenReturn(true);
            when(this.game.isBoardComplete()).thenReturn(true);
            when(this.game.getToken()).thenReturn(Token.X);
            consoleView.play();
            Mockito.verify(this.console, times(22)).getInstance().write(captor.capture());
            List<String> captorValue = captor.getAllValues();
            String emptyBoard = "X";
            assertThat(captorValue.get(21), is(emptyBoard));
        }
    }
}
