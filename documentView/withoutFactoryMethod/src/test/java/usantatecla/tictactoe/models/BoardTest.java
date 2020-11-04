package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    void before() {
        this.board = new Board();
    }

    @Test
    void testCopy() {
        assertTrue(this.board.equals(this.board.copy()));
    }

    @Test
    void testGetToken() {
        Coordinate coordinate = new Coordinate(0, 0);
        assertEquals(Token.NULL, this.board.getToken(coordinate));
    }

    @Test
    void testPut() {
        Coordinate coordinate = new Coordinate(0, 0);
        this.board.put(coordinate, Token.X);
        assertEquals(Token.X, this.board.getToken(coordinate));
    }

    @Test
    void testMove() {
        Coordinate coordinateOrigin = new Coordinate(0, 0);
        Coordinate coordinateTarget = new Coordinate(0, 1);
        this.board.put(coordinateOrigin, Token.X);
        this.board.move(coordinateOrigin, coordinateTarget);
        assertEquals(Token.NULL, this.board.getToken(coordinateOrigin));
        assertEquals(Token.X, this.board.getToken(coordinateTarget));
    }

    @Test
    void testIsNotCompleted() {
        assertFalse(this.board.isCompleted());
    }

    @Test
    void testIsCompleted() {
        this.board.put(new Coordinate(0, 0), Token.X);
        this.board.put(new Coordinate(0, 1), Token.X);
        this.board.put(new Coordinate(0, 2), Token.X);
        this.board.put(new Coordinate(1, 0), Token.O);
        this.board.put(new Coordinate(1, 1), Token.O);
        this.board.put(new Coordinate(1, 2), Token.O);
        assertTrue(this.board.isCompleted());
    }

    @Test
    void testIsOccupied() {
        Coordinate coordinate = new Coordinate(0, 0);
        this.board.put(coordinate, Token.X);
        assertTrue(this.board.isOccupied(coordinate, Token.X));
    }

    @Test
    void testIsEmpty() {
        Coordinate coordinate = new Coordinate(0, 0);
        this.board.put(coordinate, Token.X);
        assertFalse(this.board.isEmpty(coordinate));
    }

    @Test
    void testIsNotTicTacToeForNotAllTokensPlaced() {
        assertFalse(this.board.isTicTacToe(Token.X));
    }

    @Test
    void testIsNotTicTacToeForTokensNotAligned() {
        this.board.put(new Coordinate(0, 0), Token.X);
        this.board.put(new Coordinate(0, 1), Token.X);
        this.board.put(new Coordinate(1, 0), Token.X);
        assertFalse(this.board.isTicTacToe(Token.X));
    }

    @Test
    void testIsTicTacToe() {
        this.board.put(new Coordinate(0, 0), Token.X);
        this.board.put(new Coordinate(0, 1), Token.X);
        this.board.put(new Coordinate(0, 2), Token.X);
        assertTrue(this.board.isTicTacToe(Token.X));
    }

}
