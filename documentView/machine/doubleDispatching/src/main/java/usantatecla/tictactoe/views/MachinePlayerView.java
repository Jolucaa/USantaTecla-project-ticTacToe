package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.MachinePlayer;
import usantatecla.tictactoe.types.Coordinate;

class MachinePlayerView extends PlayerView {

    @Override
    protected Coordinate getCoordinate(Message message) {
        return ((MachinePlayer) this.player).getRandomCoordinate();
    }
}
