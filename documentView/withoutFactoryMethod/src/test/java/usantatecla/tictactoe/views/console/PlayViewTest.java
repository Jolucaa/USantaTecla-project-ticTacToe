package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Error;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Token;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class PlayViewTest {

    @Mock
    Game game;

    @InjectMocks
    PlayView playView;

    @Mock
    Console console;

    @Captor
    ArgumentCaptor<String> captor;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    void givenNewPlayViewWhenUserPlayerPutXTokenThenXTokenIsPrinted() {
        when(this.game.isBoardComplete()).thenReturn(false);
        when(this.game.isUser()).thenReturn(true);
        when(this.console.readInt(anyString())).thenReturn(1);
        when(this.game.put(any(Coordinate.class))).thenReturn(Error.NULL);
        when(this.game.getToken(any(Coordinate.class))).thenReturn(Token.X);
        when(this.game.isTicTacToe()).thenReturn(true);
        when(this.game.getToken()).thenReturn(Token.X);
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.playView.interact();
            verify(this.console, times(22)).write(captor.capture());
            assertThat(captor.getAllValues().contains(Token.X.toString()), is(true));
        }
    }

}
