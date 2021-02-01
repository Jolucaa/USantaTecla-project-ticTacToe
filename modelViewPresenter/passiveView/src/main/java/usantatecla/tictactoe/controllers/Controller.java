package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.views.console.BoardView;
import usantatecla.tictactoe.views.console.ColorView;

public abstract class Controller {

    protected Game game;

    Controller(Game game) {
        this.game = game;
    }

    void writeBoard() {
        BoardView boardView = new BoardView();
        boardView.writeHorizontalLine();
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            boardView.writeVerticalLine();
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                new ColorView().write(this.game.getColor(new Coordinate(i, j)));
                boardView.writeVerticalLine();
            }
            boardView.writeln();
        }
        boardView.writeHorizontalLine();
    }

}
