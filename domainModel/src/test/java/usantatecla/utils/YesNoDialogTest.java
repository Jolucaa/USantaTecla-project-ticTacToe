package usantatecla.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class YesNoDialogTest {

  private YesNoDialog yesNoDialog;
  private String title = "TITLE";

  @Mock
  private Console console;

  @BeforeEach
  void before() {
    this.yesNoDialog = new YesNoDialog();
  }

  @Test
  public void testGivenYesNoDialogWhenReadThenIsAffirmative() {
    final String[] YES = new String[]{"y", "Y"};
    for (int i = 0; i < YES.length; i++) {
      when(this.console.readString("")).thenReturn(YES[i]);
      this.yesNoDialog.read(this.title);
      assertThat(this.yesNoDialog.isAffirmative(), is(true));
    }
  }

  @Test
  public void testGivenYesNoDialogWhenReadThenIsNegative() {
    final String[] NO = new String[]{"n", "N"};
    for (int i = 0; i < NO.length; i++) {
      when(this.console.readString("")).thenReturn(NO[i]);
      this.yesNoDialog.read(this.title);
      assertThat(this.yesNoDialog.isAffirmative(), is(false));
    }
  }
  
  @Test
  public void testGivenYesNoDialogWhenReadThenRepeatWithError() {
    final String[] ERRORS_YES = new String[]{" ", "1", "s", "*", "y"};
    for (int i = 0; i < ERRORS_YES.length; i++) {
      when(this.console.readString(anyString())).thenReturn(ERRORS_YES[i]);
    }
    this.yesNoDialog.read(this.title);
    assertThat(this.yesNoDialog.isAffirmative(), is(true));
  }

}
