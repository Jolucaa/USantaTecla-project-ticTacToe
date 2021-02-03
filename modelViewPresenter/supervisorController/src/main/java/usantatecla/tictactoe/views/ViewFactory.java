package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;

public abstract class ViewFactory {

    public abstract BoardView createBoardView(Game game);
    public abstract CoordinateView createCoordinateView();
    public abstract PlayerView createPlayerView(Game game);
    public abstract ResumeView createResumeView();
    public abstract StartView createStartView();
    public abstract ErrorView createErrorView();

}
