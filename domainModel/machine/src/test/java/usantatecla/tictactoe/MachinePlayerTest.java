package usantatecla.tictactoe;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MachinePlayerTest extends PlayerTest {

    @Override
    public PlayerBuilder getPlayerBuilder() {
        return new PlayerBuilder().color(Color.O).machine();
    }

    @Test
    public void testGivenNewMachinePlayerWhenCreateCoordinate() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = this.getPlayerBuilder().build();
        when(player.getCoordinate(any(Message.class))).thenReturn(coordinate);
        assertThat(player.getCoordinate(Message.ENTER_COORDINATE_TO_PUT).equals(coordinate), is(true));
    }
}
