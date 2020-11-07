package usantatecla.tictactoe;

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
    public void testGivenNewBoardWhenStartThenIsEmpty() {
        assertThat(this.board.isEmpty(new Coordinate(0, 0)),is(true));
        assertThat(this.board.isEmpty(new Coordinate(2, 2)),is(true));
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenIsOccupiedThenIsFalse() {
        assertThat(this.board.isOccupied(new Coordinate(0, 0), Token.X), is(false));
        assertThat(this.board.isOccupied(new Coordinate(0, 0), Token.O), is(false));
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenIsOccupiedThenIsTrue() {
        Token token = Token.O;
        Coordinate coordinate = new Coordinate(0, 2);
        this.board.put(coordinate, token);
        assertThat(this.board.isOccupied(coordinate, token), is(true));
    }

    @Test
    public void testGivenNewBoardWhenMoveNewTokenIsOccupiedAndOriginIsEmptyThenIsTrue() {
        Token token = Token.O;
        Coordinate origin = new Coordinate(0, 0);
        this.board.put(origin, token);
        Coordinate target = new Coordinate(0, 1);
        this.board.move(origin, target);
        assertThat(this.board.isEmpty(origin), is(true));
        assertThat(this.board.isOccupied(target, token), is(true));
    }

    @Test
    public void testGivenNewBoardWhenNotPutTokensAndIsTicTacToeThenIsFalse() {
        assertThat(this.board.isTicTacToe(Token.O), is(false));
    }

    @Test
    public void testGivenNewBoardWhenPutThreeTokenAndIsTicTacToeThenIsTrue() {
        Token token = Token.O;
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            this.board.put(new Coordinate(i, 2), token);
        }
        assertThat(this.board.isTicTacToe(token), is(true));
    }

    @Test
    public void testGivenNewBoardWhenPutTwoTokenAndIsTicTacToeThenIsFalse() {
        Token token = Token.O;
        for (int i = 0; i < Coordinate.DIMENSION - 1; i++) {
            this.board.put(new Coordinate(i, 2), token);
        }
        assertThat(this.board.isTicTacToe(token), is(false));
    }

    @Test
    public void testGivenNewBoardWhenPutThreeTokenWithBadDirectionAndIsTicTacToeThenIsFalse() {
        Token token = Token.O;
        for (int i = 0; i < Coordinate.DIMENSION - 1; i++) {
            this.board.put(new Coordinate(i, 2), token);
        }
        this.board.put(new Coordinate(0, 1), token);
        assertThat(this.board.isTicTacToe(token), is(false));
    }

    /*@Test
    public void testGivenNewBoardWhenPutThreeTokenWithBadDirectionAndIsTicTacToeThenIsFalseDirectionNull() {
        Token token = Token.O;

        this.board.put(new Coordinate(), token);
        this.board.put(new Coordinate(), token);
        this.board.put(new Coordinate(), token);
        assertThat(this.board.isTicTacToe(token), is(false));
    }*/

    @Test
    public void testGivenNewBoardWhenPutSixTokensAndIsCompletedThenIsTrue() {
        Token tokenX = Token.values()[0];
        Token tokenO = Token.values()[1];
        Coordinate coordinate11 = new Coordinate(0, 0);
        Coordinate coordinate21 = new Coordinate(1, 0);
        Coordinate coordinate12 = new Coordinate(0, 1);
        Coordinate coordinate22 = new Coordinate(1, 1);
        Coordinate coordinate23 = new Coordinate(1, 2);
        Coordinate coordinate33 = new Coordinate(2, 2);
        this.board.put(coordinate11, tokenX);
        this.board.put(coordinate21, tokenO);
        this.board.put(coordinate12, tokenX);
        this.board.put(coordinate22, tokenO);
        this.board.put(coordinate23, tokenX);
        this.board.put(coordinate33, tokenO);
        assertThat(this.board.isCompleted(), is(true));
    }

    @Test
    public void testGivenNewBoardWhenPutFiveTokensAndIsCompletedThenIsFalse() {
        Token tokenX = Token.values()[0];
        Token tokenO = Token.values()[1];
        Coordinate coordinate11 = new Coordinate(0, 0);
        Coordinate coordinate21 = new Coordinate(1, 0);
        Coordinate coordinate12 = new Coordinate(0, 1);
        Coordinate coordinate22 = new Coordinate(1, 1);
        Coordinate coordinate23 = new Coordinate(1, 2);
        this.board.put(coordinate11, tokenX);
        this.board.put(coordinate21, tokenO);
        this.board.put(coordinate12, tokenX);
        this.board.put(coordinate22, tokenO);
        this.board.put(coordinate23, tokenX);
        assertThat(this.board.isCompleted(), is(false));
    }

    @Test
    public void testGivenNewBoardWhenNotPutTokensAndIsCompletedThenIsFalse() {
        assertThat(this.board.isCompleted(), is(false));
    }
}
