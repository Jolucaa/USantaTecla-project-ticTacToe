package usantatecla.tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserPlayerTest {
    private Board board;
    private UserPlayer player;
    private Coordinate coordinate00;
    private Coordinate coordinate01;

    public UserPlayerTest() {
        this.board = new Board();
        this.player = new UserPlayer(Token.O, this.board);
        this.coordinate00 = new Coordinate(0, 0);
        this.coordinate01 = new Coordinate(0, 1);
    }

    @Test
    public void testGivenNewUserPlayerWhenPutNewTokenThenReturnErrorNotEmpty() {
        this.board.put(this.coordinate00, Token.O);
        assertEquals(Error.NOT_EMPTY, this.player.checkPutCoordinateError(this.coordinate00));
    }

    @Test
    public void testGivenNewUserPlayerWhenPutNewTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertEquals(true, this.player.checkPutCoordinateError(new Coordinate(0, 2)) == Error.NULL);
    }

    @Test
    public void testGivenNewUserPlayerWhenRemoveTokenThenReturnErrorNotOwner() {
        this.board.put(this.coordinate00, Token.O);
        assertEquals(Error.NOT_OWNER, this.player.checkMoveOriginCoordinateError(this.coordinate01));
    }

    @Test
    public void testGivenNewUserPlayerWhenRemoveTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertTrue(this.player.checkMoveOriginCoordinateError(this.coordinate00) == Error.NULL);
    }

    @Test
    public void testGivenNewUserPlayerWhenMoveTokenThenReturnErrorSameCoordinates() {
        this.board.put(this.coordinate00, Token.O);
        assertEquals(Error.SAME_COORDINATES, this.player.checkMoveTargetCoordinateError(this.coordinate00, this.coordinate00));
    }

    @Test
    public void testGivenNewUserPlayerWhenMoveTokenThenReturnErrorNotEmpty() {
        this.board.put(this.coordinate00, Token.O);
        this.board.put(this.coordinate01, Token.O);
        assertEquals(Error.NOT_EMPTY, this.player.checkMoveTargetCoordinateError(this.coordinate00, this.coordinate01));
    }

    @Test
    public void testGivenNewUserPlayerWhenMoveTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertTrue(this.player.checkMoveTargetCoordinateError(this.coordinate00, this.coordinate01) == Error.NULL);
    }
}
