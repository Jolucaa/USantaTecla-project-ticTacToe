package usantatecla.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MachinePlayerTest {
    private MachinePlayer machinePlayer;

    public MachinePlayerTest() {
        this.machinePlayer = new MachinePlayer(Token.X, new Board());
    }

    @Test
    public void testGivenNewMachinePlayerCreateCoordinate() {
        assertEquals(new Coordinate().getClass(), machinePlayer.getCoordinate(Message.VERTICAL_LINE_CENTERED).getClass());
    }
}
