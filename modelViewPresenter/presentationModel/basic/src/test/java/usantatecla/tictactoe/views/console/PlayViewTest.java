package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.models.Token;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class PlayViewTest {

    @Mock
    private PlayController playController;

    @InjectMocks
    private PlayView playView;

    @Mock
    private Console console;

    @BeforeEach
    void before() {
        openMocks(this);
        this.playView = spy(this.playView);
    }

    @Test
    void testGivenNewPlayViewWhenUserPlayerPutCoordinateThenGamePutCoordinate() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.playController.isBoardComplete()).thenReturn(false);
            when(this.playController.isUser()).thenReturn(true);
            when(this.console.readInt(anyString())).thenReturn(1);
            when(this.playController.put(any(Coordinate.class))).thenReturn(Error.NULL);
            when(this.playController.getToken(any(Coordinate.class))).thenReturn(Token.X);
            when(this.playController.isTicTacToe()).thenReturn(true);
            when(this.playController.getToken()).thenReturn(Token.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.playView.interact();
            verify(this.playController).put(new Coordinate(0, 0));
            verify(this.console).writeln(Message.PLAYER_WIN.getMessage());
        }
    }

    @Test
    void testGivenNewPlayViewWhenMachinePlayerPutCoordinateThenGamePutCoordinate() {
        try (MockedStatic console = mockStatic(Console.class)) {
            Coordinate coordinate = new Coordinate(0, 0);
            when(this.playController.isBoardComplete()).thenReturn(false);
            when(this.playController.isUser()).thenReturn(false);
            when(this.playView.createRandomCoordinate()).thenReturn(coordinate);
            when(this.playController.put(any(Coordinate.class))).thenReturn(Error.NULL);
            when(this.playController.getToken(any(Coordinate.class))).thenReturn(Token.X);
            when(this.playController.isTicTacToe()).thenReturn(true);
            when(this.playController.getToken()).thenReturn(Token.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.playView.interact();
            verify(this.playController).put(coordinate);
            verify(this.console).writeln(Message.PLAYER_WIN.toString());
        }
    }

    @Test
    void testGivenNewPlayViewWhenUserPlayerMoveOriginToTargetThenGameMoveOriginToTarget() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.playController.isBoardComplete()).thenReturn(true);
            when(this.playController.isUser()).thenReturn(true);
            when(this.console.readInt(anyString())).thenReturn(1, 1, 2, 2);
            when(this.playController.move(any(Coordinate.class), any(Coordinate.class))).thenReturn(Error.NULL);
            when(this.playController.getToken(any(Coordinate.class))).thenReturn(Token.X);
            when(this.playController.isTicTacToe()).thenReturn(true);
            when(this.playController.getToken()).thenReturn(Token.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.playView.interact();
            verify(this.playController).move(new Coordinate(0, 0), new Coordinate(1, 1));
            verify(this.console).writeln(Message.PLAYER_WIN.toString());
        }
    }

    @Test
    void testGivenNewPlayViewWhenMachinePlayerMoveOriginToTargetThenGameMoveOriginToTarget() {
        try (MockedStatic console = mockStatic(Console.class)) {
            Coordinate origin = new Coordinate(0, 0);
            Coordinate target = new Coordinate(0, 0);
            when(this.playController.isBoardComplete()).thenReturn(true);
            when(this.playController.isUser()).thenReturn(false);
            when(this.playView.createRandomCoordinate()).thenReturn(origin, target);
            when(this.playController.move(any(Coordinate.class), any(Coordinate.class))).thenReturn(Error.NULL);
            when(this.playController.getToken(any(Coordinate.class))).thenReturn(Token.X);
            when(this.playController.isTicTacToe()).thenReturn(true);
            when(this.playController.getToken()).thenReturn(Token.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.playView.interact();
            verify(this.playController).move(origin, target);
            verify(this.console).writeln(Message.PLAYER_WIN.toString());
        }
    }

}
