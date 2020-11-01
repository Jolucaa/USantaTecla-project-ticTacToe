package usantatecla.tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageTest {
    private Message message;

    @Test
    public void testGivenNewMessageToString() {
        assertEquals("Coordinate to put", Message.COORDINATE_TO_PUT.toString());
    }
}
