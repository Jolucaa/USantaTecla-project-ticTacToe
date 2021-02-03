package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Game;
import usantatecla.utils.views.Console;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerViewTest {

    private PlayerView playerView;

    @Mock
    private Console console;

    @BeforeEach
    public void beforeEach() {
        this.playerView = new PlayerView(new Game());
    }

    @Test
    public void testGivenPlayerViewWhenWriteWinnerThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.playerView.writeWinner();
            verify(this.console).writeln("X player: You win!!! :-)");
        }
    }

}
