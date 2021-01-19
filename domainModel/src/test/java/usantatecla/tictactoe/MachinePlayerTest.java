package usantatecla.tictactoe;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;

public class MachinePlayerTest extends PlayerTest {

    //TODO Mock para el random

    @Override
    public PlayerBuilder getPlayerBuilder() {
        return new PlayerBuilder().color(Color.O).machine();
    }

    @Test
    public void testGivenNewMachinePlayerWhenCreateCoordinate() {
        Player player = this.getPlayerBuilder().build();
        assertThat(player.getCoordinate(any(Message.class)).getClass(), is(Coordinate.class));
    }
}
