package usantatecla.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NullCoordinateTest {
    private NullCoordinate nullCoordinate;

    @BeforeEach
    void before() {
        this.nullCoordinate = new NullCoordinate();
    }

    @Test
    public void testGivenNewNullCoordinateWhenIsEqualsTrue() {
        assertThat(this.nullCoordinate.equals(new NullCoordinate()), is(true));
    }

    @Test
    public void testGivenNewNullCoordinateWhenToString() {
        assertThat(this.nullCoordinate.toString(), is("NullCoordinate []"));
    }

    @Test
    public void testGivenNewNullCoordinateWhenHashCodeThen0() {
        assertThat(this.nullCoordinate.hashCode(), is(0));
    }

    @Test
    public void testGivenNewNullCoordinateWhenInMainDiagonalThenFalse() {
        assertThat(this.nullCoordinate.inMainDiagonal(), is(false));
    }

    @Test
    public void testGivenNewNullCoordinateWhenInHorizontalThenFalse() {
        assertThat(this.nullCoordinate.inHorizontal(new ConcreteCoordinate()), is(false));
    }

    @Test
    public void testGivenNewNullCoordinateWhenInVerticalThenFalse() {
        assertThat(this.nullCoordinate.inVertical(new ConcreteCoordinate()), is(false));
    }

    @Test
    public void testGivenNewNullCoordinateWhenGetDirectionThenNullDirection() {
        assertThat(this.nullCoordinate.getDirection(new ConcreteCoordinate()), is(Direction.NULL));
    }

    @Test
    public void testGivenNewNullCoordinateIsNull() {
        assertThat(this.nullCoordinate.isNull(), is(true));
    }
}
