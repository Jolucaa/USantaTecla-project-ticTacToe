package usantatecla.tictactoe.models;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SessionBuilder {

    private int users;
    private final List<String> strings;
    private final List<Coordinate> xCoordinates;
    private final List<Coordinate> oCoordinates;

    public SessionBuilder() {
        this.users = 0;
        this.strings = new ArrayList<>();
        this.xCoordinates = new ArrayList<>();
        this.oCoordinates = new ArrayList<>();
    }

    public SessionBuilder users(int users) {
        assert users <= Turn.NUMBER_PLAYERS && users >= 0;
        this.users = users;
        return this;
    }

    public SessionBuilder rows(String... rows) {
        assert rows.length == 3;
        for (String row : rows) {
            assert Pattern.matches("[XO ]{3}", row);
            this.strings.add(row);
        }
        return this;
    }

    Session build() {
        Session session = new Session();
        session.setUsers(this.users);
        if (this.strings.size() != 0) {
            readRows();
            putCoordinates(session);
        }
        return session;
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

    private void putCoordinates(Session session) {
        assert this.xCoordinates.size() <= this.oCoordinates.size() + 1 &&
                this.oCoordinates.size() <= this.xCoordinates.size();

        for (int i = 0; i < xCoordinates.size(); i++) {
            session.put(xCoordinates.get(i));
            if (i < oCoordinates.size()) {
                session.put(oCoordinates.get(i));
            }
        }
    }

}
