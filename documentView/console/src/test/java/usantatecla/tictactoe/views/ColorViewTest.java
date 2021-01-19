package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.types.Color;
import usantatecla.utils.views.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;


@ExtendWith(MockitoExtension.class)
public class ColorViewTest {

    @InjectMocks
    private ColorView ColorView;

    @Mock
    private Console console;

    @Captor
    private ArgumentCaptor<String> captor;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    void testGivenNewColorViewWhenWriteThenPrintXColor() {
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            ColorView.write(Color.X);
            verify(this.console).getInstance().write(captor.capture());
            assertThat(captor.getValue(), is(Color.X.toString()));
        }
    }
    
    @Test
    public void testGivenColorWhenWriteThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            ColorView.write(Color.X);
            ColorView.write(Color.O);
            ColorView.write(Color.NULL);
            verify(this.console).write("X");
            verify(this.console).write("O");
            verify(this.console).write(" ");
        }
    }
    

}
