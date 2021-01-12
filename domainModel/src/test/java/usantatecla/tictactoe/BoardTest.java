package usantatecla.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.MockedStatic;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

public class BoardTest {

    @Test
    public void testGivenEmptyBoardWhenStartThenIsEmpty() {
        Board board = new BoardBuilder().rows(
                "   ",
                "   ",
                "   ").build();
        assertThat(board.isEmpty(new Coordinate(0, 0)), is(true));
        assertThat(board.isEmpty(new Coordinate(2, 2)), is(true));
    }

    @Test
    public void testGivenBoardWhenIsEmptyThenIsFalse() {
        Board board = new BoardBuilder().rows(
                "X  ",
                "   ",
                "O  ").build();
        assertThat(board.isEmpty(new Coordinate(0, 0)), is(false));
        assertThat(board.isEmpty(new Coordinate(2, 0)), is(false));
    }

    @Test
    public void testGivenEmptyBoardWhenCheckIsOccupiedThenIsFalse() {
        Board board = new BoardBuilder().rows(
                "   ",
                "   ",
                "   ").build();
        assertThat(board.isOccupied(new Coordinate(0, 0), Color.X), is(false));
        assertThat(board.isOccupied(new Coordinate(0, 0), Color.O), is(false));
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenIsOccupiedThenIsTrue() {
        Board board = new BoardBuilder().rows(
                "   ",
                "   ",
                "   ").build();
        Color token = Color.O;
        Coordinate coordinate = new Coordinate(0, 0);
        board.put(coordinate, token);
        assertThat(board.isOccupied(coordinate, token), is(true));
    }

    @Test
    public void testGivenBoardWhenMoveXTokenOriginIsEmptyAndTargetIsOccupiedThenIsTrue() {
        Board board = new BoardBuilder().rows(
                "X  ",
                "   ",
                "   ").build();
        Color color = Color.X;
        Coordinate origin = new Coordinate(0, 0);
        Coordinate target = new Coordinate(0, 1);
        board.move(origin, target);
        assertThat(board.isEmpty(origin), is(true));
        assertThat(board.isOccupied(target, color), is(true));
    }

    @Test
    public void testGivenBoardWhenMoveXTokenAndTargetIsOccupiedThenIsAssertion() {
        Board board = new BoardBuilder().rows(
                "XO ",
                "   ",
                "   ").build();
        Coordinate origin = new Coordinate(0, 0);
        Coordinate target = new Coordinate(0, 1);
        Assertions.assertThrows(AssertionError.class, () -> board.move(origin, target));
    }

    @Test
    public void testGivenBoardWhenMoveTokenAndOriginIsEmptyThenIsAssertion() {
        Board board = new BoardBuilder().rows(
                "XO ",
                "   ",
                "   ").build();
        Coordinate origin = new Coordinate(1, 0);
        Coordinate target = new Coordinate(2, 2);
        Assertions.assertThrows(AssertionError.class, () -> board.move(origin, target));
    }

    @Test
    public void testGivenBoardWhenMoveTokenAndOriginIsEqualsTargetThenIsAssertion() {
        Board board = new BoardBuilder().rows(
                "XO ",
                "   ",
                "   ").build();
        Coordinate origin = new Coordinate(0, 0);
        Coordinate target = new Coordinate(0, 0);
        Assertions.assertThrows(AssertionError.class, () -> board.move(origin, target));
    }

    @Test
    public void testGivenBoardWhenIsTicTacToeThenIsFalse() {
        Board board = new BoardBuilder().rows(
                "   ",
                "   ",
                "   ").build();
        assertThat(board.isTicTacToe(Color.O), is(false));
    }

    @Test
    public void testGivenBoardWhenIsTicTacToeThenIsTrue() {
        Board board = new BoardBuilder().rows(
                " X ",
                "OXO",
                " X ").build();
        Color color = Color.X;
        assertThat(board.isTicTacToe(color), is(true));
    }

    @Test
    public void testGivenCompleteBoardAndIsTicTacToeThenIsFalse() {
        Board board = new BoardBuilder().rows(
                "XO ",
                "XO ",
                "OX ").build();
        Color token = Color.O;
        assertThat(board.isTicTacToe(token), is(false));
    }

    @Test
    public void testGivenEmptyBoardWhenWriteThenPrint() {
        Console console = mock(Console.class);
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(console);
            Board board = new BoardBuilder().rows(
                    "   ",
                    "   ",
                    "   ").build();
            board.write();
            verify(console, times(2)).writeln("---------------");
            verify(console, times(Coordinate.DIMENSION*Coordinate.DIMENSION + Coordinate.DIMENSION)).write(" | ");
            verify(console, times(Coordinate.DIMENSION)).writeln();
            verify(console, times(Coordinate.DIMENSION*Coordinate.DIMENSION)).write(" ");
        }
    }

    @Test
    public void testGivenCompleteBoardWhenWriteThenPrintInCorrectOrder() {
        Console console = mock(Console.class);
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(console);
            InOrder colorPrinted = inOrder(console);
            Board board = new BoardBuilder().rows(
                    "X X",
                    "XO ",
                    "O O").build();
            board.write();
            verify(console, times(2)).writeln("---------------");
            verify(console, times(Coordinate.DIMENSION*Coordinate.DIMENSION + Coordinate.DIMENSION)).write(" | ");
            verify(console, times(Coordinate.DIMENSION)).writeln();
            colorPrinted.verify(console).write("X");
            colorPrinted.verify(console).write(" ");
            colorPrinted.verify(console).write("X");
            colorPrinted.verify(console).write("X");
            colorPrinted.verify(console).write("O");
            colorPrinted.verify(console).write(" ");
            colorPrinted.verify(console).write("O");
            colorPrinted.verify(console).write(" ");
            colorPrinted.verify(console).write("O");
        }
    }
}
