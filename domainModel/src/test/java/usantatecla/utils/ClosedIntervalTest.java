package usantatecla.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClosedIntervalTest {

    private ClosedInterval closedInterval;

    @BeforeEach
    void before() {
        this.closedInterval = new ClosedInterval(1, 1);
    }

    @Test
    public void testGivenNewNullCoordinateToString() {
        assertEquals("[1, 1]", this.closedInterval.toString());
    }
}
