package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.BoundedIntDialog;

public class Turn {
	
	private Board board;
	static final int NUMBER_PLAYERS = 2;
	private Player[] players;
	private int activePlayer;

	public Turn(Board board) {
		assert board != null;
		this.board = board;
		this.players = new Player[Turn.NUMBER_PLAYERS];
		this.reset();
	}

	void reset() {
		int numberUsers = this.getUsers();
		for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
			if (i < numberUsers){
				this.players[i] = new UserPlayer(Color.get(i), this.board);
			} else {
				this.players[i] = new MachinePlayer(Color.get(i), this.board);
			}
		}
		this.activePlayer = 0;
	}

	private int getUsers() {
		BoundedIntDialog dialog = new BoundedIntDialog(0, Turn.NUMBER_PLAYERS);
		return dialog.read(Message.NUMBER_PLAYERS.toString());
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

	public int getNextActivePlayer() {
		return (this.activePlayer+1) % Turn.NUMBER_PLAYERS;
	}

	public Player getActivePlayer() {
		return this.players[this.activePlayer];
	}

	public Color getActiveColor() {
		return this.getActivePlayer().getColor();
	}

}
