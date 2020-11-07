package usantatecla.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TokenTest {

    @Test
    public void testGivenNewTokenWhenCallGetThenReturnTheCorrectToken() {
        assertThat(Token.get(0), is(Token.X));
    }

}
