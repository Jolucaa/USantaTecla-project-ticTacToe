package usantatecla.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.Console;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerTest {

    @Mock
    private Console console;

    private final Color COLOR = Color.O;
    private PlayerBuilder playerBuilder;

    @BeforeEach
    public void BeforeEach() {
        this.playerBuilder = new PlayerBuilder().color(this.COLOR);
    }

    @Test
    public void testGivenNewPlayerWhenGetCoordinateThenReturnCorrectValue() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Player player = this.playerBuilder.build();
            when(this.console.readInt(anyString())).thenReturn(2, 1);
            Coordinate coordinate = player.getCoordinate(Message.COORDINATE_TO_PUT);
            assertThat(coordinate, is(new Coordinate(1, 0)));
        }
    }

    @Test
    public void testGivenNewPlayerWhenGetCoordinateWithNullMessageThenAssertionError() {
        Player player = this.playerBuilder.build();
        Assertions.assertThrows(AssertionError.class, () -> player.getCoordinate(null));
    }

    // TODO Traer los test de otra version
    /*
    @Test
    public void testGivenNewPlayerWhenGetPutTokenErrorWithNullMessageThenAssertionError() {
        Player player = this.playerBuilder.build();
        Assertions.assertThrows(AssertionError.class, () -> player.getPutTokenError(null));
    }

    @Test
    public void testGivenPlayerWhenGetPutTokenErrorThenErrorNULL() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = this.playerBuilder.build();
        assertThat(player.getPutTokenError(coordinate), is(Error.NULL));
    }

    @Test
    public void testGivenPlayerWhenGetPutTokenErrorThenErrorNotEmpty() {
        Player player = this.playerBuilder.rows(
                "   ",
                " O ",
                "   "
        ).build();
        assertThat(player.getPutTokenError(new Coordinate(1, 1)), is(Error.NOT_EMPTY));
    }


    @Test
    public void testGivenNewPlayerWhenGetOriginMoveTokenErrorWithNullMessageThenAssertionError() {
        Player player = this.playerBuilder.build();
        Assertions.assertThrows(AssertionError.class, () -> player.getOriginMoveTokenError(new Coordinate()));
    }

    @Test
    public void testGivenPlayerWhenGetOriginMoveTokenErrorThenErrorNotOwner() {
        Player player = this.playerBuilder.rows(
                "   ",
                " X ",
                "   "
        ).build();
        assertThat(player.getOriginMoveTokenError(new Coordinate(1, 1)), is(Error.NOT_OWNER));
    }

    @Test
    public void testGivenNewPlayerWhenGetTargetMoveTokenErrorWithNullMessageThenAssertionError() {
        Player player = this.playerBuilder.build();
        Assertions.assertThrows(AssertionError.class, () -> player.getTargetMoveTokenError(new Coordinate(), new Coordinate()));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenNoError() {
        Player player = this.playerBuilder.rows(
                "   ",
                " O ",
                "   "
        ).build();
        assertThat(player.getTargetMoveTokenError(new Coordinate(1, 1), new Coordinate(0, 0)), is(Error.NULL));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenErrorNotEmpty() {
        Player player = this.playerBuilder.rows(
                "   ",
                " OO",
                "   "
        ).build();
        assertThat(player.getTargetMoveTokenError(new Coordinate(1, 1), new Coordinate(1, 2)), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenErrorSameCoordinates() {
        Player player = this.playerBuilder.rows(
                "   ",
                " O ",
                "   "
        ).build();
        assertThat(player.getTargetMoveTokenError(new Coordinate(1, 1), new Coordinate(1, 1)), is(Error.SAME_COORDINATES));
    }
     */

    @Test
    public void testGivenPlayerWhenWriteWinnerThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Player player = this.playerBuilder.build();
            player.writeWinner();
            verify(this.console).writeln(Color.O.toString() + " player: You win!!! :-)");
        }
    }

    @Test
    public void testGivenNewPlayerWhenGetColorThenReturnColor() {
        Player player = this.playerBuilder.build();
        assertThat(player.getColor(), is(Color.O));
    }

}
