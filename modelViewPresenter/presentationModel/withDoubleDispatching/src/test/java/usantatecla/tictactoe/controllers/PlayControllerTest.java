package usantatecla.tictactoe.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;
import usantatecla.tictactoe.types.Error;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PlayControllerTest {

    private PlayController playController;

    @BeforeEach
    void before() {
        this.playController = new PlayController(new Game(), new State());
    }

    @Test
    void testGivenValidCoordinateWhenIsValidCoordinateThenIsNullError() {
        assertThat(this.playController.isValidCoordinate(new Coordinate(0, 0)), is(Error.NULL));
    }

    @Test
    void testGivenInvalidRowCoordinateWhenIsValidCoordinateThenIsNotValidError() {
        assertThat(this.playController.isValidCoordinate(new Coordinate(7, 1)), is(Error.NOT_VALID));
    }

    @Test
    void testGivenInvalidColumnCoordinateWhenIsValidCoordinateThenIsNotValidError() {
        assertThat(this.playController.isValidCoordinate(new Coordinate(2, -3)), is(Error.NOT_VALID));
    }

    @Test
    void testGivenInvalidRowAndColumnCoordinateWhenIsValidCoordinateThenIsNotValidError() {
        assertThat(this.playController.isValidCoordinate(new Coordinate(7, 8)), is(Error.NOT_VALID));
    }

}