package usantatecla.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

//TODO Abstracción
@ExtendWith(MockitoExtension.class)
public class PlayerTest {

    private Color color;

    //TODO beforeEach
    @BeforeEach
    void beforeEach() {
        this.color = Color.O;
    }

    @Test
    public void testGivenPlayerWhenGetPutTokenErrorThenErrorNULL() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = new PlayerBuilder().setColor(this.color).setTypeUserPlayer().build();
        Player player2 = new PlayerBuilder().setColor(this.color).setTypeMachinePlayer().build();
        assertThat(player.getPutTokenError(coordinate), is(Error.NULL));
        assertThat(player2.getPutTokenError(coordinate), is(Error.NULL));
    }

    @Test
    public void testGivenPlayerWhenGetPutTokenErrorThenErrorNotEmpty() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = new PlayerBuilder().setColor(this.color).setTypeUserPlayer()
                .putToken(coordinate).build();
        assertThat(player.getPutTokenError(coordinate), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenPlayerWhenGetOriginMoveTokenErrorThenErrorNotOwner() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = new PlayerBuilder().setColor(this.color).setTypeUserPlayer()
                .putToken(coordinate).build();
        Player player2 = new PlayerBuilder().setColor(Color.X).setTypeUserPlayer().build();
        assertThat(player2.getOriginMoveTokenError(coordinate), is(Error.NOT_OWNER));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenNoError() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = new PlayerBuilder().setColor(this.color).setTypeUserPlayer()
                .putToken(coordinate).build();
        assertThat(player.getTargetMoveTokenError(coordinate, new Coordinate(0,0)), is(Error.NULL));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenErrorNotEmpty() {
        Coordinate coordinate = new Coordinate(1, 1);
        Coordinate coordinate2 = new Coordinate(1, 2);
        Player player = new PlayerBuilder().setColor(this.color).setTypeUserPlayer()
                .putToken(coordinate).putToken(coordinate2).build();
        assertThat(player.getTargetMoveTokenError(coordinate, coordinate2), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenErrorSameCoordinates() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = new PlayerBuilder().setColor(this.color).setTypeUserPlayer()
                .putToken(coordinate).build();
        assertThat(player.getTargetMoveTokenError(coordinate, coordinate), is(Error.SAME_COORDINATES));
    }

    @Test
    public void testGivenNewPlayerWhenGetTokenThenReturnTheToken() {
        Player player = new PlayerBuilder().setColor(this.color).setTypeUserPlayer().build();
        assertThat(player.getColor(), is(this.color));
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