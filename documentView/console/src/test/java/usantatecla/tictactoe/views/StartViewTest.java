package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Game;
import usantatecla.utils.views.Console;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StartViewTest {

    @Mock
    private Console console;

    @Spy
    private Game game;

    @InjectMocks
    private StartView startView;
    private ViewTestUtils viewTestUtils;

    @BeforeEach
    public void beforeEach() {
        this.viewTestUtils = new ViewTestUtils();
    }

    @Test
    public void testGivenStartViewWhenInteractThenInteract() {
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(1);
            this.startView.interact();
            verify(this.game).setUsers(1);
            String string = this.viewTestUtils.arrayToString(new String[]{
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
            this.viewTestUtils.reorder(argumentCaptorValues);
            assertThat(string, is(this.viewTestUtils.arrayToString(argumentCaptorValues.toArray())));
        }
    }

}
