package usantatecla.tictactoe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.Console;
import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class MessageTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Mock
    Console console;

    @BeforeEach
    public void before() {
        System.setOut(new PrintStream(outContent));
        this.console = Console.getInstance();
    }

    @Test
    public void testGivenNewMessageWhenToString() {
        assertThat(Message.COORDINATE_TO_PUT.getMessage(), is("Coordinate to put"));
    }

    @Test
    public void testGivenNewMessageWhenWrite(){
            Message.COORDINATE_TO_PUT.write();
            assertThat(Message.COORDINATE_TO_PUT.getMessage(), is(outContent.toString()));
        }

    @Test
    public void testGivenNewMessageWhenWritelnWithoutParams(){
        String newLine = System.getProperty("line.separator");
        Message.COORDINATE_TO_PUT.writeln();
        assertThat(Message.COORDINATE_TO_PUT.getMessage()+newLine, is(outContent.toString()));
    }

    @Test
    public void testGivenNewMessageWhenWritelnWithParams(){
        String playerName = "player";
        String newLine = System.getProperty("line.separator");
        Message.PLAYER_WIN.writeln(playerName);
        assertThat(Message.PLAYER_WIN.getMessage().replaceAll("#player", "" + playerName)+newLine, is(outContent.toString()));
    }

    }



