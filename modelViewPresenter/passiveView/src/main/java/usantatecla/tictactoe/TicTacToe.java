package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.models.Game;

public class TicTacToe {

    private Game game;
    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;

    protected TicTacToe() {
        this.game = new Game();
        this.startController = new StartController(this.game);
        this.playController = new PlayController(this.game);
        this.resumeController = new ResumeController(this.game);
    }

    void play() {
        do {
            this.startController.control();
            this.playController.control();
        } while (this.resumeController.control());
    }

    public static void main(String[] args) {
        new TicTacToe().play();
    }
}
