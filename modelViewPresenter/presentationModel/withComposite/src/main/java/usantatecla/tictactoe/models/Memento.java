package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Token;

class Memento {

    private int users;
    private int activeTurn;
    private char[] boardTokens;

    public Memento(Game game) {
        this.users = game.getUsers();
        this.activeTurn = game.getActive();
        this.boardTokens = game.getBoardCharacterArray();
    }

    Board getBoard() {
        Board board = new Board();
        int tokensCount = 0;
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                board.put(new Coordinate(i, j), Token.parse(boardTokens[tokensCount++]));
            }
        }
        return board;
    }

    Turn getTurn() {
        Turn turn = new Turn(this.getBoard());
        turn.setUsers(this.users);
        turn.set(this.activeTurn);
        return turn;
    }

}
