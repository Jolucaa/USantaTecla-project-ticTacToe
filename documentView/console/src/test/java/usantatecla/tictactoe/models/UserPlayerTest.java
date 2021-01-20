package usantatecla.tictactoe.models;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserPlayerTest extends PlayerTest{

    @Override
    public PlayerBuilder getPlayerBuilder() {
        return new PlayerBuilder().color(this.COLOR).user();
    }

    //TODO Preguntar a Luis

}
