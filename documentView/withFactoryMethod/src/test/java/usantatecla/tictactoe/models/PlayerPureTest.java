package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.Token;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerPureTest {

    private Player player;
    @Mock
    private Board board;

    @BeforeEach
    void before() {
        this.player = new Player(Token.X, this.board);
    }

    @Test
    void testPutNotEmpty() {
        when(this.board.isEmpty(any(Coordinate.class))).thenReturn(false);
        Coordinate coordinate = new Coordinate(0, 0);
        assertEquals(Error.NOT_EMPTY, this.player.put(coordinate));
    }

    @Test
    void testPut() {
        when(this.board.isEmpty(any(Coordinate.class))).thenReturn(true);
        Coordinate coordinate = new Coordinate(0, 0);
        assertEquals(Error.NULL, this.player.put(coordinate));
    }

    @Test
    void testMoveNotOwnerOrigin() {
        when(this.board.isOccupied(any(Coordinate.class), any(Token.class))).thenReturn(false);
        Coordinate coordinateOrigin = new Coordinate(0, 0);
        Coordinate coordinateTarget = new Coordinate(0, 1);
        assertEquals(Error.NOT_OWNER, this.player.move(coordinateOrigin, coordinateTarget));
    }

    @Test
    void testMoveSameCoordinates() {
        when(this.board.isOccupied(any(Coordinate.class), any(Token.class))).thenReturn(true);
        Coordinate coordinateOrigin = new Coordinate(0, 0);
        Coordinate coordinateTarget = new Coordinate(0, 0);
        assertEquals(Error.SAME_COORDINATES, this.player.move(coordinateOrigin, coordinateTarget));
    }

    @Test
    void testMoveNotEmptyTarget() {
        when(this.board.isOccupied(any(Coordinate.class), any(Token.class))).thenReturn(true);
        when(this.board.isEmpty(any(Coordinate.class))).thenReturn(false);
        Coordinate coordinateOrigin = new Coordinate(0, 0);
        Coordinate coordinateTarget = new Coordinate(0, 1);
        assertEquals(Error.NOT_EMPTY, this.player.move(coordinateOrigin, coordinateTarget));
    }

    @Test
    void testMove() {
        when(this.board.isOccupied(any(Coordinate.class), any(Token.class))).thenReturn(true);
        when(this.board.isEmpty(any(Coordinate.class))).thenReturn(true);
        Coordinate coordinateOrigin = new Coordinate(0, 0);
        Coordinate coordinateTarget = new Coordinate(0, 1);
        assertEquals(Error.NULL, this.player.move(coordinateOrigin, coordinateTarget));
    }

    @Test
    void testGetToken() {
        assertEquals(Token.X, this.player.getToken());
    }

    @Test
    void testCopy() {
        assertTrue(this.player.equals(this.player.copy(this.board)));
    }

}
