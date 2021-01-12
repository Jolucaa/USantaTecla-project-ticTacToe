package usantatecla.tictactoe;

import static org.mockito.Mockito.*;

//TODO Cambiar lectura de coordenadas
public class PlayerBuilder {

    private Player player;
    private Color color;
    private Board board;

    public PlayerBuilder() {
        this.board = new Board();
        this.board.reset();
    }

    public PlayerBuilder setColor(Color color) {
        this.color = color;
        return this;
    }

    public PlayerBuilder setTypeUserPlayer() {
        this.player = spy(new UserPlayer(this.color, this.board));
        return this;
    }

    public PlayerBuilder setTypeMachinePlayer() {
        this.player = spy(new MachinePlayer(this.color, this.board));
        return this;
    }

    public PlayerBuilder putToken(Coordinate coordinate){
        doReturn(coordinate).when(this.player).getCoordinate(any());
        this.player.play();
        return this;
    }

    public PlayerBuilder moveToken(Coordinate origin, Coordinate target){
        doReturn(origin, target).when(this.player).getCoordinate(any());
        this.player.play();
        return this;
    }

    public Player build() {
        return this.player;
    }
}
