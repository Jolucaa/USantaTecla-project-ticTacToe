package usantatecla.tictactoe.views;

import usantatecla.tictactoe.types.PlayerType;

import java.util.HashMap;

public class PlayerViewPrototype {

    private HashMap<PlayerType, PlayerView> playerViewAsoc;

    PlayerViewPrototype() {
        this.playerViewAsoc = new HashMap<>();
        this.playerViewAsoc.put(PlayerType.USER, new UserPlayerView());
        this.playerViewAsoc.put(PlayerType.MACHINE, new MachinePlayerView());
    }

    public PlayerView createView(PlayerType playerType) {
        return this.playerViewAsoc.get(playerType);
    }

}
