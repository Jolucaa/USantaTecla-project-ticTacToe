package usantatecla.tictactoe;

import org.junit.jupiter.api.Assertions;
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
    // TODO Caso de prueba con isEmpty false

    @Test
    public void testGivenNewBoardWhenPutNewTokenIsOccupiedThenIsFalse() {
        assertThat(this.board.isOccupied(new Coordinate(0, 0), Color.X), is(false));
        assertThat(this.board.isOccupied(new Coordinate(0, 0), Color.O), is(false));
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenIsOccupiedThenIsTrue() {
        Color token = Color.O;
        Coordinate coordinate = new Coordinate(0, 2);
        this.board.put(coordinate, token);
        assertThat(this.board.isOccupied(coordinate, token), is(true));
    }

    @Test
    public void testGivenNewBoardWhenMoveNewTokenIsOccupiedAndOriginIsEmptyThenIsTrue() {
        Color color = Color.O;
        Coordinate origin = new Coordinate(0, 0);
        this.board.put(origin, color);
        Coordinate target = new Coordinate(0, 1);
        this.board.move(origin, target);
        assertThat(this.board.isEmpty(origin), is(true));
        assertThat(this.board.isOccupied(target, color), is(true));
    }

    // TODO Más casos con move (asserts)

    @Test
    public void testGivenNewBoardWhenIsTicTacToeThenIsFalse() {
        assertThat(this.board.isTicTacToe(Color.O), is(false));
    }

    @Test
    public void testGivenNewBoardWhenPutThreeTokenAndIsTicTacToeThenIsTrue() {
        Color token = Color.O;
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            this.board.put(new Coordinate(i, 2), token);
        }
        assertThat(this.board.isTicTacToe(token), is(true));
    }

    @Test
    public void testGivenNewBoardWhenPutTwoTokenAndIsTicTacToeThenIsFalse() {
        Color color = Color.O;
        for (int i = 0; i < Coordinate.DIMENSION - 1 ; i++) {
            this.board.put(new Coordinate(i, 2), color);
        }
        assertThat(this.board.isTicTacToe(color), is(false));
    }

    @Test
    public void testGivenNewBoardWhenPutThreeTokenWithBadDirectionAndIsTicTacToeThenIsFalse() {
        Color token = Color.O;
        for (int i = 0; i < Coordinate.DIMENSION - 1; i++) {
            this.board.put(new Coordinate(i, 2), token);
        }
        this.board.put(new Coordinate(0, 1), token);
        assertThat(this.board.isTicTacToe(token), is(false));
    }

    @Test
    public void testGivenNewBoardWhenPutSixTokensAndIsCompletedThenIsTrue() {
        this.board.put(new Coordinate(0, 0), Color.X);
        this.board.put(new Coordinate(1, 0), Color.O);
        this.board.put(new Coordinate(0, 1), Color.X);
        this.board.put(new Coordinate(1, 1), Color.O);
        this.board.put(new Coordinate(1, 2), Color.X);
        this.board.put(new Coordinate(2, 2), Color.O);
        Assertions.assertThrows(AssertionError.class, () -> this.board.put(new Coordinate(2, 0), Color.X));
    }

}
