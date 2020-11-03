package usantatecla.tictactoe;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    
    private Board board;
    private Player player;
    private Coordinate coordinate00;
    private Coordinate coordinate01;

    public PlayerTest() {
        this.board = new Board();
        this.player = new UserPlayer(Token.O, this.board);
        this.coordinate00 = new Coordinate(0, 0);
        this.coordinate01 = new Coordinate(0, 1);
    }

    @Test
    public void testGivenNewPlayerWhenPutNewTokenThenReturnErrorNotEmpty() {
        this.board.put(this.coordinate00, Token.O);
        assertEquals(Error.NOT_EMPTY, this.player.checkPutCoordinateError(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayerWhenPutNewTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertEquals(true, this.player.checkPutCoordinateError(new Coordinate(0, 2)) == Error.NULL);
    }

    @Test
    public void testGivenNewPlayerWhenRemoveTokenThenReturnErrorNotOwner() {
        this.board.put(this.coordinate00, Token.O);
        assertEquals(Error.NOT_OWNER, this.player.checkMoveOriginCoordinateError(this.coordinate01));
    }

    @Test
    public void testGivenNewPlayerWhenRemoveTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertTrue(this.player.checkMoveOriginCoordinateError(this.coordinate00) == Error.NULL);
    }

    @Test
    public void testGivenNewPlayerWhenMoveTokenThenReturnErrorSameCoordinates() {
        this.board.put(this.coordinate00, Token.O);
        assertEquals(Error.SAME_COORDINATES, this.player.checkMoveTargetCoordinateError(this.coordinate00, this.coordinate00));
    }

    @Test
    public void testGivenNewPlayerWhenMoveTokenThenReturnErrorNotEmpty() {
        this.board.put(this.coordinate00, Token.O);
        this.board.put(this.coordinate01, Token.O);
        assertEquals(Error.NOT_EMPTY, this.player.checkMoveTargetCoordinateError(this.coordinate00, this.coordinate01));
    }

    @Test
    public void testGivenNewPlayerWhenMoveTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertTrue(this.player.checkMoveTargetCoordinateError(this.coordinate00, this.coordinate01) == Error.NULL);
    }
}