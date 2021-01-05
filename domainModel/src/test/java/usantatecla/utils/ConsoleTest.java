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
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Spy;

public class ConsoleTest {
  // TODO Completar y hacer tests para Read y para Write
  @Mock
  private BufferedReader bufferedReader;
  @Spy
  private PrintStream outputStream = spy(System.out);

  @Test
  public void testGivenConsoleWhenReadStringThenValue() throws IOException {
    String string = "***";
    when(this.bufferedReader.readLine()).thenReturn(string);
    assertThat(Console.instance().readString("TITLE"), is(string));
  }

  @Test
  public void testGivenConsoleWhenReadIntThenValue() throws IOException {
    String string = "123";
    when(this.bufferedReader.readLine()).thenReturn("", "***", string);
    assertThat(Console.instance().readString("TITLE"), is(Integer.parseInt(string)));
  }

  @Test
  public void testGivenConsoleWhenWriteStringThenDisplay(){
    String string = "***";
    Console.instance().write(string);
    ArgumentCaptor<Integer> value = ArgumentCaptor.forClass(Integer.class);
    verify(this.outputStream).print(value.capture());
    assertThat(value.getValue(), is(string));
  }

  @Test
  public void testGivenConsoleWhenWriteIntThenDisplay(){
    String string = "123";
    Console.instance().write(string);
    ArgumentCaptor<Integer> value = ArgumentCaptor.forClass(Integer.class);
    verify(this.outputStream).print(value.capture());
    assertThat(value.getValue(), is(Integer.parseInt(string)));
  }

}
