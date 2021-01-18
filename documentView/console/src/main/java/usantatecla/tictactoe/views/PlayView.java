package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Player;

class PlayView extends WithGameView {

    private PlayViewPrototype playViewPrototype;

    PlayView(Game game) {
        super(game);
        this.playViewPrototype = new PlayViewPrototype();
    }

    void interact() {
        do {
            Player player = this.game.getPlayer();
            PlayerView playerView = this.playViewPrototype.createView(player);
            playerView.interact(player);
            this.game.next();

            new BoardView(this.game).write();
        } while (!this.game.isTicTacToe());
        Message.PLAYER_WIN.writeln(this.game.getActiveColor().name());
    }
}