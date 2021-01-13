package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;

class PlayView extends WithGameView {

    PlayView(Game game) {
        super(game);
    }

    void interact() {
        do {
            this.game.play();
            new BoardView(this.game).write();
        } while (!this.game.isTicTacToe());
        new ColorView(this.game.getActiveColor()).write();
        this.writeWinner();
    }

    private void writeWinner() {
		Message.PLAYER_WIN.writeln(this.game.getActiveColor().name());
	}

}