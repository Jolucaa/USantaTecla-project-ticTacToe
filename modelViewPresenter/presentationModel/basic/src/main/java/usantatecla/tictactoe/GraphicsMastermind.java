package usantatecla.tictactoe;

import usantatecla.tictactoe.views.graphics.GraphicsView;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;

class GraphicsMastermind extends TicTacToe{

    @Override
    protected GraphicsView createView(StartController startController, PlayController playController, ResumeController resumeController) {
        return new GraphicsView(startController, playController, resumeController);
    }

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }
    
}
