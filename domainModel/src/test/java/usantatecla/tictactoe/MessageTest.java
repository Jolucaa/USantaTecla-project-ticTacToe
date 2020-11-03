package usantatecla.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {
    private Message message;

    @Test
    public void testGivenNewMessageToString() {
        assertEquals("Coordinate to put", Message.COORDINATE_TO_PUT.toString());
    }
}
