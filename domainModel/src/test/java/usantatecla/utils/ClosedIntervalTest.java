package usantatecla.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClosedIntervalTest {

    private ClosedInterval closedInterval;

    public ClosedIntervalTest() {
        this.closedInterval = new ClosedInterval(1,1);
    }

    @Test
    public void testGivenNewNullCoordinateToString() {
        assertEquals("[1, 1]", this.closedInterval.toString());
    }
}
