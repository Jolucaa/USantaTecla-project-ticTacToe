package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.types.PlayerType;

import java.util.HashMap;

public class PlayViewPrototype {

    private HashMap<PlayerType, PlayerView> playerViewAsoc;

    PlayViewPrototype() {
        this.playerViewAsoc = new HashMap<>();
        this.playerViewAsoc.put(PlayerType.USER, new UserPlayerView());
        this.playerViewAsoc.put(PlayerType.MACHINE, new MachinePlayerView());
    }

    public PlayerView createView(Player player) {
        return this.playerViewAsoc.get(player.getType());
    }

}
