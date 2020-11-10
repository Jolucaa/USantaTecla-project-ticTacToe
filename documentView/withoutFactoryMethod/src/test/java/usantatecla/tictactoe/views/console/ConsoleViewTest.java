package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Game;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsoleViewTest {
    @Mock
    Game game;

    @Mock
    Console console;

    ConsoleView consoleView;

    @BeforeEach
    void before() {
        consoleView = new ConsoleView(game);
    }

    @Test
    void testGivenConsoleWhenIsNewGameThenIsFalse() {
        when(this.console.readChar(anyString())).thenReturn('n');
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::instance).thenReturn(this.console);
            assertThat(this.consoleView.isNewGame(), is(false));
        }
    }

    @Test
    void testGivenNewGameIsTrueWhenInteractThenIsTrue() {
        when(this.console.readChar(anyString())).thenReturn('y');
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::instance).thenReturn(this.console);
            assertThat(this.consoleView.isNewGame(), is(true));
        }
    }
}
