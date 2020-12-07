package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.Message;
import usantatecla.tictactoe.views.WithGameView;
import usantatecla.utils.YesNoDialog;

class ResumeView extends WithGameView {

    public ResumeView(Game game) {
        super(game);
    }

    boolean interact() {
        boolean newGame = new YesNoDialog().read(Message.RESUME.getMessage());
        if (newGame) {
            this.game.reset();
        }
        return newGame;
    }

}
