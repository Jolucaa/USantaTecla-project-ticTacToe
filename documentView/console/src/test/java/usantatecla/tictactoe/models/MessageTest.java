package usantatecla.tictactoe.models;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.Console;
import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MessageTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    Console console;

    @BeforeEach
    public void beforeEach() {
        System.setOut(new PrintStream(output));
        this.console = Console.getInstance();
    }

    @Test
    public void testGivenNewMessageWhenToString() {
        assertThat(Message.COORDINATE_TO_PUT.toString(), is("Coordinate to put"));
    }
}



