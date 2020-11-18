package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Error;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Token;
import usantatecla.utils.Console;

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

    @BeforeEach
    void before() {
        openMocks(this);
        this.playView = spy(this.playView);
    }

    @Test
    void givenNewPlayViewWhenUserPlayerPutCoordinateThenGamePutCoordinate() {
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
            verify(this.game).put(new Coordinate(0, 0));
        }
    }

    @Test
    void givenNewPlayViewWhenMachinePlayerPutCoordinateThenGamePutCoordinate() {
        Coordinate coordinate = new Coordinate(0, 0);
        when(this.game.isBoardComplete()).thenReturn(false);
        when(this.game.isUser()).thenReturn(false);
        when(this.playView.createRandomCoordinate()).thenReturn(coordinate);
        when(this.game.put(any(Coordinate.class))).thenReturn(Error.NULL);
        when(this.game.getToken(any(Coordinate.class))).thenReturn(Token.X);
        when(this.game.isTicTacToe()).thenReturn(true);
        when(this.game.getToken()).thenReturn(Token.X);
        this.playView.interact();
        verify(this.game).put(coordinate);
    }

}
