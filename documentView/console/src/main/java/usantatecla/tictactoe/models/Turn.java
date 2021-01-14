package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.BoundedIntDialog;

public class Turn {
	
	private Board board;
	public static final int NUMBER_PLAYERS = 2;
	private Player[] players;
	private int activePlayer;

	public Turn(Board board) {
		assert board != null;
		this.board = board;
		this.players = new Player[Turn.NUMBER_PLAYERS];
		this.activePlayer = 0;
	}

	void setUsers(int numberUsers) {
		for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
			if (i < numberUsers){
				this.players[i] = new UserPlayer(Color.get(i), this.board);
			} else {
				this.players[i] = new MachinePlayer(Color.get(i), this.board);
			}
		}
	}

	public void play(){
		this.getActivePlayer().play();
		if (!this.isTicTacToe()){
			this.activePlayer = this.getNextActivePlayer();
		}
	}

	private boolean isTicTacToe() {
		return this.board.isTicTacToe(this.getActiveColor());
	}

	private int getNextActivePlayer() {
		return (this.activePlayer+1) % Turn.NUMBER_PLAYERS;
	}

	public Player getActivePlayer() {
		return this.players[this.activePlayer];
	}

	public Color getActiveColor() {
		return this.getActivePlayer().getColor();
	}

}
