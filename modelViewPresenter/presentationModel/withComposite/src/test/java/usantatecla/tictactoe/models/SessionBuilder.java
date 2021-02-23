package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SessionBuilder {
    private Session session;
    private List<String> rows;

    public SessionBuilder() {
        this.rows = new ArrayList<>();
    }

    public SessionBuilder rows(String... rows) {
        assert rows.length == 3;
        for (String row : rows) {
            assert Pattern.matches("[XO ]{3}", row);
            this.rows.add(row);
        }
        return this;
    }

    public Session build() {
        this.session = new Session();
        if (!this.rows.isEmpty()) {
            for (int i = 0; i < this.rows.size(); i++) {
                String string = this.rows.get(i);
                for (int j = 0; j < string.length(); j++) {
                    Color color = this.getColor(string.charAt(j));
                    if(this.getColor(string.charAt(j))!=Color.NULL){
                        if(!this.session.getActiveColor().equals(color)){
                            this.session.next();
                        }
                        this.session.putToken(new Coordinate(i, j));
                    }
                }
            }
        }

        return this.session;
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
