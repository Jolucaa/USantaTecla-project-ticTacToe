package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Token;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class StartViewTest {

    @Mock
    private Logic logic;

    @InjectMocks
    private StartView startView;

    @Mock
    private Console console;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    void testGivenNewStartViewWhenReadNumberOfUsersThenGameSetNumberOfUsers() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.console.readInt(anyString())).thenReturn(1);
            when(this.logic.getMaxPlayers()).thenReturn(2);
            when(this.logic.getToken(any(Coordinate.class))).thenReturn(Token.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.startView.interact();
            verify(this.console).writeln(Message.TITLE.getMessage());
            verify(this.logic).setUsers(1);
        }
    }
}
