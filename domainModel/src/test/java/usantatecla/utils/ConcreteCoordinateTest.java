package usantatecla.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class ConcreteCoordinateTest {

    private ConcreteCoordinate coordinate;

    @Mock
    private Console console;

    @BeforeEach
    void before() {
        this.coordinate = new ConcreteCoordinate();
    }

    @Test
    public void testGivenConcreteCoordinateWhenReadThenChangeState() {
        int row = 1;
        int column = 1;
        when(console.readInt(anyString())).thenReturn(0, row, 4, column);
        assertThat(this.coordinate, is(new ConcreteCoordinate(row, column)));
    }

}
