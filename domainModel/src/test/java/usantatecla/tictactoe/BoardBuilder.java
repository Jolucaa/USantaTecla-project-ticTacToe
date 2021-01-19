package usantatecla.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BoardBuilder {

    private final List<String> strings;

    public BoardBuilder() {
        this.strings = new ArrayList<>();
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
        if (!this.strings.isEmpty()) {
            for (int i = 0; i < this.strings.size(); i++) {
                String string = this.strings.get(i);
                for (int j = 0; j < string.length(); j++) {
                    board.put(new Coordinate(i, j), this.getColor(string.charAt(j)));
                }
            }
        }
        return board;
    }

    private Color getColor(char character) {
        Color result = Color.NULL;
        for (int i = 0; i < Color.values().length - 1; i++) {
            Color color = Color.values()[i];
            if (color.name().equals("" + character)) {
                result = color;
            }
        }
        return result;
    }

}
