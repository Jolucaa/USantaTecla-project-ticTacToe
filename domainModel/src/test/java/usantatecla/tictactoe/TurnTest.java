package usantatecla.tictactoe;


import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

public class TurnTest {

    private Turn turn;

    @BeforeEach
    void before() {
        Board board = mock(Board.class);
        this.turn = new Turn(board);
    }

    /*@Test
    void testGetToken() {
        assertEquals(Token.O, turn.getToken());
    }*/
}
