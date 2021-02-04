package usantatecla.tictactoe.views.console;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Color;
import usantatecla.utils.views.Console;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StartViewTest {

    @Mock
    private Console console;

    @Mock
    private StartController startController;

    private StartView startView;
    private Conversor conversor;

    @BeforeEach
    public void beforeEach() {
        this.startView = new StartView();
        this.conversor = new Conversor();
    }

    @Test
    public void testGivenStartViewWhenInteractThenInteract() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.startController.getColor(any())).thenReturn(
                    Color.NULL, Color.NULL, Color.NULL,
                    Color.NULL, Color.NULL, Color.NULL,
                    Color.NULL, Color.NULL, Color.NULL
            );
            this.startView.interact(this.startController);
            String string = this.conversor.arrayToString(new String[]{
                    "--- TIC TAC TOE ---",
                    "---------------",
                    " |   |   |   | ",
                    " |   |   |   | ",
                    " |   |   |   | ",
                    "---------------"
            });
            ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
            verify(this.console, atLeast(0)).writeln(argumentCaptor.capture());
            verify(this.console, atLeast(0)).write(argumentCaptor.capture());
            List<String> argumentCaptorValues = argumentCaptor.getAllValues();
            this.conversor.reorder(argumentCaptorValues);
            assertThat(string, is(this.conversor.arrayToString(argumentCaptorValues.toArray())));
        }
    }

}
