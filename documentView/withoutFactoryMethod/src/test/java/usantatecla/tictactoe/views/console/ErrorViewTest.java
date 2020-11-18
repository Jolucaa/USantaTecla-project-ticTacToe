package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Error;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class ErrorViewTest {

    @Mock
    Error error;

    @InjectMocks
    ErrorView errorView;

    @Mock
    Console console;

    @Captor
    ArgumentCaptor<String> captor;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    void testGivenNewGameViewWhenWriteNullErrorThenNeverPrint() {
        when(this.error.isNull()).thenReturn(true);
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.errorView.writeln();
            verify(this.console, never()).writeln(anyString());
        }
    }

    @Test
    void testGivenNewGameViewWhenWriteNotNullErrorThenPrintErrorMessage() {
        when(this.error.isNull()).thenReturn(false);
        when(this.error.ordinal()).thenReturn(0);
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.errorView.writeln();
            verify(this.console).writeln(captor.capture());
            assertThat(captor.getValue(), is(usantatecla.tictactoe.views.ErrorView.MESSAGES[0]));
        }
    }

}
