package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.Error;
import usantatecla.utils.Direction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class CoordinateTest {

    private Coordinate coordinate;

    @BeforeEach
    void before() {
        this.coordinate = new Coordinate(1, 1);
    }

    @Test
    void testGivenNewCoordinateWhenIsNullThenIsFalse() {
        assertThat(this.coordinate.isNull(), is(false));
    }

    @Test
    void testGivenNotValidCoordinateWhenIsValidThenIsErrorNotValid() {
        Coordinate coordinate = new Coordinate(3, 3);
        assertThat(coordinate.isValid(), is(Error.NOT_VALID));
    }

    @Test
    void testGivenValidCoordinateWhenIsValidThenIsErrorNull() {
        assertThat(this.coordinate.isValid(), is(Error.NULL));
    }

    @Test
    void testGivenCoordinateAndNullCoordinateWhenNullCoordinateGetDirectionThenIsDirectionNull() {
        assertThat(this.coordinate.getDirection(Coordinate.NULL_COORDINATE), is(Direction.NULL));
    }

    @Test
    void testGivenCoordinateAndInverseDiagonalCoordinateWhenInverseDiagonalCoordinateGetDirectionThenIsCoordinateInverseDiagonal() {
        assertThat(this.coordinate.getDirection(new Coordinate(0, 2)), is(Direction.INVERSE_DIAGONAL));
    }

    @Test
    void testGivenCoordinateAndMainDiagonalCoordinateWhenMainDiagonalCoordinateGetDirectionThenIsCoordinateMainDiagonal() {
        assertThat(this.coordinate.getDirection(new Coordinate(0, 0)), is(Direction.MAIN_DIAGONAL));
    }

    @Test
    void testGivenCoordinateWhenRandomThenIsErrorNull() {
        this.coordinate.random();
        assertThat(this.coordinate.isValid(), is(Error.NULL));
    }

}
