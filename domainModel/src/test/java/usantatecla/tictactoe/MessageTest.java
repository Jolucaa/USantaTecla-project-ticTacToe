package usantatecla.tictactoe;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MessageTest {

    @Test
    public void testGivenNewMessageWhenToString() {
        assertThat(Message.COORDINATE_TO_PUT.getMessage(), is("Coordinate to put"));
    }
/*
    @Test
    public void prueba() {
        Message.COORDINATE_TO_MOVE.write();
        assertThat(Message.COORDINATE_TO_PUT.getMessage(), is("Coordinate to put"));
    }

 */
}
