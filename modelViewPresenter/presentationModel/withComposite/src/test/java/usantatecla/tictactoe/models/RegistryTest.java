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
public class RegistryTest {

    @Captor
    private ArgumentCaptor<Memento> argumentCaptor;
    @Spy
    private Game game;
    private Registry registry;

    @BeforeEach
    void before() {
        this.game = spy(new GameBuilder().build());
        this.registry = new Registry(this.game);
    }

    @Test
    void testGivenNewGameRegistryWhenRegisterThenGameMementoIsCreatedAndGameRegistryIsUndoable() {
        this.registry.register();
        verify(this.game, times(2)).createMemento();
        assertThat(this.registry.isUndoable(), is(true));
    }

    @Test
    void testGivenNewGameRegistryWhenUndoThenIndexOutOfBoundsExceptionIsThrown() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.registry.undo());
    }

    @Test
    void testGivenGameRegistryWithOneMementoWhenUndoThenGameIsSet() {
        this.registry.register();
        this.registry.undo();
        verify(this.game).setMemento(argumentCaptor.capture());
        assertThat(this.argumentCaptor.getValue().getBoard(), is(new Board()));
    }

    @Test
    void testGivenNewGameRegistryWhenRedoThenIndexOutOfBoundsExceptionIsThrown() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.registry.redo());
    }

    @Test
    void testGivenGameRegistryWithOneMementoWhenRedoThenGameIsSet() {
        this.registry.register();
        this.registry.undo();
        this.registry.redo();
        verify(this.game, times(2)).setMemento(argumentCaptor.capture());
        assertThat(this.argumentCaptor.getValue().getBoard(), is(new Board()));
    }

    @Test
    void testGivenNewGameRegistryWhenIsUndoableThenIsFalse() {
        assertThat(this.registry.isUndoable(), is(false));
    }

    @Test
    void testGivenGameRegistryWithOneMementoWhenIsUndoableThenIsTrue() {
        this.registry.register();
        assertThat(this.registry.isUndoable(), is(true));
    }

    @Test
    void testGivenNewGameRegistryWhenIsRedoableThenIsFalse() {
        assertThat(this.registry.isRedoable(), is(false));
    }

    @Test
    void testGivenGameRegistryWithOneMementoWhenIsRedoableThenIsTrue() {
        this.registry.register();
        this.registry.undo();
        assertThat(this.registry.isRedoable(), is(true));
    }

}
