package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Token;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class GameViewTest {

    @Mock
    Game game;

    @InjectMocks
    GameView gameView;

    @Mock
    Console console;

    @Captor
    ArgumentCaptor<String> captor;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    void testGivenNewGameViewWhenWriteThenPrintBoard() {
        when(this.game.getToken(any(Coordinate.class))).thenReturn(Token.X);
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.gameView.write();
            verify(this.console, times(21)).write(captor.capture());
            assertThat(captor.getAllValues().toString(), is("[| , X,  | , X,  | , X,  | , " +
                                                                   "| , X,  | , X,  | , X,  | , " +
                                                                   "| , X,  | , X,  | , X,  | ]"));
        }
    }

}
