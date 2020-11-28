package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.Error;

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
    void testGivenTwoUsersTurnWhenIsUserThenIsTrue() {
        this.turn.setUsers(2);
        assertThat(this.turn.isUser(), is(true));
    }

    @Test
    void testGivenNewTurnWhenPutCoordinateThenIsErrorNull() {
        assertThat(this.turn.put(new Coordinate(0, 0)), is(Error.NULL));
    }

    @Test
    void testGivenNewTurnWhenGetPlayerThenPlayerTokenIsX() {
        assertThat(this.turn.getToken(), is(Token.X));
    }

    @Test
    void testGivenNewTurnWhenMoveOriginToTargetThenIsErrorNotOwner() {
        assertThat(this.turn.move(new Coordinate(0, 0), new Coordinate(0, 1)), is(Error.NOT_OWNER));
    }

    @Test
    void testGivenNewTurnWhenGetTokenThenIsXToken() {
        assertThat(this.turn.getToken(), is(Token.X));
    }


}
