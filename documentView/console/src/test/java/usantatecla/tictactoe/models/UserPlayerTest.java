package usantatecla.tictactoe.models;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.views.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserPlayerTest extends PlayerTest{

   /* @Mock
    Console console;

    @Override
    public PlayerBuilder getPlayerBuilder() {
        return new PlayerBuilder().setColor(Color.O).setTypeUserPlayer();
    }

    @Test
    public void testGivenNewUserPlayerWhenGetCoordinateThenReturnCorrectValue() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Player player = this.playerBuilder.build();
            when(this.console.readInt(anyString())).thenReturn(2, 1);
            Coordinate coordinate = player.getCoordinate(Message.COORDINATE_TO_PUT);
            assertThat(coordinate.getColumn(), is(0));
            assertThat(coordinate.getRow(), is(1));
        }
    }

    @Test
    public void testGivenNewUserPlayerWhenGetCoordinateWithNullMessageThenAssertionError() {
        Player player = this.playerBuilder.build();
        Assertions.assertThrows(AssertionError.class, () -> player.getCoordinate(null));
    }

    @Test
    public void testGivenNewUserPlayerWhenGetPutTokenErrorWithNullMessageThenAssertionError() {
        Player player = this.playerBuilder.build();
        Assertions.assertThrows(AssertionError.class, () -> player.getPutTokenError(null));
    }

    @Test
    public void testGivenNewUserPlayerWhenGetOriginMoveTokenErrorWithNullMessageThenAssertionError() {
        Player player = this.playerBuilder.build();
        Assertions.assertThrows(AssertionError.class, () -> player.getOriginMoveTokenError(new Coordinate()));
    }

    @Test
    public void testGivenNewUserPlayerWhenGetTargetMoveTokenErrorWithNullMessageThenAssertionError() {
        Player player = this.playerBuilder.build();
        Assertions.assertThrows(AssertionError.class, () -> player.getTargetMoveTokenError(new Coordinate(), new Coordinate()));
    }*/
}
