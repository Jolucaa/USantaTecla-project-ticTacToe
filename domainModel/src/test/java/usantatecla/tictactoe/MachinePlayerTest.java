package usantatecla.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MachinePlayerTest {
    private MachinePlayer machinePlayer;

    @BeforeEach
    void before() {
        this.machinePlayer = new MachinePlayer(Token.X, new Board());
    }

    @Test
    public void testGivenNewMachinePlayerWhenCreateCoordinate() {
        assertThat(machinePlayer.getCoordinate(Message.VERTICAL_LINE_CENTERED).getClass(), is(new Coordinate().getClass()));
    }
}
