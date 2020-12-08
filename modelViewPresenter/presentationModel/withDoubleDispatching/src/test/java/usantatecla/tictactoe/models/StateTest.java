package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StateTest {

    private State state;

    @BeforeEach
    void before() {
        this.state = new State();
    }

    @Test
    void testGivenNewStateWhenResetThenStateValueIsInitial() {
        this.state.reset();
        assertThat(this.state.getValueState(), is(StateValue.INITIAL));
    }

    @Test
    void testGivenNewStateWhenNextThenStateValueIsInGame() {
        this.state.next();
        assertThat(this.state.getValueState(), is(StateValue.IN_GAME));
    }

    @Test
    void testGivenInGameStateWhenNextThenStateValueIsResume() {
        this.state.next();
        this.state.next();
        assertThat(this.state.getValueState(), is(StateValue.RESUME));
    }

    @Test
    void testGivenResumeStateWhenNextThenStateValueIsExit() {
        this.state.next();
        this.state.next();
        this.state.next();
        assertThat(this.state.getValueState(), is(StateValue.EXIT));
    }

}
