package usantatecla.tictactoe.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usantatecla.tictactoe.models.Error;
import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.models.Token;

public class PlayerTest {

    private Board board;

    private Player player;

    private Coordinate coordinate00;
    private Coordinate coordinate01;

    public PlayerTest() {
        this.board = new Board();
        this.player = new Player(Token.O, this.board);
        this.coordinate00 = new Coordinate(0, 0);
        this.coordinate01 = new Coordinate(0, 1);
    }
/*
    @Test
    public void testGivenNewPlayerWhenPutNewTokenThenReturnErrorNotOwner() {
        this.board.put(this.coordinate00, Token.O);
        assertEquals(Error.NOT_OWNER, this.player.getPutCoordinateError(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayerWhenPutNewTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertTrue(this.player.getPutCoordinateError(this.coordinate01) == null);
    }

    @Test
    public void testGivenNewPlayerWhenRemoveTokenThenReturnErrorNotOwner() {
        this.board.put(this.coordinate00, Token.O);
        assertEquals(Error.NOT_OWNER, this.player.getMoveOriginCoordinateError(this.coordinate01));
    }

    @Test
    public void testGivenNewPlayerWhenRemoveTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertTrue(this.player.getMoveOriginCoordinateError(this.coordinate00) == null);
    }

    @Test
    public void testGivenNewPlayerWhenMoveTokenThenReturnErrorSameCoordinates() {
        this.board.put(this.coordinate00, Token.O);
        assertEquals(Error.SAME_COORDINATES, this.player.getMoveTargetCoordinateError(this.coordinate00, this.coordinate00));
    }

    @Test
    public void testGivenNewPlayerWhenMoveTokenThenReturnErrorNotEmpty() {
        this.board.put(this.coordinate00, Token.O);
        this.board.put(this.coordinate01, Token.O);
        assertEquals(Error.NOT_EMPTY, this.player.getMoveTargetCoordinateError(this.coordinate00, this.coordinate01));
    }

    @Test
    public void testGivenNewPlayerWhenMoveTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertTrue(this.player.getMoveTargetCoordinateError(this.coordinate00, this.coordinate01) == null);
    }*/
}
