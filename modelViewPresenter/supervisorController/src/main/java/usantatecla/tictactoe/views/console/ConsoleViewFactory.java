package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.ViewFactory;

public class ConsoleViewFactory extends ViewFactory {

    @Override
    public BoardView createBoardView(Game game) {
        return new BoardView(game);
    }

    @Override
    public CoordinateView createCoordinateView() {
        return new CoordinateView();
    }

    @Override
    public PlayerView createPlayerView(Game game) {
        return new PlayerView(game);
    }

    @Override
    public ResumeView createResumeView() {
        return new ResumeView();
    }

    @Override
    public StartView createStartView() {
        return new StartView();
    }

    @Override
    public ErrorView createErrorView() {
        return new ErrorView();
    }

}
