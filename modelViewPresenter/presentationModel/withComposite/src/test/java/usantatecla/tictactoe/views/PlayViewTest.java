package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.Token;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class PlayViewTest {

    @Mock
    private PlayController playController;

    @InjectMocks
    private PlayView playView;

    @BeforeEach
    void before() {
        openMocks(this);
        this.playView = spy(this.playView);
    }

    @Test
    void testGivenNewPlayViewWhenMachinePlayerPutCoordinateThenGamePutCoordinate() {
        Coordinate coordinate = new Coordinate(0, 0);
        when(this.playController.isBoardComplete()).thenReturn(false);
        when(this.playController.isUser()).thenReturn(false);
        when(this.playView.createRandomCoordinate()).thenReturn(coordinate);
        when(this.playController.put(any(Coordinate.class))).thenReturn(Error.NULL);
        when(this.playController.getToken(any(Coordinate.class))).thenReturn(Token.X);
        this.playView.interact(this.playController);
        verify(this.playController).put(coordinate);
    }

    @Test
    void testGivenNewPlayViewWhenMachinePlayerMoveOriginToTargetThenGameMoveOriginToTarget() {
        Coordinate origin = new Coordinate(0, 0);
        Coordinate target = new Coordinate(1, 1);
        when(this.playController.isBoardComplete()).thenReturn(true);
        when(this.playController.isUser()).thenReturn(false);
        when(this.playView.createRandomCoordinate()).thenReturn(target, origin);
        when(this.playController.move(any(Coordinate.class), any(Coordinate.class))).thenReturn(Error.NULL);
        when(this.playController.getToken(any(Coordinate.class))).thenReturn(Token.X);
        this.playView.interact(this.playController);
        verify(this.playController).move(origin, target);
    }

}