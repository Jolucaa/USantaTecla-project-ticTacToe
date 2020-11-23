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
    void testGivenCompleteBoardGameWhenIsBoardCompleteThenIsTrue() {
        this.game.put(new Coordinate(0, 0));
        this.game.put(new Coordinate(0, 1));
        this.game.put(new Coordinate(0, 2));
        this.game.put(new Coordinate(1, 0));
        this.game.put(new Coordinate(1, 1));
        this.game.put(new Coordinate(1, 2));
        assertThat(this.game.isBoardComplete(), is(true));
    }

    @Test
    void testGivenZeroUsersGameWhenIsUserThenIsFalse() {
        this.game.setUsers(0);
        assertThat(this.game.isUser(), is(false));
    }

    @Test
    void testGivenOneUserGameWhenIsUserThenIsTrue() {
        this.game.setUsers(1);
        assertThat(this.game.isUser(), is(true));
    }

    @Test
    void testGivenOneUserGameAndFirstPlayerPlayWhenIsUserThenIsFalse() {
        this.game.setUsers(1);
        this.game.put(new Coordinate(0, 0));
        assertThat(this.game.isUser(), is(false));
    }

    @Test
    void testGivenTwoUsersGameWhenIsUserThenIsTrue() {
        this.game.setUsers(2);
        assertThat(this.game.isUser(), is(true));
    }

    @Test
    void testGivenNewGameWhenPutCoordinateThenIsNullError() {
        assertThat(this.game.put(new Coordinate(0, 0)), is(Error.NULL));
    }

    @Test
    void testGivenGameWithXTokenInBoardWhenPutCoordinateInXTokenCoordinateThenIsNotEmptyError() {
        Coordinate coordinate = new Coordinate(0, 0);
        this.game.put(coordinate);
        assertThat(this.game.put(coordinate), is(Error.NOT_EMPTY));
    }

    @Test
    void testGivenNewGameWhenMoveOriginToTargetThenIsNotOwnerError() {
        assertThat(this.game.move(new Coordinate(0, 0), new Coordinate(0, 1)), is(Error.NOT_OWNER));
    }

    @Test
    void testGivenGameWithTokenInBoardWhenMoveNotOwnTokenThenIsNotOwnerError() {
        Coordinate origin = new Coordinate(0, 0);
        this.game.put(origin);
        assertThat(game.move(origin, new Coordinate(0, 1)), is(Error.NOT_OWNER));
    }

    @Test
    void testGivenGameWithTokenInBoardWhenMoveOwnTokenThenIsNullError() {
        Coordinate origin = new Coordinate(0, 0);
        this.game.put(origin);
        this.game.put(new Coordinate(1, 0));
        assertThat(this.game.move(origin, new Coordinate(0, 1)), is(Error.NULL));
    }

    @Test
    void testGivenGameWithTokenInBoardWhenMoveOwnTokenToOccupiedCoordinateThenIsNotEmptyError() {
        Coordinate origin = new Coordinate(0, 0);
        Coordinate target = new Coordinate(0, 1);
        this.game.put(origin);
        this.game.put(target);
        assertThat(this.game.move(origin, target), is(Error.NOT_EMPTY));
    }

    @Test
    void testGivenGameWithTokenInBoardWhenMoveOwnTokenToSameCoordinateThenIsSameCoordinateError() {
        Coordinate coordinate = new Coordinate(0, 0);
        this.game.put(coordinate);
        this.game.put(new Coordinate(1, 0));
        assertThat(this.game.move(coordinate, coordinate), is(Error.SAME_COORDINATES));
    }

    @Test
    void testGivenNewGameWhenIsTicTacToeThenIsFalse() {
        assertThat(this.game.isTicTacToe(), is(false));
    }

    @Test
    void testGivenTicTacToeGameWhenIsTicTacToeThenIsTrue() {
        this.game.put(new Coordinate(0, 0));
        this.game.put(new Coordinate(1, 0));
        this.game.put(new Coordinate(0, 1));
        this.game.put(new Coordinate(1, 1));
        this.game.put(new Coordinate(0, 2));
        assertThat(this.game.isTicTacToe(), is(true));
    }

    @Test
    void testGivenVerticalTicTacToeGameWhenIsTicTacToeThenIsTrue() {
        this.game.put(new Coordinate(0, 0));
        this.game.put(new Coordinate(0, 1));
        this.game.put(new Coordinate(1, 0));
        this.game.put(new Coordinate(1, 1));
        this.game.put(new Coordinate(2, 0));
        assertThat(this.game.isTicTacToe(), is(true));
    }

    @Test
    void testGivenDiagonalTicTacToeGameWhenIsHorizontalTicTacToeThenIsTrue() {
        this.game.put(new Coordinate(0, 0));
        this.game.put(new Coordinate(1, 0));
        this.game.put(new Coordinate(1, 1));
        this.game.put(new Coordinate(0, 1));
        this.game.put(new Coordinate(2, 2));
        assertThat(this.game.isTicTacToe(), is(true));
    }

    @Test
    void testGivenInvertedDiagonalTicTacToeGameWhenIsHorizontalTicTacToeThenIsTrue() {
        this.game.put(new Coordinate(0, 2));
        this.game.put(new Coordinate(1, 0));
        this.game.put(new Coordinate(1, 1));
        this.game.put(new Coordinate(0, 1));
        this.game.put(new Coordinate(2, 0));
        assertThat(this.game.isTicTacToe(), is(true));
    }

    @Test
    void testGivenNewGameWhenGetTokenThenIsXToken() {
        assertThat(this.game.getToken(), is(Token.X));
    }

    @Test
    void testGivenGameWithXTokenWhenGetTokenThenIsOToken() {
        this.game.put(new Coordinate(0, 0));
        assertThat(this.game.getToken(), is(Token.O));
    }

    @Test
    void testGivenNewGameWhenGetTokenCoordinateThenIsNullToken() {
        assertThat(this.game.getToken(new Coordinate(0, 0)), is(Token.NULL));
    }

    @Test
    void testGivenGameWithXTokenWhenGetTokenCoordinateThenIsXToken() {
        this.game.put(new Coordinate(0, 0));
        assertThat(this.game.getToken(new Coordinate(0, 0)), is(Token.X));
    }

    @Test
    void testGivenGameWithOTokenWhenGetTokenCoordinateThenIsOToken() {
        this.game.put(new Coordinate(0, 0));
        this.game.put(new Coordinate(0, 1));
        assertThat(this.game.getToken(new Coordinate(0, 1)), is(Token.O));
    }

    @Test
    void testGivenNewGameWhenGetMaxPlayersThenIsTwo() {
        assertThat(game.getMaxPlayers(), is(2));
    }

    @Test
    void testGivenNewGameWhenEqualsThenIsTrue() {
        this.game.setUsers(2);
        this.game.put(new Coordinate(0, 0));
        this.game.put(new Coordinate(0, 1));
        this.game.put(new Coordinate(1, 1));
        assertThat(game.equals(game), is(true));
    }

}
