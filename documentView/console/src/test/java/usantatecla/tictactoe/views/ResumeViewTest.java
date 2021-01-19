package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Game;
import usantatecla.utils.views.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class ResumeViewTest {

    @Mock
    private Console console;

    @Spy
    private Game game;

    @InjectMocks
    private ResumeView resumeView;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    void testGivenNewGameIsFalseWhenInteractThenIsFalse() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.console.readString(anyString())).thenReturn("n");
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.resumeView.interact(), is(false));
        }
    }

    @Test
    void testGivenNewGameIsTrueWhenInteractThenIsTrue() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.console.readString(anyString())).thenReturn("y");
            console.when(Console::getInstance).thenReturn(this.console);
            doNothing().when(this.game).reset();
            assertThat(this.resumeView.interact(), is(true));
        }
    }

}
