package usantatecla.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConcreteCoordinateTest {
    private ConcreteCoordinate concreteCoordinate;

    @BeforeEach
    void before() {
        this.concreteCoordinate = new ConcreteCoordinate(1, 1);
    }

    @Test
    public void testGivenNewConcreteCoordinateWhenToString() {
        assertThat(this.concreteCoordinate.toString(), is("Coordinate [row=1, column=1]"));
    }

    @Test
    public void testGivenNewConcreteCoordinateWhenIsNull() {
        assertThat(this.concreteCoordinate.isNull(), is(false));
    }
}
