package usantatecla.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MachinePlayerTest {
    private MachinePlayer machinePlayer;

    @BeforeEach
    void before() {
        this.machinePlayer = new MachinePlayer(Color.X, new Board());
    }

    @Test
    public void testGivenNewMachinePlayerWhenCreateCoordinate() {
        assertThat(machinePlayer.getCoordinate(Message.VERTICAL_LINE).getClass(), is(new Coordinate().getClass()));
    }
}
