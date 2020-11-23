package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TurnTest {

    private Turn turn;
    private Board board;

    @BeforeEach
    void before() {
        this.board = new Board();
        this.turn = new Turn(this.board);
        this.turn.setUsers(0);
    }

    @Test
    void testGivenNewTurnWhenCopyTurnThenIsSameTurn() {
        assertThat(this.turn.copy(this.board), is(this.turn));
    }

    @Test
    void testGivenNewTurnAndCopyTurnWhenEqualsThenIsTrue() {
        assertThat(this.turn.equals(this.turn.copy(this.board)), is(true));
    }

}
