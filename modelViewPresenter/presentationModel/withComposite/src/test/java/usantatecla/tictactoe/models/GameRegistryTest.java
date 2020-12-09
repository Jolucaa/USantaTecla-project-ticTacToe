package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameRegistryTest {

    @Captor
    private ArgumentCaptor<GameMemento> argumentCaptor;
    @Spy
    private Game game;
    private GameRegistry gameRegistry;

    @BeforeEach
    void before() {
        this.game = spy(new GameBuilder().build());
        this.gameRegistry = new GameRegistry(this.game);
    }

    @Test
    void testGivenNewGameRegistryWhenRegisterThenGameMementoIsCreatedAndGameRegistryIsUndoable() {
        this.gameRegistry.register();
        verify(this.game, times(2)).createMemento();
        assertThat(this.gameRegistry.isUndoable(), is(true));
    }

    @Test
    void testGivenNewGameRegistryWhenUndoThenIndexOutOfBoundsExceptionIsThrown() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.gameRegistry.undo());
    }

    @Test
    void testGivenGameRegistryWithOneMementoWhenUndoThenGameIsSet() {
        this.gameRegistry.register();
        this.gameRegistry.undo();
        verify(this.game).set(argumentCaptor.capture());
        assertThat(this.argumentCaptor.getValue().getBoard(), is(new Board()));
    }

    @Test
    void testGivenNewGameRegistryWhenRedoThenIndexOutOfBoundsExceptionIsThrown() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.gameRegistry.redo());
    }

    @Test
    void testGivenGameRegistryWithOneMementoWhenRedoThenGameIsSet() {
        this.gameRegistry.register();
        this.gameRegistry.undo();
        this.gameRegistry.redo();
        verify(this.game, times(2)).set(argumentCaptor.capture());
        assertThat(this.argumentCaptor.getValue().getBoard(), is(new Board()));
    }

    @Test
    void testGivenNewGameRegistryWhenIsUndoableThenIsFalse() {
        assertThat(this.gameRegistry.isUndoable(), is(false));
    }

    @Test
    void testGivenGameRegistryWithOneMementoWhenIsUndoableThenIsTrue() {
        this.gameRegistry.register();
        assertThat(this.gameRegistry.isUndoable(), is(true));
    }

    @Test
    void testGivenNewGameRegistryWhenIsRedoableThenIsFalse() {
        assertThat(this.gameRegistry.isRedoable(), is(false));
    }

    @Test
    void testGivenGameRegistryWithOneMementoWhenIsRedoableThenIsTrue() {
        this.gameRegistry.register();
        this.gameRegistry.undo();
        assertThat(this.gameRegistry.isRedoable(), is(true));
    }

}
