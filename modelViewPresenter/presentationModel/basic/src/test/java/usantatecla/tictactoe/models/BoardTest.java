package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardTest {

    private Board board;

    @BeforeEach
    void before() {
        this.board = new Board();
    }

    @Test
    void testGivenNewBoardWhenGetCoordinateTokenThenIsNullToken() {
        assertThat(this.board.getToken(new Coordinate(0, 0)), is(Token.NULL));
    }

    @Test
    void testGivenNewBoardWhenPutXTokenInCoordinateThenCoordinateTokenIsXToken() {
        Coordinate coordinate = new Coordinate(0, 0);
        this.board.put(coordinate, Token.X);
        assertThat(this.board.getToken(coordinate), is(Token.X));
    }

    @Test
    void testGivenBoardWithXTokenInOriginWhenMoveOriginToTargetThenOriginTokenIsNullTokenAndTargetTokenIsXToken() {
        Coordinate origin = new Coordinate(0, 0);
        Coordinate target = new Coordinate(0, 1);
        this.board.put(origin, Token.X);
        this.board.move(origin, target);
        assertThat(this.board.getToken(origin), is(Token.NULL));
        assertThat(this.board.getToken(target), is(Token.X));
    }

    @Test
    void testGivenNewBoardWhenIsCompletedThenIsFalse() {
        assertThat(this.board.isCompleted(), is(false));
    }

    @Test
    void testGivenCompletedBoardWhenIsCompletedThenIsTrue() {
        this.board.put(new Coordinate(0, 0), Token.X);
        this.board.put(new Coordinate(0, 1), Token.X);
        this.board.put(new Coordinate(0, 2), Token.X);
        this.board.put(new Coordinate(1, 0), Token.O);
        this.board.put(new Coordinate(1, 1), Token.O);
        this.board.put(new Coordinate(1, 2), Token.O);
        assertThat(this.board.isCompleted(), is(true));
    }

    @Test
    void testGivenBoardWithXTokenInCoordinateWhenCoordinateIsOccupiedByXTokenThenIsTrue() {
        Coordinate coordinate = new Coordinate(0, 0);
        this.board.put(coordinate, Token.X);
        assertThat(this.board.isOccupied(coordinate, Token.X), is(true));
    }

    @Test
    void testGivenBoardWithXTokenInCoordinateWhenCoordinateIsEmptyThenIsFalse() {
        Coordinate coordinate = new Coordinate(0, 0);
        this.board.put(coordinate, Token.X);
        assertThat(this.board.isEmpty(coordinate), is(false));
    }

    @Test
    void testGivenNewBoardWhenXTokenIsTicTacToeThenIsFalse() {
        assertThat(this.board.isTicTacToe(Token.X), is(false));
    }

    @Test
    void testGivenBoardWithThreeXTokensNotAlignedWhenXTokenIsTicTacToeThenIsFalse() {
        this.board.put(new Coordinate(0, 0), Token.X);
        this.board.put(new Coordinate(0, 1), Token.X);
        this.board.put(new Coordinate(1, 0), Token.X);
        assertThat(this.board.isTicTacToe(Token.X), is(false));
    }

    @Test
    void testGivenBoardWithThreeXTokensAlignedWhenXTokenIsTicTacToeThenIsTrue() {
        this.board.put(new Coordinate(0, 0), Token.X);
        this.board.put(new Coordinate(0, 1), Token.X);
        this.board.put(new Coordinate(0, 2), Token.X);
        assertThat(this.board.isTicTacToe(Token.X), is(true));
    }

}
