package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.Token;

import java.util.Arrays;

public class Turn {

    public static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private Board board;
    private int activePlayer;
    private int users;

    Turn(Board board) {
        assert board != null;

        this.board = board;
    }

    public Turn(Turn turn, Board board) {
        this.players = new Player[Turn.NUMBER_PLAYERS];
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            this.players[i] = turn.players[i].copy(board);
        }
        this.board = board;
        this.activePlayer = turn.activePlayer;
        this.users = turn.users;
    }

    public Turn copy(Board board) {
        return new Turn(this, board);
    }

    void setUsers(int users) {
        this.users = users;
        this.players = new Player[Turn.NUMBER_PLAYERS];
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            this.players[i] = new Player(Token.get(i), board);
        }
        this.activePlayer = 0;
    }

    void set(int activePlayer) {
        this.activePlayer = activePlayer;
    }

    int getActivePlayer() {
        return this.activePlayer;
    }

    void next() {
        this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
    }

    int getUsers() {
        return this.users;
    }

    boolean isUser() {
        return this.users == 2 || this.users == 1 && this.activePlayer == 0;
    }

    Error put(Coordinate coordinate) {
        return this.getPlayer().put(coordinate);
    }

    Player getPlayer() {
        return this.players[this.activePlayer];
    }

    Error move(Coordinate origin, Coordinate target) {
        return this.getPlayer().move(origin, target);
    }

    Token getToken() {
        return this.getPlayer().getToken();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Turn other = (Turn) obj;
        if (activePlayer != other.activePlayer)
            return false;
        if (board == null) {
            if (other.board != null)
                return false;
        } else if (!board.equals(other.board))
            return false;
        if (!Arrays.equals(players, other.players))
            return false;
        if (users != other.users)
            return false;
        return true;
    }

}