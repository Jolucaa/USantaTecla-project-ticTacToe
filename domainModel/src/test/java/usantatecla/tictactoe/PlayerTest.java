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
    public void testGivenPlayerWhenMoveThenIsTrue() {//TODO Hacer el move
        Player player = this.getPlayerBuilder().rows(
                "OO ",
                "O  ",
                "   "
        ).build();
        Board board = new BoardBuilder().rows(
                            "OO ",
                            "   ",
                            "O  ").build();
        Coordinate[] coordinates = this.getMovedCoordinates(player.board, board);
        player = spy(player);
        doReturn(coordinates[0], coordinates[1]).when(player).getCoordinate(any());
        player.play();
        assertThat(player.board.isEmpty(new Coordinate(1, 0)), is(true));
        assertThat(player.board.isOccupied(new Coordinate(2, 0), Color.O), is(true));
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

    private Coordinate[] getMovedCoordinates(Board boardPlayer, Board board){
        Coordinate[] coordinates = new Coordinate[2];
            List<Coordinate> coordinates1 = boardPlayer.getCoordinates(Color.O);
            List<Coordinate> coordinates2 = board.getCoordinates(Color.O);

        coordinates[0] = this.getOriginCoordinate(coordinates1, coordinates2);
        coordinates[1] = this.getTargetCoordinate(coordinates1, coordinates2);
            return coordinates;
    }

    private Coordinate getOriginCoordinate(List<Coordinate> coordinates1, List<Coordinate> coordinates2){
        for(int i=0; i<coordinates1.size(); i++){
            if(!coordinates2.contains(coordinates1.get(i))){
                return coordinates1.get(i);
            }
        }
        return new Coordinate();
    }

    private Coordinate getTargetCoordinate(List<Coordinate> coordinates1, List<Coordinate> coordinates2) {
        for (int i = 0; i < coordinates1.size(); i++) {
            if (!coordinates1.contains(coordinates2.get(i))) {
                return coordinates2.get(i);
            }
        }
        return new Coordinate();
    }

}
