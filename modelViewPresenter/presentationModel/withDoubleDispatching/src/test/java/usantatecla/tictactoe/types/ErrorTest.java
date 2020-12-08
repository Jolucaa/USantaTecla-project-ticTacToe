package usantatecla.tictactoe.types;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ErrorTest {

    @Test
    void testGivenErrorNotValidWhenIsNullThenIsFalse() {
        assertThat(Error.NOT_VALID.isNull(), is(false));
    }

}
