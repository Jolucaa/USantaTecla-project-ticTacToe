package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public abstract class PlayerTest {

    protected PlayerBuilder playerBuilder;

    @BeforeEach
    void beforeEach() {
        this.playerBuilder = this.getPlayerBuilder();
    }

    public abstract PlayerBuilder getPlayerBuilder();

    @Test
    public void testGivenPlayerWhenGetPutTokenErrorThenErrorNULL() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = this.playerBuilder.build();
        assertThat(player.getPutTokenError(coordinate), is(Error.NULL));
    }

    @Test
    public void testGivenPlayerWhenGetPutTokenErrorThenErrorNotEmpty() {
        Player player = this.playerBuilder.rows(
                "   ",
                " O ",
                "   "
        ).build();
        assertThat(player.getPutTokenError(new Coordinate(1, 1)), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenPlayerWhenGetOriginMoveTokenErrorThenErrorNotOwner() {
        Player player = this.playerBuilder.rows(
                "   ",
                " O ",
                "   "
        ).build();
        Player player2 = new PlayerBuilder().setColor(Color.X).setTypeUserPlayer().build();
        player2.board = player.board;
        assertThat(player2.getOriginMoveTokenError(new Coordinate(1, 1)), is(Error.NOT_OWNER));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenNoError() {
        Player player = this.playerBuilder.rows(
                "   ",
                " O ",
                "   "
        ).build();
        assertThat(player.getTargetMoveTokenError(new Coordinate(1, 1), new Coordinate(0,0)), is(Error.NULL));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenErrorNotEmpty() {
        Player player = this.playerBuilder.rows(
                "   ",
                " OO",
                "   "
        ).build();
        assertThat(player.getTargetMoveTokenError(new Coordinate(1, 1), new Coordinate(1,2)), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenErrorSameCoordinates() {
        Player player = this.playerBuilder.rows(
                "   ",
                " O ",
                "   "
        ).build();
        assertThat(player.getTargetMoveTokenError(new Coordinate(1, 1), new Coordinate(1, 1)), is(Error.SAME_COORDINATES));
    }

    @Test
    public void testGivenNewPlayerWhenGetTokenThenReturnTheToken() {
        Player player = this.playerBuilder.build();
        assertThat(player.getColor(), is(Color.O));
    }

    @Test
    void testGivenPlayerWhenMoveThenIsTrue() {
        Player player = this.playerBuilder.rows(
                "OO ",
                "O  ",
                "   "
        ).rows(
                "OO ",
                "   ",
                "O  "
        ).build();
        assertThat(player.board.isEmpty(new Coordinate(1,0)), is(true));
        assertThat(player.board.isOccupied(new Coordinate(2,0), Color.O), is(true));
    }
}