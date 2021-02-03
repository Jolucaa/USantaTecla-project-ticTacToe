package usantatecla.tictactoe.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.views.StartView;

@ExtendWith(MockitoExtension.class)
public class StartControllerTest extends ControllerTest {

    @Mock
    private StartView startView;

    @BeforeEach
    public void beforeEach() {
        this.game = new Game();
        this.controller = new StartController(this.game, this.viewFactory);
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);
    }

    @Test
    public void testGivenStartControllerWhenControlThenCorrectInteractions() {
        when(this.viewFactory.createStartView()).thenReturn(this.startView);
        ((StartController) this.controller).control();
        verify(this.startView).write();
        String board =
                "   " +
                "   " +
                "   ";
        ArgumentCaptor<Color> argumentCaptor = ArgumentCaptor.forClass(Color.class);
        verify(this.boardView, atLeastOnce()).set(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues(), is(this.stringToColors(board)));
        verify(this.boardView).write();
    }

}
