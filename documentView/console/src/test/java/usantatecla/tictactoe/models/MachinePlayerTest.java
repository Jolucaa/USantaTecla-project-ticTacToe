package usantatecla.tictactoe.models;

import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.views.Message;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MachinePlayerTest extends PlayerTest {
/*
    @Override
    public PlayerBuilder getPlayerBuilder() {
        return new PlayerBuilder().setColor(Color.O).setTypeMachinePlayer();
    }

    @Test
    public void testGivenNewMachinePlayerWhenCreateCoordinate() {
        Player player = this.playerBuilder.build();
        assertThat(player.getCoordinate(Message.VERTICAL_LINE).getClass(), is(Coordinate.class));
    }*/
}