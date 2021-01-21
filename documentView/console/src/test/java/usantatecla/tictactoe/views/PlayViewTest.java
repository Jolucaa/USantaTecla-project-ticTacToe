package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.utils.views.Console;
import usantatecla.tictactoe.types.Error;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class PlayViewTest {

    @Mock
    private Game game;

    @InjectMocks
    private PlayView playView;

    @Mock
    private Console console;

    @Captor
    private ArgumentCaptor<String> captor;

    @BeforeEach
    void before() {
        openMocks(this);
        this.playView = spy(this.playView);
    }

    @Test
    void testGivenNewPlayViewWhenUserPlayerPutCoordinateThenGamePutCoordinate() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.game.areAllTokensOnBoard()).thenReturn(false);
            when(this.game.getType()).thenReturn(PlayerType.USER);
            when(this.console.readInt(anyString())).thenReturn(1);
            when(this.game.getPutTokenError(any(Coordinate.class))).thenReturn(Error.NULL);
            when(this.game.getColor(any(Coordinate.class))).thenReturn(Color.X);
            when(this.game.isTicTacToe()).thenReturn(true);
            when(this.game.getActiveColor()).thenReturn(Color.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.playView.interact();
            verify(this.game).putToken(new Coordinate(0, 0));
            verify(this.console, times(4)).writeln(captor.capture());
            assertThat(captor.getValue(), is("X player: You win!!! :-)"));
        }
    }

    /*@Test
    void testGivenNewPlayViewWhenMachinePlayerPutCoordinateThenGamePutCoordinate() {
        try (MockedStatic console = mockStatic(Console.class)) {
            Coordinate coordinate = new Coordinate(0, 0);
            when(this.game.isBoardComplete()).thenReturn(false);
            when(this.game.isUser()).thenReturn(false);
            when(this.playView.createRandomCoordinate()).thenReturn(coordinate);
            when(this.game.put(any(Coordinate.class))).thenReturn(Error.NULL);
            when(this.game.getToken(any(Coordinate.class))).thenReturn(Token.X);
            when(this.game.isTicTacToe()).thenReturn(true);
            when(this.game.getToken()).thenReturn(Token.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.playView.interact();
            verify(this.game).put(coordinate);
            verify(this.console).writeln(Message.PLAYER_WIN.getMessage());
        }
    }

    @Test
    void testGivenNewPlayViewWhenUserPlayerMoveOriginToTargetThenGameMoveOriginToTarget() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.game.isBoardComplete()).thenReturn(true);
            when(this.game.isUser()).thenReturn(true);
            when(this.console.readInt(anyString())).thenReturn(1, 1, 2, 2);
            when(this.game.move(any(Coordinate.class), any(Coordinate.class))).thenReturn(Error.NULL);
            when(this.game.getToken(any(Coordinate.class))).thenReturn(Token.X);
            when(this.game.isTicTacToe()).thenReturn(true);
            when(this.game.getToken()).thenReturn(Token.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.playView.interact();
            verify(this.game).move(new Coordinate(0, 0), new Coordinate(1, 1));
            verify(this.console).writeln(Message.PLAYER_WIN.getMessage());
        }
    }

    @Test
    void testGivenNewPlayViewWhenMachinePlayerMoveOriginToTargetThenGameMoveOriginToTarget() {
        try (MockedStatic console = mockStatic(Console.class)) {
            Coordinate origin = new Coordinate(0, 0);
            Coordinate target = new Coordinate(0, 0);
            when(this.game.isBoardComplete()).thenReturn(true);
            when(this.game.isUser()).thenReturn(false);
            when(this.playView.createRandomCoordinate()).thenReturn(origin, target);
            when(this.game.move(any(Coordinate.class), any(Coordinate.class))).thenReturn(Error.NULL);
            when(this.game.getToken(any(Coordinate.class))).thenReturn(Token.X);
            when(this.game.isTicTacToe()).thenReturn(true);
            when(this.game.getToken()).thenReturn(Token.X);
            console.when(Console::getInstance).thenReturn(this.console);
            this.playView.interact();
            verify(this.game).move(origin, target);
            verify(this.console).writeln(Message.PLAYER_WIN.getMessage());
        }
    }*/

    /*@Test
    public void testGivenNewTurnWhenWriteWinnerThenCorrectMessage(){
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.turn.writeWinner();
            verify(this.console).writeln("X player: You win!!! :-)");
        }
    }

    @Test
    public void testGivenTurnWhenPlayAndWriteWinnerThenCorrectMessage(){
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.turn.play();
            this.turn.writeWinner();
            verify(this.console).writeln("O player: You win!!! :-)");
        }
    }*/

}
