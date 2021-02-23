package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;

class Memento {

    private Color activeColor;
    private char[] boardColors;

    Memento(Board board, Turn turn) {
        this.boardColors = board.toCharacterArray();
        this.activeColor = turn.getActiveColor();
    }

    Board getBoard() {
        Board board = new Board();
        int colorsCount = 0;
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                board.putToken(new Coordinate(i, j), Color.get(this.boardColors[colorsCount++]));
            }
        }
        return board;
    }

    Turn getTurn(Board board) {
        Turn turn = new Turn(board);
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                Color color = board.getColor(coordinate);
                if (!color.isNull()) {
                    this.setTurn(turn, color);
                    turn.putToken(coordinate);
                }
            }
        }
        this.setTurn(turn, this.activeColor);
        return turn;
    }

    private void setTurn(Turn turn, Color color) {
        if (turn.getActiveColor() != color) {
            turn.next();
        }
    }

}
