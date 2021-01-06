package usantatecla.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PlayerTest {
    
    private Board board;
    private Player player;
    private Color color;

    @BeforeEach
    void before() {
        this.board = new Board();
        this.color = Color.O;
        this.player = new UserPlayer(this.color, this.board);
    }

    @Test
    public void testGivenPlayerWhenGetPutTokenErrorThenErrorNULL() {
        Coordinate coordinate = new Coordinate(1, 1);
        assertThat(this.player.getPutTokenError(coordinate), is(Error.NULL));
    }

    @Test
    public void testGivenPlayerWhenGetPutTokenErrorThenErrorNotEmpty() {
        Coordinate coordinate = new Coordinate(1, 1);
        this.board.put(coordinate, this.color);
        assertThat(this.player.getPutTokenError(coordinate), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenPlayerWhenGetOriginMoveTokenErrorThenErrorNotEmpty() {
        Coordinate coordinate = new Coordinate(1, 1);
        this.board.put(coordinate, this.color);
        assertThat(this.player.getOriginMoveTokenError(coordinate), is(Error.NULL));
    }

    @Test
    public void testGivenPlayerWhenGetOriginMoveTokenErrorThenErrorNotOwner() {
        Coordinate coordinate = new Coordinate(1, 1);
        this.board.put(coordinate, Color.X);
        assertThat(this.player.getOriginMoveTokenError(coordinate), is(Error.NOT_OWNER));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenErrorNotNull() {
        Coordinate coordinate = new Coordinate(1, 1);
        this.board.put(coordinate, this.color);
        assertThat(this.player.getTargetMoveTokenError(coordinate, new Coordinate(0,0)), is(Error.NULL));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenErrorNotEmpty() {
        Coordinate coordinate = new Coordinate(1, 1);
        this.board.put(coordinate, Color.X);
        assertThat(this.player.getTargetMoveTokenError(coordinate, coordinate), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenErrorSameCoordinates() {
        Coordinate coordinate = new Coordinate(1, 1);
        this.board.put(coordinate, Color.X);
        assertThat(this.player.getTargetMoveTokenError(coordinate, coordinate), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenNewPlayerWhenGetTokenThenReturnTheToken() {
        assertThat(this.player.getColor(), is(this.color));
    }
}