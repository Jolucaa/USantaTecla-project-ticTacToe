package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Token;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StartViewTest {

    @Mock
    private StartController startController;

    @InjectMocks
    private StartView startView;

    @Mock
    private Console console;

    @Test
    void testGivenNewStartViewWhenReadNumberOfUsersThenGameSetNumberOfUsers() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(1);
            when(this.startController.getMaxPlayers()).thenReturn(2);
            when(this.startController.getToken(any(Coordinate.class))).thenReturn(Token.X);
            this.startView.interact();
            verify(this.console).writeln(Message.TITTLE.getMessage());
            verify(this.startController).setUsers(1);
        }
    }
}
