package usantatecla.tictactoe;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurnTest {

    private TicTacToe ticTacToe;
    private Turn turn;
    private Player[] players;
    private Board board;

    public TurnTest() {
   	final int NUMBER_PLAYER = 2;
   	    ticTacToe = new TicTacToe();
        //board = new Board();
        //this.turn = ticTacToe.turn;
        /*this.players=new Player[NUMBER_PLAYER];
        this.players[0] = new UserPlayer(Token.O, this.board);
        this.players[1] = new UserPlayer(Token.X, this.board);*/
    }

    @Test
    public void testGivenNewTurnWhenChangeTurnThenIsOtherTurn() {

    }

    /*@Test
    public void testGivenNewTurnWhenChangeTurnTwoTimesThenIsTheSameTurn() {
        assertEquals(this.players[0].getToken(), this.turn.getPlayer().getToken());
        assertEquals(this.players[1].getToken(), this.turn.getOtherPlayer().getToken());
        this.turn.change();
        assertEquals(this.players[1].getToken(), this.turn.getPlayer().getToken());
        assertEquals(this.players[0].getToken(), this.turn.getOtherPlayer().getToken());
        this.turn.change();
        assertEquals(this.players[0].getToken(), this.turn.getPlayer().getToken());
        assertEquals(this.players[1].getToken(), this.turn.getOtherPlayer().getToken());
    }*/
}
