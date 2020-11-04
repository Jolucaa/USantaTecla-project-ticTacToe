package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.utils.Direction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class CoordinateTest {

    private Coordinate coordinate;

    @BeforeEach
    void before() {
        this.coordinate = new Coordinate(1, 1);
    }

    @Test
    void testIsNull() {
        assertFalse(this.coordinate.isNull());
    }

    @Test
    void testIsNotValid() {
        Coordinate coordinate = new Coordinate(3, 3);
        assertEquals(Error.NOT_VALID, coordinate.isValid());
    }

    @Test
    void testIsValid() {
        assertEquals(Error.NULL, this.coordinate.isValid());
    }

    @Test
    void testGetDirectionNull() {
        assertEquals(Direction.NULL, this.coordinate.getDirection(Coordinate.NULL_COORDINATE));
    }

    @Test
    void testGetDirectionInverseDiagonal() {
        Coordinate coordinateInversalDiagonal = new Coordinate(0, 2);
        assertEquals(Direction.INVERSE_DIAGONAL, this.coordinate.getDirection(coordinateInversalDiagonal));
    }

    @Test
    void testGetDirectionMainDiagonal() {
        Coordinate coordinateMainDiagonal = new Coordinate(0, 0);
        assertEquals(Direction.MAIN_DIAGONAL, this.coordinate.getDirection(coordinateMainDiagonal));
    }

    @Test
    void testRandom() {
        this.coordinate.random();
        assertEquals(Error.NULL, this.coordinate.isValid());
    }

}
