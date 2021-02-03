package usantatecla.tictactoe.models;

import java.util.List;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;

public class GameBuilder {

    private String[] rows;
    private Game game;

    public GameBuilder() {
        this.rows = new String[]{
            "   ",
            "   ",
            "   "};
    }

    public GameBuilder rows(String... rows) {
        this.rows = rows;
        return this;
    }

    public Game build() {
        this.game = new Game();
        this.buildBoard();
        return game;
    }

    private void buildBoard() {
        Board board = new BoardBuilder().rows(this.rows).build();
        this.putTokens(board, Color.X);
        this.game.next();
        this.putTokens(board, Color.O);
    }

    private void putTokens(Board board, Color color) {
        List<Coordinate> coordinates = board.getCoordinates(color);
        while (coordinates.size() > 0) {
            Coordinate coordinate = coordinates.remove(0);
            this.game.putToken(coordinate);
        }
    }
    
}
