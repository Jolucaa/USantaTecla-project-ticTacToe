package usantatecla.tictactoe.views;

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
import usantatecla.tictactoe.types.Token;
import usantatecla.utils.Console;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class PlayCommandTest {

    @Mock
    private PlayController playController;

    @InjectMocks
    private PlayCommand playCommand;

    @Mock
    private Console console;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    void testGivenNewPlayViewWhenUserPlayerPutCoordinateThenGamePutCoordinate() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.playController.isBoardComplete()).thenReturn(false);
            when(this.console.readInt(anyString())).thenReturn(1);
            when(this.playController.isValidCoordinate(any(Coordinate.class))).thenReturn(Error.NULL);
            when(this.playController.put(any(Coordinate.class))).thenReturn(Error.NULL);
            when(this.playController.isTicTacToe()).thenReturn(true);
            when(this.playController.getToken()).thenReturn(Token.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.playCommand.execute();
            verify(this.playController).put(new Coordinate(0, 0));
            verify(this.console).writeln(Message.PLAYER_WIN.getMessage());
        }
    }

    @Test
    void testGivenNewPlayViewWhenUserPlayerMoveOriginToTargetThenGameMoveOriginToTarget() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.playController.isBoardComplete()).thenReturn(true);
            when(this.console.readInt(anyString())).thenReturn(1, 1, 2, 2);
            when(this.playController.isValidCoordinate(any(Coordinate.class))).thenReturn(Error.NULL);
            when(this.playController.move(any(Coordinate.class), any(Coordinate.class))).thenReturn(Error.NULL);
            when(this.playController.isTicTacToe()).thenReturn(true);
            when(this.playController.getToken()).thenReturn(Token.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.playCommand.execute();
            verify(this.playController).move(new Coordinate(0, 0), new Coordinate(1, 1));
            verify(this.console).writeln(Message.PLAYER_WIN.getMessage());
        }
    }

}
