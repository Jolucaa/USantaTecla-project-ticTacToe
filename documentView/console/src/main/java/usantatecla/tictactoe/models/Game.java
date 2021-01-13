package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Error;

public class Game {
    
    private Board board;
    private Turn turn;
    
    public Game() {
        this.reset();
    }
    
    public void reset() {
        this.board = new Board();
        this.turn = new Turn(this.board);
	}

	public void play() {
        this.turn.getActivePlayer().play();
    }

    public Error put(Coordinate coordinate) {
        Error error = this.turn.getActivePlayer().getPutTokenError(coordinate);
        next(error);
        return error;
    }

    public Error move(Coordinate origin, Coordinate target) {
        Error error = this.turn.getActivePlayer().getTargetMoveTokenError(origin, target);
        next(error);
        return error;
    }

    private void next(Error error){
        if (error.isNull() && !this.board.isTicTacToe(this.turn.getActiveColor())){
            this.turn.getNextActivePlayer();
        }
    }

    public boolean isTicTacToe() {
        return this.board.isTicTacToe(this.turn.getActiveColor());
    }

	public Color getColor(Coordinate coordinate) {
		return this.board.getColor(coordinate);
    }
    
    public Color getActiveColor() {
		return this.turn.getActiveColor();
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (board == null) {
            if (other.board != null)
                return false;
        } else if (!board.equals(other.board))
            return false;
        if (turn == null) {
            if (other.turn != null)
                return false;
        } else if (!turn.equals(other.turn))
            return false;
        return true;
    }
}