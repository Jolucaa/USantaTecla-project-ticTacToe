package usantatecla.tictactoe;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.Console;
import usantatecla.utils.SquaredBoundedCoordinate;
import usantatecla.utils.SquaredBoundedCoordinateTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserPlayerTest {
    /*
    private UserPlayer player;
    private Coordinate coordinate00;
    private Coordinate coordinate01;*/
    private Color color;

    @Mock
    Console console;

    public UserPlayerTest() {
        this.color = Color.X;
        /*this.board = new Board();
        this.player = new UserPlayer(Color.O, this.board);
        this.coordinate00 = new Coordinate(0, 0);
        this.coordinate01 = new Coordinate(0, 1);*/
    }

    /*@Test
    public void testGivenNewUserPlayerWhenPutNewTokenThenReturnErrorNotEmpty() {
        this.board.put(this.coordinate00, Color.O);
        assertThat(this.player.getPutTokenError(this.coordinate00), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenNewUserPlayerWhenPutNewTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Color.O);
        assertThat(this.player.getPutTokenError(new Coordinate(0, 2)) == Error.NULL, is(true));
    }

    @Test
    public void testGivenNewUserPlayerWhenRemoveTokenThenReturnErrorNotOwner() {
        this.board.put(this.coordinate00, Color.O);
        assertThat(this.player.getOriginMoveTokenError(this.coordinate01), is(Error.NOT_OWNER));
    }

    @Test
    public void testGivenNewUserPlayerWhenRemoveTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Color.O);
        assertThat(this.player.getOriginMoveTokenError(this.coordinate00) == Error.NULL, is(true));
    }

    @Test
    public void testGivenNewUserPlayerWhenMoveTokenThenReturnErrorSameCoordinates() {
        this.board.put(this.coordinate00, Color.O);
        assertThat(this.player.getTargetMoveTokenError(this.coordinate00, this.coordinate00), is(Error.SAME_COORDINATES));
    }

    @Test
    public void testGivenNewUserPlayerWhenMoveTokenThenReturnErrorNotEmpty() {
        this.board.put(this.coordinate00, Color.O);
        this.board.put(this.coordinate01, Color.O);
        assertThat(this.player.getTargetMoveTokenError(this.coordinate00, this.coordinate01), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenNewUserPlayerWhenMoveTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Color.O);
        assertThat(this.player.getTargetMoveTokenError(this.coordinate00, this.coordinate01) == Error.NULL, is(true));
    }*/

    @Test
    public void testGivenNewMachinePlayerWhenCreateCoordinate() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Player player = new PlayerBuilder().setColor(this.color).setTypeUserPlayer().build();
            when(this.console.readInt(anyString())).thenReturn(2, 1);
            Coordinate coordinate = player.getCoordinate(Message.COORDINATE_TO_PUT);
            assertThat(coordinate.getColumn(), is(0));
            assertThat(coordinate.getRow(), is(1));
        }
    }
}
