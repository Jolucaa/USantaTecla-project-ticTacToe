package usantatecla.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class PlayerTest {

    private Board board;
    private Player player;
    private Color color;

    @Mock
    Console console;

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
        Coordinate coordinate2 = new Coordinate(1, 2);
        this.board.put(coordinate, Color.X);
        this.board.put(coordinate2, Color.X);
        assertThat(this.player.getTargetMoveTokenError(coordinate, coordinate2), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenErrorSameCoordinates() {
        Coordinate coordinate = new Coordinate(1, 1);
        this.board.put(coordinate, Color.X);
        assertThat(this.player.getTargetMoveTokenError(coordinate, coordinate), is(Error.SAME_COORDINATES));
    }

    @Test
    public void testGivenNewPlayerWhenGetTokenThenReturnTheToken() {
        assertThat(this.player.getColor(), is(this.color));
    }

    @Test
    void testGivenPlayerWhenMoveThenIsTrue() {
        Player player1 = new PlayerBuilder().setColor(Color.O).setTypeUserPlayer()
                .putToken(new Coordinate(0,0)).putToken(new Coordinate(0,1))
                .putToken(new Coordinate(1,0)).moveToken(new Coordinate(1,0), new Coordinate(2,0)).build();
        assertThat(player1.board.isEmpty(new Coordinate(1,0)), is(true));
        assertThat(player1.board.isOccupied(new Coordinate(2,0), Color.O), is(true));
    }
}