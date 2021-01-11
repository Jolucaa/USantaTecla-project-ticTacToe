package usantatecla.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BoardBuilder {

    private List<String> strings;
    private List<Coordinate> xCoordinates;
    private List<Coordinate> oCoordinates;

    public BoardBuilder() {
        this.strings = new ArrayList<>();
        this.xCoordinates = new ArrayList<>();
        this.oCoordinates = new ArrayList<>();
    }

    public BoardBuilder rows(String... rows) {
        assert rows.length == 3;
        for (String row : rows) {
            assert Pattern.matches("[XO ]{3}", row);
            this.strings.add(row);
        }
        return this;
    }

    public Board build() {
        Board board = new Board();
        board.reset();
        if (this.strings.size() != 0) {
            readRows();
            putCoordinates(board);
        }
        return board;
    }

    private void readRows() {
        for (int i = 0; i < strings.size(); i++) {
            for (int j = 0; j < strings.get(i).length(); j++) {
                setCoordinate(strings.get(i).charAt(j), i, j);
            }
        }
    }

    private void setCoordinate(char token, int row, int column) {
        if (token == 'X') {
            this.xCoordinates.add(new Coordinate(row, column));
        } else if (token == 'O') {
            this.oCoordinates.add(new Coordinate(row, column));
        }
    }

    private void putCoordinates(Board board) {
        assert this.xCoordinates.size() <= this.oCoordinates.size() + 1 &&
                this.oCoordinates.size() <= this.xCoordinates.size();

        for (int i = 0; i < xCoordinates.size(); i++) {
            board.put(xCoordinates.get(i), Color.X);
            if (i < oCoordinates.size()) {
                board.put(oCoordinates.get(i), Color.O);
            }
        }
    }

}
