package usantatecla.tictactoe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.Console;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public abstract class PlayerTest {

    @Mock
    Console console;

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
                " X ",
                "   "
        ).build();
        assertThat(player.getOriginMoveTokenError(new Coordinate(1, 1)), is(Error.NOT_OWNER));
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
        Coordinate origin = this.getOriginCoordinate(player.board, targetBoard);
        Coordinate target = this.getTargetCoordinate(player.board, targetBoard);
        player = spy(player);
        doReturn(origin, target).when(player).getCoordinate(any());
        player.play();
        assertThat(player.board.isEmpty(new Coordinate(1, 0)), is(true));
        assertThat(player.board.isOccupied(new Coordinate(2, 0), Color.O), is(true));
    }

    private Coordinate getOriginCoordinate(Board originBoard, Board targetBoard) {
        List<Coordinate> originBoardCoordinates = originBoard.getCoordinates(Color.O);
        List<Coordinate> targetBoardCoordinates = targetBoard.getCoordinates(Color.O);
        Coordinate origin = new Coordinate();
        for (int i = 0; i < originBoardCoordinates.size(); i++) {
            if (!targetBoardCoordinates.contains(originBoardCoordinates.get(i))) {
                origin = originBoardCoordinates.get(i);
            }
        }
        return origin;
    }

    private Coordinate getTargetCoordinate(Board originBoard, Board targetBoard) {
        List<Coordinate> originBoardCoordinates = originBoard.getCoordinates(Color.O);
        List<Coordinate> targetBoardCoordinates = targetBoard.getCoordinates(Color.O);
        Coordinate target = new Coordinate();
        for (int i = 0; i < originBoardCoordinates.size(); i++) {
            if (!originBoardCoordinates.contains(targetBoardCoordinates.get(i))) {
                target = targetBoardCoordinates.get(i);
            }
        }
        return target;
    }

    @Test
    public void testGivenPlayerWhenWriteWinnerThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Player player = this.getPlayerBuilder().build();
            player.writeWinner();
            verify(this.console).writeln(Color.O.toString() + " player: You win!!! :-)");
        }
    }

}
