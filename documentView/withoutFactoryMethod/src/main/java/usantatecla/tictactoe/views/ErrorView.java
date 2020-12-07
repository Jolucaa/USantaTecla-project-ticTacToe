package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Error;

public abstract class ErrorView {

    public static final String[] MESSAGES = {
            "The square is not empty",
            "There is not a token of yours",
            "The origin and target squares are the same",
            "The coordinates are wrong",
            "Wrong number of users"};

    protected Error error;

    public ErrorView(Error error) {
        this.error = error;
    }

}
