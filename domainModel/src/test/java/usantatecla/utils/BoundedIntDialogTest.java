package usantatecla.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BoundedIntDialogTest {

  private BoundedIntDialog boundedIntDialog;
  private ClosedInterval limits;
  private String title = "TITLE";

  @Mock
  Console console;

  @BeforeEach
  void before() {
    this.boundedIntDialog = new BoundedIntDialog(0, 3);
    this.limits = new ClosedInterval(0, 3);

  }

  @Test
  public void testGivenLimitedIntDialogWhenReadInsideThenValue() {
    try (MockedStatic<Console> console = mockStatic(Console.class)) {
      console.when(Console::getInstance).thenReturn(this.console);
       int[] VALUES ={0,1,2};
       for (int i = 0; i< VALUES.length;i++){
        when(this.console.readInt(title + "? " + this.limits + ": ")).thenReturn(VALUES[i]);
        assertThat(this.boundedIntDialog.read(title), is(VALUES[i]));
       }

    }


  }
  /*
  @Test
  public void testGivenLimitedIntDialogWhenReadOutsideThenRepeat() {
    try (MockedStatic<Console> console = mockStatic(Console.class)) {
      console.when(Console::getInstance).thenReturn(this.console);
      when(this.console.readInt("")).thenReturn(-2, -2, 0);
      assertThat(this.boundedIntDialog.read(this.title), is(0));
    }
  }

   */

}
