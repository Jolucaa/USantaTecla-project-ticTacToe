package usantatecla.tictactoe.models;

import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.Error;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GameTest {

    @Test
    void testGivenNewGameWhenIsBoardCompleteThenIsFalse() {
        Game game = new GameBuilder().build();
        assertThat(game.isBoardComplete(), is(false));
    }

    @Test
    void testGivenCompleteBoardGameWhenIsBoardCompleteThenIsTrue() {
        Game game = new GameBuilder().rows("XXX",
                                           "OOO",
                                           "   ").build();
        assertThat(game.isBoardComplete(), is(true));
    }

    @Test
    void testGivenZeroUsersGameWhenIsUserThenIsFalse() {
        Game game = new GameBuilder().users(0).build();
        assertThat(game.isUser(), is(false));
    }

    @Test
    void testGivenOneUserGameWhenIsUserThenIsTrue() {
        Game game = new GameBuilder().users(1).build();
        assertThat(game.isUser(), is(true));
    }

    @Test
    void testGivenOneUserGameAndFirstPlayerPlayWhenIsUserThenIsFalse() {
        Game game = new GameBuilder().users(1).rows("X  ",
                                                    "   ",
                                                    "   ").build();
        assertThat(game.isUser(), is(false));
    }

    @Test
    void testGivenTwoUsersGameWhenIsUserThenIsTrue() {
        Game game = new GameBuilder().users(2).build();
        assertThat(game.isUser(), is(true));
    }

    @Test
    void testGivenNewGameWhenPutCoordinateThenIsNullError() {
        Game game = new GameBuilder().build();
        assertThat(game.put(new Coordinate(0, 0)), is(Error.NULL));
    }

    @Test
    void testGivenGameWithXTokenInBoardWhenPutCoordinateInXTokenCoordinateThenIsNotEmptyError() {
        Game game = new GameBuilder().rows("X  ",
                                           "   ",
                                           "   ").build();
        assertThat(game.put(new Coordinate(0, 0)), is(Error.NOT_EMPTY));
    }

    @Test
    void testGivenNewGameWhenMoveOriginToTargetThenIsNotOwnerError() {
        Game game = new GameBuilder().build();
        assertThat(game.move(new Coordinate(0, 0), new Coordinate(0, 1)), is(Error.NOT_OWNER));
    }

    @Test
    void testGivenGameWithTokenInBoardWhenMoveNotOwnTokenThenIsNotOwnerError() {
        Game game = new GameBuilder().rows("X  ",
                                           "   ",
                                           "   ").build();
        assertThat(game.move(new Coordinate(0, 0), new Coordinate(0, 1)), is(Error.NOT_OWNER));
    }

    @Test
    void testGivenGameWithTokenInBoardWhenMoveOwnTokenThenIsNullError() {
        Game game = new GameBuilder().rows("X  ",
                                           "O  ",
                                           "   ").build();
        assertThat(game.move(new Coordinate(0, 0), new Coordinate(0, 1)), is(Error.NULL));
    }

    @Test
    void testGivenGameWithTokenInBoardWhenMoveOwnTokenToOccupiedCoordinateThenIsNotEmptyError() {
        Game game = new GameBuilder().rows("XO ",
                                           "   ",
                                           "   ").build();
        assertThat(game.move(new Coordinate(0, 0), new Coordinate(0, 1)), is(Error.NOT_EMPTY));
    }

    @Test
    void testGivenGameWithTokenInBoardWhenMoveOwnTokenToSameCoordinateThenIsSameCoordinateError() {
        Game game = new GameBuilder().rows("XO ",
                                           "   ",
                                           "   ").build();
        Coordinate coordinate = new Coordinate(0, 0);
        assertThat(game.move(coordinate, coordinate), is(Error.SAME_COORDINATES));
    }

    @Test
    void testGivenNewGameWhenIsTicTacToeThenIsFalse() {
        Game game = new GameBuilder().build();
        assertThat(game.isTicTacToe(), is(false));
    }

    @Test
    void testGivenHorizontalTicTacToeGameWhenIsTicTacToeThenIsTrue() {
        Game game = new GameBuilder().rows("XXX",
                                           "OO ",
                                           "   ").build();
        assertThat(game.isTicTacToe(), is(true));
    }

    @Test
    void testGivenVerticalTicTacToeGameWhenIsTicTacToeThenIsTrue() {
        Game game = new GameBuilder().rows("XOO",
                                           "X  ",
                                           "X  ").build();
        assertThat(game.isTicTacToe(), is(true));
    }

    @Test
    void testGivenDiagonalTicTacToeGameWhenIsHorizontalTicTacToeThenIsTrue() {
        Game game = new GameBuilder().rows("XO ",
                                           "OX ",
                                           "  X").build();
        assertThat(game.isTicTacToe(), is(true));
    }

    @Test
    void testGivenInvertedDiagonalTicTacToeGameWhenIsHorizontalTicTacToeThenIsTrue() {
        Game game = new GameBuilder().rows(" OX",
                                           " XO",
                                           "X  ").build();
        assertThat(game.isTicTacToe(), is(true));
    }

    @Test
    void testGivenNewGameWhenGetTokenThenIsXToken() {
        Game game = new GameBuilder().build();
        assertThat(game.getToken(), is(Token.X));
    }

    @Test
    void testGivenGameWithXTokenWhenGetTokenThenIsOToken() {
        Game game = new GameBuilder().rows("X  ",
                                           "   ",
                                           "   ").build();
        assertThat(game.getToken(), is(Token.O));
    }

    @Test
    void testGivenNewGameWhenGetTokenCoordinateThenIsNullToken() {
        Game game = new GameBuilder().build();
        assertThat(game.getToken(new Coordinate(0, 0)), is(Token.NULL));
    }

    @Test
    void testGivenGameWithXTokenWhenGetTokenCoordinateThenIsXToken() {
        Game game = new GameBuilder().rows("X  ",
                                           "   ",
                                           "   ").build();
        assertThat(game.getToken(new Coordinate(0, 0)), is(Token.X));
    }

    @Test
    void testGivenGameWithOTokenWhenGetTokenCoordinateThenIsOToken() {
        Game game = new GameBuilder().rows("X O",
                                           "X O",
                                           "   ").build();
        System.out.println(game.getToken(new Coordinate(0,0)));
        System.out.println(game.getToken(new Coordinate(1,2)));
        assertThat(game.getToken(new Coordinate(1, 2)), is(Token.O));
    }

    @Test
    void testGivenNewGameWhenGetMaxPlayersThenIsTwo() {
        Game game = new GameBuilder().build();
        assertThat(game.getMaxPlayers(), is(2));
    }

    @Test
    void testGivenNewGameWhenEqualsThenIsTrue() {
        Game game = new GameBuilder().users(2).rows("XO ",
                                                    " X ",
                                                    "   ").build();
        assertThat(game.equals(game), is(true));
    }

}
