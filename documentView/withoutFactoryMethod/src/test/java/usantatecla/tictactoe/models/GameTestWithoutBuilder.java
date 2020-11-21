package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GameTestWithoutBuilder {

    private Game game;

    @BeforeEach
    void before() {
        this.game = new Game();
        this.game.setUsers(0);
    }

    @Test
    void testGivenNewGameWhenIsBoardCompleteThenIsFalse() {
        assertThat(this.game.isBoardComplete(), is(false));
    }

    @Test
    void testGivenTwoPlayersGameWhenIsUserThenIsTrue() {
        this.game.setUsers(2);
        assertThat(this.game.isUser(), is(true));
    }

    @Test
    void testGivenNewGameWhenPutCoordinateThenIsErrorNull() {
        assertThat(this.game.put(new Coordinate(0, 0)), is(Error.NULL));
    }

    @Test
    void testGivenNewGameWhenMoveOriginToTargetThenIsErrorNotOwner() {
        assertThat(this.game.move(new Coordinate(0, 0), new Coordinate(0, 1)), is(Error.NOT_OWNER));
    }

    @Test
    void testGivenNewGameWhenIsTicTacToeThenIsFalse() {
        assertThat(this.game.isTicTacToe(), is(false));
    }

    @Test
    void testGivenNewGameWhenGetTokenThenIsXToken() {
        assertThat(this.game.getToken(), is(Token.X));
    }

    @Test
    void testGivenNewGameWhenGetTokenCoordinateThenIsNullToken() {
        assertThat(this.game.getToken(new Coordinate(0, 0)), is(Token.NULL));
    }

    @Test
    void testGivenNewGameWhenGetMaxPlayersThenIsTwo() {
        assertThat(this.game.getMaxPlayers(), is(2));
    }

    @Test
    void testGivenNewGameWhenEqualsThenIsTrue() {
        assertThat(this.game.equals(this.game), is(true));
    }

}
