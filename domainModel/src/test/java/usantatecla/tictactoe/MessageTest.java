package usantatecla.tictactoe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.utils.Console;
import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MessageTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    Console console;

    @BeforeEach
    public void before() {
        System.setOut(new PrintStream(output));
        this.console = Console.getInstance();
    }

    @Test
    public void testGivenNewMessageWhenToString() {
        assertThat(Message.COORDINATE_TO_PUT.getMessage(), is("Coordinate to put"));
    }

    @Test
    public void testGivenNewMessageWhenWrite(){
        Message.COORDINATE_TO_PUT.write();
        assertThat(Message.COORDINATE_TO_PUT.getMessage(), is(output.toString()));
    }

    @Test
    public void testGivenNewMessageWhenWritelnWithoutParams(){
        String newLine = System.getProperty("line.separator");
        Message.COORDINATE_TO_PUT.writeln();
        assertThat(Message.COORDINATE_TO_PUT.getMessage()+newLine, is(output.toString()));
    }

    @Test
    public void testGivenNewMessageWhenWritelnWithParams(){
        String playerName = "player";
        String newLine = System.getProperty("line.separator");
        Message.PLAYER_WIN.writeln(playerName);
        assertThat(Message.PLAYER_WIN.getMessage().replaceAll("#player", "" + playerName)+newLine, is(output.toString()));
    }
}



