package usantatecla.tictactoe;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PlayerTest {
    
    private Board board;
    private Player player;
    private Coordinate coordinate00;
    private Coordinate coordinate01;

    @BeforeEach
    void before() {
        this.board = new Board();
        this.player = new UserPlayer(Token.O, this.board);
        this.coordinate00 = new Coordinate(0, 0);
        this.coordinate01 = new Coordinate(0, 1);
    }

    @Test
    public void testGivenNewPlayerWhenPutNewTokenThenReturnErrorNotEmpty() {
        this.board.put(this.coordinate00, Token.O);
        assertThat(this.player.checkPutCoordinateError(this.coordinate00), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenNewPlayerWhenPutNewTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertThat(this.player.checkPutCoordinateError(new Coordinate(0, 2)) == Error.NULL, is(true));
    }

    @Test
    public void testGivenNewPlayerWhenRemoveTokenThenReturnErrorNotOwner() {
        this.board.put(this.coordinate00, Token.O);
        assertThat(this.player.checkMoveOriginCoordinateError(this.coordinate01), is(Error.NOT_OWNER));
    }

    @Test
    public void testGivenNewPlayerWhenRemoveTokenThenReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertThat(this.player.checkMoveOriginCoordinateError(this.coordinate00) == Error.NULL, is(true));
    }

    @Test
    public void testGivenNewPlayerWhenMoveTokenThenReturnErrorSameCoordinates() {
        this.board.put(this.coordinate00, Token.O);
        assertThat(this.player.checkMoveTargetCoordinateError(this.coordinate00, this.coordinate00), is(Error.SAME_COORDINATES));
    }

    @Test
    public void testGivenNewPlayerWhenMoveTokenThenReturnErrorNotEmpty() {
        this.board.put(this.coordinate00, Token.O);
        this.board.put(this.coordinate01, Token.O);
        assertThat(this.player.checkMoveTargetCoordinateError(this.coordinate00, this.coordinate01), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenNewPlayerWhenMoveTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertThat(this.player.checkMoveTargetCoordinateError(this.coordinate00, this.coordinate01) == Error.NULL, is(true));
    }

    @Test
    public void testGivenNewPlayerWhenGetTokenThenReturnTheToken() {
        assertThat(this.player.getToken(), is(Token.O));
    }
}