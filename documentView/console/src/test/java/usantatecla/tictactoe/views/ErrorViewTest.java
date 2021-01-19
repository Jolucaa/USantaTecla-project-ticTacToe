package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.views.Console;
import usantatecla.tictactoe.types.Error;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class ErrorViewTest {

    @InjectMocks
    private ErrorView errorView;

    @Mock
    private Console console;

    @Captor
    private ArgumentCaptor<String> captor;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    void testGivenNewGameViewWhenWriteNullErrorThenNeverPrint() {
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.errorView.writeln(Error.NULL);
            verify(this.console, never()).writeln(anyString());
        }
    }

    @Test
    void testGivenNewGameViewWhenWriteNotNullErrorThenPrintErrorMessage() {
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.errorView.writeln(Error.NOT_EMPTY);
            verify(this.console).writeln(captor.capture());
            assertThat(captor.getValue(), is("The square is not empty"));
        }
    }

}
