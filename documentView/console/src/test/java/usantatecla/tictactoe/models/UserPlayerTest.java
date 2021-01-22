package usantatecla.tictactoe.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.types.PlayerType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class UserPlayerTest extends PlayerTest{

    @Override
    public PlayerBuilder getPlayerBuilder() {
        return new PlayerBuilder().color(this.COLOR).user();
    }

    @Test
    public void testGivenNewPlayerWhenIsUserPlayerThenReturnTrue() {
        Player player = this.getPlayerBuilder().build();
        assertThat(player.getType(), is(PlayerType.USER));
    }

}
