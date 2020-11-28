package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.Error;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PlayerTest {

    private Player player;
    private Board board;

    @BeforeEach
    void before() {
        this.board = new Board();
        this.player = new Player(Token.X, this.board);
    }

    @Test
    void testGivenNewPlayerAndNewBoardWhenPutCoordinateThenIsErrorNull() {
        assertThat(this.player.put(new Coordinate(0, 0)), is(Error.NULL));
    }

    @Test
    void testGivenNewPlayerAndBoardWithXTokenInCoordinateWhenPutCoordinateThenIsErrorNotEmpty() {
        Coordinate coordinate = new Coordinate(0, 0);
        this.board.put(coordinate, Token.X);
        assertThat(this.player.put(coordinate), is(Error.NOT_EMPTY));
    }

    @Test
    void testGivenNewPlayerAndNewBoardWhenMoveOriginToTargetThenIsErrorNotOwner() {
        assertThat(this.player.move(new Coordinate(0, 0), new Coordinate(0, 1)), is(Error.NOT_OWNER));
    }

    @Test
    void testGivenNewPlayerAndBoardWithXOriginWhenMoveOriginToOriginThenIsErrorSameCoordinates() {
        Coordinate origin = new Coordinate(0, 0);
        this.board.put(origin, Token.X);
        assertThat(this.player.move(origin, origin), is(Error.SAME_COORDINATES));
    }

    @Test
    void testGivenNewPlayerAndBoardWithXOriginXTargetWhenMoveOriginToTargetThenIsErrorNotEmpty() {
        Coordinate origin = new Coordinate(0, 0);
        Coordinate target = new Coordinate(0, 1);
        this.board.put(origin, Token.X);
        this.board.put(target, Token.X);
        assertThat(this.player.move(origin, target), is(Error.NOT_EMPTY));
    }

    @Test
    void testGivenNewPlayerAndBoardWithXOriginWhenMoveOriginToTargetThenIsErrorNull() {
        Coordinate origin = new Coordinate(0, 0);
        this.board.put(origin, Token.X);
        assertThat(this.player.move(origin, new Coordinate(0, 1)), is(Error.NULL));
    }

    @Test
    void testGivenXTokenPlayerWhenGetTokenThenIsXToken() {
        assertThat(this.player.getToken(), is(Token.X));
    }

}
