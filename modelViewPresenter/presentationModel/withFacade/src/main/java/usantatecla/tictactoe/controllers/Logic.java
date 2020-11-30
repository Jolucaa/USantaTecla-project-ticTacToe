package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.Token;

public class Logic {

    private Game game;
    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;

    public Logic() {
        this.game = new Game();
        this.startController = new StartController(this.game);
        this.playController = new PlayController(this.game);
        this.resumeController = new ResumeController(this.game);
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

    public Error isValidCoordinate(int[] coordinate) {
        return this.playController.isValidCoordinate(coordinate);
    }

    public int[] getRandomCoordinate() {
        return this.playController.getRandomCoordinate();
    }

    public Error put(int[] coordinate) {
        return this.playController.put(coordinate);
    }

    public Error move(int[] origin, int[] target) {
        return this.playController.move(origin, target);
    }

    public Token getToken(Coordinate coordinate) {
        return this.playController.getToken(coordinate);
    }

    public void reset() {
        this.resumeController.reset();
    }

}
