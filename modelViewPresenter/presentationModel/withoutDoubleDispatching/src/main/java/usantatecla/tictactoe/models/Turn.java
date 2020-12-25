package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.Token;

public class Turn {

    public static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private final Board board;
    private int activePlayer;
    private int users;

    Turn(Board board) {
        assert board != null;

        this.board = board;
    }

    void setUsers(int users) {
        this.users = users;
        this.board.reset();
        this.players = new Player[Turn.NUMBER_PLAYERS];
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            this.players[i] = new Player(Token.values()[i], board);
        }
        this.activePlayer = 0;
    }

    void next() {
        this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
    }

    boolean isUser() {
        return this.users == 2 || this.users == 1 && this.activePlayer == 0;
    }

    Error put(Coordinate coordinate) {
        return this.getPlayer().put(coordinate);
    }

    private Player getPlayer() {
        return this.players[this.activePlayer];
    }

    Error move(Coordinate origin, Coordinate target) {
        return this.getPlayer().move(origin, target);
    }

    Token getToken() {
        return this.getPlayer().getToken();
    }

}
