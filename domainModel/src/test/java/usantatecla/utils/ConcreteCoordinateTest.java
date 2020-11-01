package usantatecla.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConcreteCoordinateTest {
    private ConcreteCoordinate concreteCoordinate;

    public ConcreteCoordinateTest() {
        this.concreteCoordinate = new ConcreteCoordinate(1,1);
    }

    @Test
    public void testGivenNewConcreteCoordinateToString() {
        assertEquals("Coordinate [row=1, column=1]", this.concreteCoordinate.toString());
    }

    @Test
    public void testGivenNewConcreteCoordinateIsNull() {
        assertEquals(false, this.concreteCoordinate.isNull());
    }
}
