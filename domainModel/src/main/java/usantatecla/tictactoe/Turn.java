package usantatecla.tictactoe;

import usantatecla.utils.BoundedIntDialog;

class Turn {
	
	private Board board;
	static final int NUMBER_PLAYERS = 2;
	private Player[] players;
	private int activePlayer;

	Turn(Board board) {
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

	void play(){
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

	private Player getActivePlayer() {
		return this.players[this.activePlayer];
	}

	void writeWinner(){
		this.getActivePlayer().writeWinner();
	}

	Color getActiveColor() {
		return this.getActivePlayer().getColor();
	}

}
