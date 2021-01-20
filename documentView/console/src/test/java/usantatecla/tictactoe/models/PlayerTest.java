package usantatecla.tictactoe.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.tictactoe.types.Error;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public abstract class PlayerTest {

    protected final Color COLOR = Color.O;

    public abstract PlayerBuilder getPlayerBuilder();


    @Test
    public void testGivenPlayerWhenGetPutTokenErrorThenErrorNULL() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = this.getPlayerBuilder().build();
        assertThat(player.getPutTokenError(coordinate), is(Error.NULL));
    }

    @Test
    public void testGivenPlayerWhenGetPutTokenErrorThenErrorNotEmpty() {
        Player player = this.getPlayerBuilder().rows(
                "   ",
                " O ",
                "   "
        ).build();
        assertThat(player.getPutTokenError(new Coordinate(1, 1)), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenPlayerWhenGetOriginMoveTokenErrorThenErrorNotOwner() {
        Player player = this.getPlayerBuilder().rows(
                "   ",
                " O ",
                "   "
        ).build();
        Player player2 = new PlayerBuilder().color(Color.X).user().build();
        player2.board = player.board;
        assertThat(player2.getOriginMoveTokenError(new Coordinate(1, 1)), is(Error.NOT_OWNER));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenNoError() {
        Player player = this.getPlayerBuilder().rows(
                "   ",
                " O ",
                "   "
        ).build();
        assertThat(player.getTargetMoveTokenError(new Coordinate(1, 1), new Coordinate(0, 0)), is(Error.NULL));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenErrorNotEmpty() {
        Player player = this.getPlayerBuilder().rows(
                "   ",
                " OO",
                "   "
        ).build();
        assertThat(player.getTargetMoveTokenError(new Coordinate(1, 1), new Coordinate(1, 2)), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenPlayerWhenGetTargetMoveTokenErrorThenErrorSameCoordinates() {
        Player player = this.getPlayerBuilder().rows(
                "   ",
                " O ",
                "   "
        ).build();
        assertThat(player.getTargetMoveTokenError(new Coordinate(1, 1), new Coordinate(1, 1)), is(Error.SAME_COORDINATES));
    }

    @Test
    public void testGivenNewPlayerWhenGetTokenThenReturnTheToken() {
        Player player = this.getPlayerBuilder().build();
        assertThat(player.getColor(), is(Color.O));
    }

    @Test
    public void testGivenPlayerWhenMoveThenIsTrue() {
        Player player = this.getPlayerBuilder().rows(
                "OO ",
                "O  ",
                "   "
        ).build();
        Board targetBoard = new BoardBuilder().rows(
                "OO ",
                "   ",
                "O  ").build();
        Coordinate[] coordinates = this.getMovedCoordinates(player.board, targetBoard);
        player = spy(player);
        //doReturn(coordinates[0], coordinates[1]).when(player).getCoordinate(any());
        player.moveToken(coordinates[0], coordinates[1]);
        assertThat(player.board.isEmpty(new Coordinate(1, 0)), is(true));
        assertThat(player.board.isOccupied(new Coordinate(2, 0), Color.O), is(true));
    }

    private Coordinate[] getMovedCoordinates(Board originBoard, Board targetBoard) {
        List<Coordinate> originBoardCoordinates = originBoard.getCoordinates(Color.O);
        List<Coordinate> targetBoardCoordinates = targetBoard.getCoordinates(Color.O);

        return this.getOriginTargetCoordinates(originBoardCoordinates, targetBoardCoordinates);
    }

    private Coordinate[] getOriginTargetCoordinates(List<Coordinate> originBoardCoordinates, List<Coordinate> targetBoardCoordinates) {
        Coordinate[] coordinates = new Coordinate[2];

        for (int i = 0; i < originBoardCoordinates.size(); i++) {
            if (!targetBoardCoordinates.contains(originBoardCoordinates.get(i))) {
                coordinates[0] = originBoardCoordinates.get(i);
            }
            if (!originBoardCoordinates.contains(targetBoardCoordinates.get(i))) {
                coordinates[1] = targetBoardCoordinates.get(i);
            }
        }
        return coordinates;
    }
}