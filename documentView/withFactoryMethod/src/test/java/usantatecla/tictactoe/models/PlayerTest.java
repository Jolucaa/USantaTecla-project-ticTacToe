package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void testGivenNewPlayerWhenCopyPlayerThenIsSamePlayer() {
        assertThat(this.player.copy(this.board), is(this.player));
    }

    @Test
    void testGivenNewPlayerAndCopyPlayerWhenEqualsThenIsTrue() {
        assertThat(this.player.equals(this.player.copy(this.board)), is(true));
    }

}
