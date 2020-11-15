package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Token;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TokenViewTest {
    @Mock
    Game game;

    @Mock
    Console console;

    @Captor
    ArgumentCaptor<String> tokenCaptor;


    TokenView tokenView;

    @BeforeEach
    void before() {
        tokenView = new TokenView(Token.X);
    }

    @Test
    void testGivenTokenThenWrite() {
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            tokenView.write();
            Mockito.verify(this.console).getInstance().write(tokenCaptor.capture());
            String tokenCaptorValue = tokenCaptor.getValue();
            assertThat(tokenCaptorValue, is(Token.X.toString()));
        }
    }


}
