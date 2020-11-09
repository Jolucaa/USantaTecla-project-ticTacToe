package usantatecla.tictactoe.models;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TokenTest {

    @Test
    void testGivenXTokenWhenIsNullThenIsFalse() {
        assertThat(Token.X.isNull(), is(false));
    }

    @Test
    void testWhenGetFirstTokenThenTokenIsX() {
        assertThat(Token.get(0), is(Token.X));
    }

    @Test
    void testGivenXTokenWhenToStringThenIsX(){
        assertThat(Token.X.toString(), is("X"));
    }

}
