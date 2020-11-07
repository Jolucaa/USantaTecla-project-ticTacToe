package usantatecla.tictactoe;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MessageTest {
    private Message message;

    @Test
    public void testGivenNewMessageWhenToString() {
        assertThat(Message.COORDINATE_TO_PUT.toString(), is("Coordinate to put"));
    }
}
