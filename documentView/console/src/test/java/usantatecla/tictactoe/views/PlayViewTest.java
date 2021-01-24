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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayViewTest {

    @Mock
    private Console console;

    @Spy
    private Game game;

    @InjectMocks
    private PlayView playView;

    @BeforeEach
    public void beforeEach() {
        this.game.setUsers(0);
    }

    @Test
    public void testGivenPlayViewWhenInteractThenIsWinner() {
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            doReturn(true).when(this.game).isTicTacToe();
            this.playView.interact();
            verify(this.game).next();
            verify(this.console).writeln("O player: You win!!! :-)");
        }
    }

}
