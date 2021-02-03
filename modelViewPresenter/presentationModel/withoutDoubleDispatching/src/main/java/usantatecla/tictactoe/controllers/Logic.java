package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.State;
import usantatecla.tictactoe.models.StateValue;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Error;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    private Game game;
    private final State state;
    private final Map<StateValue, Controller> controllers;

    public Logic() {
        this.state = new State();
        this.game = new Game();
        this.controllers = new HashMap<StateValue, Controller>();
        this.controllers.put(StateValue.INITIAL, new StartController(this.game, this.state));
        this.controllers.put(StateValue.IN_GAME, new PlayController(this.game, this.state));
        this.controllers.put(StateValue.RESUME, new ResumeController(this.game, this.state));
        this.controllers.put(StateValue.EXIT, null);
    }

    public Controller getController() {
        return this.controllers.get(this.state.getValueState());
    }

}
