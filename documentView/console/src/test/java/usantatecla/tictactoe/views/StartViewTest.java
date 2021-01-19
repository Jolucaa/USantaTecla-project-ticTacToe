package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Color;
import usantatecla.utils.views.Console;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class StartViewTest {

    @Mock
    private Game game;

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
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.game.getColor(any())).thenReturn(Color.NULL);
            this.startView.interact();
            verify(this.console).writeln(Message.TITLE.toString());
            verify(this.game).setUsers(1);
        }
    }

}
