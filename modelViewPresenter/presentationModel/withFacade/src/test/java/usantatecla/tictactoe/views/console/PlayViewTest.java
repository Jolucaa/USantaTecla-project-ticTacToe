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
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.Token;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class PlayViewTest {

    @Mock
    private Logic logic;

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
            when(this.logic.isBoardComplete()).thenReturn(false);
            when(this.logic.isUser()).thenReturn(true);
            when(this.console.readInt(anyString())).thenReturn(1);
            when(this.logic.isValidCoordinate(any(int[].class))).thenReturn(Error.NULL);
            when(this.logic.put(any(int[].class))).thenReturn(Error.NULL);
            when(this.logic.getToken(any(Coordinate.class))).thenReturn(Token.X);
            when(this.logic.isTicTacToe()).thenReturn(true);
            when(this.logic.getToken()).thenReturn(Token.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.playView.interact();
            verify(this.logic).put(new int[]{0, 0});
            verify(this.console).writeln(Message.PLAYER_WIN.getMessage());
        }
    }

    @Test
    void testGivenNewPlayViewWhenMachinePlayerPutCoordinateThenGamePutCoordinate() {
        try (MockedStatic console = mockStatic(Console.class)) {
            int[] coordinate = {0, 0};
            when(this.logic.isBoardComplete()).thenReturn(false);
            when(this.logic.isUser()).thenReturn(false);
            when(this.logic.getRandomCoordinate()).thenReturn(coordinate);
            when(this.logic.put(any(int[].class))).thenReturn(Error.NULL);
            when(this.logic.getToken(any(Coordinate.class))).thenReturn(Token.X);
            when(this.logic.isTicTacToe()).thenReturn(true);
            when(this.logic.getToken()).thenReturn(Token.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.playView.interact();
            verify(this.logic).put(coordinate);
            verify(this.console).writeln(Message.PLAYER_WIN.getMessage());
        }
    }

    @Test
    void testGivenNewPlayViewWhenUserPlayerMoveOriginToTargetThenGameMoveOriginToTarget() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.logic.isBoardComplete()).thenReturn(true);
            when(this.logic.isUser()).thenReturn(true);
            when(this.console.readInt(anyString())).thenReturn(1, 1, 2, 2);
            when(this.logic.isValidCoordinate(any(int[].class))).thenReturn(Error.NULL);
            when(this.logic.move(any(int[].class), any(int[].class))).thenReturn(Error.NULL);
            when(this.logic.getToken(any(Coordinate.class))).thenReturn(Token.X);
            when(this.logic.isTicTacToe()).thenReturn(true);
            when(this.logic.getToken()).thenReturn(Token.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.playView.interact();
            verify(this.logic).move(new int[]{0, 0}, new int[]{1, 1});
            verify(this.console).writeln(Message.PLAYER_WIN.getMessage());
        }
    }

    @Test
    void testGivenNewPlayViewWhenMachinePlayerMoveOriginToTargetThenGameMoveOriginToTarget() {
        try (MockedStatic console = mockStatic(Console.class)) {
            int[] origin = {0, 0};
            int[] target = {1, 1};
            when(this.logic.isBoardComplete()).thenReturn(true);
            when(this.logic.isUser()).thenReturn(false);
            when(this.logic.getRandomCoordinate()).thenReturn(origin, target);
            when(this.logic.move(any(int[].class), any(int[].class))).thenReturn(Error.NULL);
            when(this.logic.getToken(any(Coordinate.class))).thenReturn(Token.X);
            when(this.logic.isTicTacToe()).thenReturn(true);
            when(this.logic.getToken()).thenReturn(Token.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.playView.interact();
            verify(this.logic).move(origin, target);
            verify(this.console).writeln(Message.PLAYER_WIN.getMessage());
        }
    }

}
