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
    void testGivenNewBoardWhenCopyBoardThenIsSameBoard() {
        assertThat(this.board.copy(), is(this.board));
    }

    @Test
    void testGivenNewBoardAndCopyBoardWhenEqualsThenIsTrue() {
        assertThat(this.board.equals(this.board.copy()), is(true));
    }

}
