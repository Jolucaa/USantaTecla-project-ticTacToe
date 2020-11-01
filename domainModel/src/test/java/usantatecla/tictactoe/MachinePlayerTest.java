package usantatecla.tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MachinePlayerTest {
    private MachinePlayer machinePlayer;

    public MachinePlayerTest() {
        this.machinePlayer = new MachinePlayer(Token.X,new Board());
    }

    @Test
    public void testGivenNewMachinePlayerCreateCoordinate() {
        assertEquals(new Coordinate().getClass(), machinePlayer.getCoordinate(Message.VERTICAL_LINE_CENTERED).getClass());
    }
}
