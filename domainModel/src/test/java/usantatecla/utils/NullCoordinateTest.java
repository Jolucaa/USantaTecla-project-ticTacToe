package usantatecla.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NullCoordinateTest {
    private NullCoordinate nullCoordinate;

    public NullCoordinateTest() {
        this.nullCoordinate = new NullCoordinate();
    }

    @Test
    public void testGivenNewNullCoordinateWhenIsEqualsTrue() {
        assertEquals(true, this.nullCoordinate.equals(new NullCoordinate()));
    }

    @Test
    public void testGivenNewNullCoordinateToString() {
        assertEquals("NullCoordinate []", this.nullCoordinate.toString());
    }

    @Test
    public void testGivenNewNullCoordinateHashCode() {
        assertEquals(0, this.nullCoordinate.hashCode());
    }

    @Test
    public void testGivenNewNullCoordinateInMainDiagonal() {
        assertEquals(false, this.nullCoordinate.inMainDiagonal());
    }

    @Test
    public void testGivenNewNullCoordinateInHorizontal() {
        assertEquals(false, this.nullCoordinate.inHorizontal(new ConcreteCoordinate()));
    }

    @Test
    public void testGivenNewNullCoordinateInVertical() {
        assertEquals(false, this.nullCoordinate.inVertical(new ConcreteCoordinate()));
    }

    @Test
    public void testGivenNewNullCoordinateGetDirection() {
        assertEquals(Direction.NULL, this.nullCoordinate.getDirection(new ConcreteCoordinate()));
    }

    @Test
    public void testGivenNewNullCoordinateIsNull() {
        assertEquals(true, this.nullCoordinate.isNull());
    }
}
