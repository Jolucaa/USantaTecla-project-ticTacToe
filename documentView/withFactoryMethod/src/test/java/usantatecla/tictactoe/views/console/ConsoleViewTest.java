package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.*;
import usantatecla.utils.Console;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
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
            Mockito.verify(this.console, times(12)).getInstance().write(captor.capture());
            List<String> captorValue = captor.getAllValues();
            String emptyBoard = "[| ,  | ,  | ,  | , | ,  | ,  | ,  | , | ,  | ,  | ,  | ]";
            assertThat(captorValue.toString(), is(emptyBoard));
        }
        //TODO no coge el título en el capture
    }

    /*@Mock
    Game game;

    @Mock
    StartView startView;

    @Mock
    PlayView playView;

    @Mock
    ResumeView resumeView;

    @InjectMocks
    ConsoleView consoleView;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    void givenNewConsoleViewWhenStartThenVerifyStartViewInteract() {
        this.consoleView.start();
        verify(this.startView).interact();
    }

    @Test
    void givenNewConsoleViewWhenPlayThenVerifyPlayInteract() {
        this.consoleView.play();
        verify(this.playView).interact();
    }

    @Test
    void givenNewConsoleViewWhenIsNewGameThenVerifyResumeViewInteract() {
        when(this.resumeView.interact()).thenReturn(true);
        assertThat(this.consoleView.isNewGame(), is(true));
    }*/
}
