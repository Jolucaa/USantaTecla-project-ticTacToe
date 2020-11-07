package usantatecla.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import usantatecla.utils.Direction;

public class CoordinateTest {

    private Coordinate coordinate00;
    private Coordinate coordinate01;
    private Coordinate coordinate11;
    private Coordinate coordinate02;
    private Coordinate coordinate12;

    @BeforeEach
    void before() {
        this.coordinate00 = new Coordinate(0, 0);
        this.coordinate01 = new Coordinate(0, 1);
        this.coordinate11 = new Coordinate(1, 1);
        this.coordinate02 = new Coordinate(0, 2);
        this.coordinate12 = new Coordinate(1, 2);
    }

    @Test
    public void testGivenNewCoordinatesWhenCompareCoordinates00And01ThenIsHorizontal() {
        assertThat(this.coordinate00.getDirection(this.coordinate01), is(Direction.HORIZONTAL));
    }

    @Test
    public void testGivenNewCoordinatesWhenCompareCoordinates01And11ThenIsVertical() {
        assertThat(this.coordinate01.getDirection(this.coordinate11), is(Direction.VERTICAL));
    }

    @Test
    public void testGivenNewCoordinatesWhenCompareCoordinates00And11ThenIsMainDiagonal() {
        assertThat(this.coordinate00.getDirection(this.coordinate11), is(Direction.MAIN_DIAGONAL));
    }

    @Test
    public void testGivenNewCoordinatesWhenCompareCoordinates02And11ThenIsInverseDiagonal() {
        assertThat(this.coordinate02.getDirection(this.coordinate11), is(Direction.INVERSE_DIAGONAL));
    }

    @Test
    public void testGivenNewCoordinatesWhenCompareCoordinates00And12ThenDirectionIsNull() {
        assertThat(this.coordinate00.getDirection(this.coordinate12), is(Direction.NULL));
    }

}
