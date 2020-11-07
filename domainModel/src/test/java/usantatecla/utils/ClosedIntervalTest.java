package usantatecla.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ClosedIntervalTest {

    private ClosedInterval closedInterval;

    @BeforeEach
    void before() {
        this.closedInterval = new ClosedInterval(1, 1);
    }

    @Test
    public void testGivenNewNullCoordinateWhenToString() {
        assertThat(this.closedInterval.toString(), is("[1, 1]"));
    }
}
