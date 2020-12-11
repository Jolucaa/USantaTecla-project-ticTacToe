package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;

class PlayView {

    void interact(PlayController playController) {
        if (playController.isUser()) {
            new PlayMenu(playController).execute();
        } else {
            this.randomPlay(playController);
        }
        new BoardView(playController).write();
    }

    private void randomPlay(PlayController playController) {
        Error error;
        Coordinate target;
        do {
            target = createRandomCoordinate();
            if (!playController.isBoardComplete()) {
                error = playController.put(target);
            } else {
                Coordinate origin = createRandomCoordinate();
                error = playController.move(origin, target);
            }
        } while (!error.isNull());
    }

    public Coordinate createRandomCoordinate() {
        Coordinate coordinate = new Coordinate();
        coordinate.random();
        return coordinate;
    }

}