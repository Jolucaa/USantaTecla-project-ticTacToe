package usantatecla.tictactoe.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Error;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PlayControllerTest {

    private PlayController playController;

    @BeforeEach
    void before() {
        this.playController = new PlayController(new Game());
    }

    @Test
    void testGivenValidCoordinateWhenIsValidCoordinateThenIsNullError() {
        assertThat(this.playController.isValidCoordinate(new int[]{0, 0}), is(Error.NULL));
    }

    @Test
    void testGivenInvalidRowCoordinateWhenIsValidCoordinateThenIsNotValidError() {
        assertThat(this.playController.isValidCoordinate(new int[]{7, 1}), is(Error.NOT_VALID));
    }

    @Test
    void testGivenInvalidColumnCoordinateWhenIsValidCoordinateThenIsNotValidError() {
        assertThat(this.playController.isValidCoordinate(new int[]{2, -3}), is(Error.NOT_VALID));
    }

    @Test
    void testGivenInvalidRowAndColumnCoordinateWhenIsValidCoordinateThenIsNotValidError() {
        assertThat(this.playController.isValidCoordinate(new int[]{7, 8}), is(Error.NOT_VALID));
    }

    @Test
    void testGivenNewPlayControllerWhenGetTwoRandomCoordinatesThenCoordinatesAreNotEquals() {
        int[] coordinateA = this.playController.getRandomCoordinate();
        int[] coordinateB = this.playController.getRandomCoordinate();
        assertThat(coordinateA.equals(coordinateB), is(false));
    }

    @Test
    void testGivenNewPlayControllerWhenGetRandomCoordinateThenCoordinateIsValid() {
        assertThat(this.playController.isValidCoordinate(this.playController.getRandomCoordinate()), is(Error.NULL));
    }

}