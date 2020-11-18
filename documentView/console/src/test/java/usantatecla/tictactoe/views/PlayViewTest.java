package usantatecla.tictactoe.views;

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
    void testGivenNewPlayViewWhenUserPlayerPutCoordinateThenGamePutCoordinate() {
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
    void testGivenNewPlayViewWhenMachinePlayerPutCoordinateThenGamePutCoordinate() {
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

    @Test
    void testGivenNewPlayViewWhenUserPlayerMoveOriginToTargetThenGameMoveOriginToTarget() {
        when(this.game.isBoardComplete()).thenReturn(true);
        when(this.game.isUser()).thenReturn(true);
        when(this.console.readInt(anyString())).thenReturn(1, 1, 2, 2);
        when(this.game.move(any(Coordinate.class), any(Coordinate.class))).thenReturn(Error.NULL);
        when(this.game.getToken(any(Coordinate.class))).thenReturn(Token.X);
        when(this.game.isTicTacToe()).thenReturn(true);
        when(this.game.getToken()).thenReturn(Token.X);
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.playView.interact();
            verify(this.game).move(new Coordinate(0, 0), new Coordinate(1, 1));
        }
    }

    @Test
    void testGivenNewPlayViewWhenMachinePlayerMoveOriginToTargetThenGameMoveOriginToTarget() {
        Coordinate origin = new Coordinate(0, 0);
        Coordinate target = new Coordinate(0, 0);
        when(this.game.isBoardComplete()).thenReturn(true);
        when(this.game.isUser()).thenReturn(false);
        when(this.playView.createRandomCoordinate()).thenReturn(origin, target);
        when(this.game.move(any(Coordinate.class), any(Coordinate.class))).thenReturn(Error.NULL);
        when(this.game.getToken(any(Coordinate.class))).thenReturn(Token.X);
        when(this.game.isTicTacToe()).thenReturn(true);
        when(this.game.getToken()).thenReturn(Token.X);
        this.playView.interact();
        verify(this.game).move(origin, target);
    }

}
