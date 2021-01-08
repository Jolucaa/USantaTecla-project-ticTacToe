package usantatecla.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ConsoleTest {

  @Mock
  private BufferedReader bufferedReader;

  @InjectMocks
  Console console;

  // TODO El espia del out habría que hacerlo como Console (ver comentario debajo)
  /*
  @Spy
  private PrintStream outputStream = spy(System.out);
  */

  @Test
  public void testGivenConsoleWhenReadStringThenValue() throws IOException {
    String string = "***";
    when(this.bufferedReader.readLine()).thenReturn(string);
    assertThat(this.console.readString("TITLE"), is(string));
  }

  @Test
  public void testGivenConsoleWhenReadIntThenValue() throws IOException {
    String string = "123";
    when(this.bufferedReader.readLine()).thenReturn("", "***", string);
    assertThat(this.console.readInt("TITLE"), is(Integer.parseInt(string)));
  }

  @Test
  public void testGivenConsoleWhenReadCharThenValue() throws IOException {
    String string = "b";
    when(this.bufferedReader.readLine()).thenReturn("", "***", string);
    assertThat(this.console.readChar("TITLE"), is(string.charAt(0)));
  }

  /*
  @Test
  public void testGivenConsoleWhenWriteStringThenDisplay(){
    String string = "***";
    Console.getInstance().write(string);
    ArgumentCaptor<Integer> value = ArgumentCaptor.forClass(Integer.class);
    verify(this.outputStream).print(value.capture());
    assertThat(value.getValue(), is(string));
  }

  @Test
  public void testGivenConsoleWhenWriteIntThenDisplay(){
    String string = "123";
    Console.getInstance().write(string);
    ArgumentCaptor<Integer> value = ArgumentCaptor.forClass(Integer.class);
    verify(this.outputStream).print(value.capture());
    assertThat(value.getValue(), is(Integer.parseInt(string)));
  }
  */
}
