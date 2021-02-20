package usantatecla.tictactoe.models;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.types.Color;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MementoTest {

    private Board board;
    private Memento memento;

    @BeforeEach
    public void beforeEach() {
        this.board = new BoardBuilder().rows(
                "X  ",
                "   ",
                "   ").build();

        this.memento = new Memento(this.board.toCharacterArray(), Color.O);
    }

    @Test
    public void testGivenMementoWhenGetProposedCombinationsThenReturn() {
        assertThat(this.memento.getBoard().toCharacterArray(), is(this.board.toCharacterArray()));
    }

    @Test
    public void testGivenMementoWhenGetActiveColorThenReturn() {
        assertThat(this.memento.getActiveColor(), is(Color.O));
    }
}
