package usantatecla.tictactoe.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.views.console.CoordinateView;
import usantatecla.tictactoe.views.console.PlayerView;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayControllerTest extends ControllerTest {

    @Mock
    private PlayerView playerView;

    @Mock
    private CoordinateView coordinateView;

    @BeforeEach
    public void beforeEach() {
        this.controller = new PlayController(this.game, this.viewFactory);
    }

    @Test
    public void testGivenPlayControllerWinnerGameWhenControlThenIsWinner() {
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);
        when(this.viewFactory.createPlayerView()).thenReturn(this.playerView);
        when(this.viewFactory.createCoordinateView()).thenReturn(this.coordinateView);
        when(this.coordinateView.read(any())).thenReturn(new Coordinate(0,0));
        doReturn(true).when(this.game).isTicTacToe();
        doReturn(Color.O).when(this.game).getActiveColor();
        ((PlayController) this.controller).control();
        verify(this.playerView).writeWinner(Color.O);
    }

}
