package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;

public class MachinePlayerTest extends PlayerTest {

    @Override
    public PlayerBuilder getPlayerBuilder() {
        return new PlayerBuilder().color(Color.O).machine();
    }

    //TODO Preguntar a Luis
}
