package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.Token;

public class Logic {

    private final StartController startController;
    private final PlayController playController;
    private final ResumeController resumeController;

    public Logic() {
        Game game = new Game();
        this.startController = new StartController(game);
        this.playController = new PlayController(game);
        this.resumeController = new ResumeController(game);
    }

    public int getMaxPlayers() {
        return this.startController.getMaxPlayers();
    }

    public void setUsers(int users) {
        this.startController.setUsers(users);
    }

    public Token getToken() {
        return this.playController.getToken();
    }

    public boolean isBoardComplete() {
        return this.playController.isBoardComplete();
    }

    public boolean isTicTacToe() {
        return this.playController.isTicTacToe();
    }

    public boolean isUser() {
        return this.playController.isUser();
    }

    public Error isValidCoordinate(Coordinate coordinate) {
        return this.playController.isValidCoordinate(coordinate);
    }

    public Error put(Coordinate coordinate) {
        return this.playController.put(coordinate);
    }

    public Error move(Coordinate origin, Coordinate target) {
        return this.playController.move(origin, target);
    }

    public Token getToken(Coordinate coordinate) {
        return this.playController.getToken(coordinate);
    }

    public void reset() {
        this.resumeController.reset();
    }

}
