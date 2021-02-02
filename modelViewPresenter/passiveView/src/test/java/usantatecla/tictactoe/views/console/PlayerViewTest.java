package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.types.Color;
import usantatecla.utils.views.Console;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerViewTest {
    // TODO Hacer
    //final static Coordinate ORIGIN = new Coordinate(0, 0);
    //final static Coordinate TARGET = new Coordinate(0, 1);

    private PlayerView playerView;

    @Mock
    private Console console;

    @BeforeEach
    public void beforeEach() {
        this.playerView = new PlayerView();
    }

    @Test
    public void testGivenPlayerViewWhenWriteWinnerThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.playerView.writeWinner(Color.X);
            this.playerView.writeWinner(Color.O);
            verify(this.console).writeln("X player: You win!!! :-)");
            verify(this.console).writeln("O player: You win!!! :-)");
        }
    }

    /*
    @Test
    public void testGivenPlayerViewWhenInteractThenPutToken() {
        doReturn(PlayerViewTest.ORIGIN).when(playerView).getCoordinate(any());
        when(this.playController.areAllTokensOnBoard()).thenReturn(false);
        when(this.playController.getPutTokenError(any(Coordinate.class))).thenReturn(Error.NULL);
        this.playerView.interact();
        verify(this.playController).putToken(PlayerViewTest.ORIGIN);
    }

    @Test
    public void testGivenPlayerViewWhenInteractThenMoveToken() {
        doReturn(true).when(this.playController).areAllTokensOnBoard();
        doReturn(PlayerViewTest.ORIGIN, PlayerViewTest.TARGET).when(playerView).getCoordinate(any());
        when(this.playController.getOriginMoveTokenError(any(Coordinate.class))).thenReturn(Error.NULL);
        when(this.playController.getTargetMoveTokenError(any(Coordinate.class),any(Coordinate.class))).thenReturn(Error.NULL);
        this.playController.putToken(PlayerViewTest.ORIGIN);
        this.playerView.interact();
        verify(this.playController).moveToken(PlayerViewTest.ORIGIN, PlayerViewTest.TARGET);
    }

    @Test
    public void testGivenUserPlayerViewWhenGetCoordinateThenReturn() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(
                    PlayerViewTest.ORIGIN.getRow() + 1,
                    PlayerViewTest.ORIGIN.getColumn() + 1
            );
            assertThat(this.playerView.getCoordinate(Message.COORDINATE_TO_PUT), is(PlayerViewTest.ORIGIN));
        }
    }
    */

}
