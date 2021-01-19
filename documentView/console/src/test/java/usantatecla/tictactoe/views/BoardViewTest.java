package usantatecla.tictactoe.views;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import usantatecla.tictactoe.models.*;
import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;
import usantatecla.utils.views.Console;

import java.util.regex.Pattern;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BoardViewTest {

    private static final int BOARD_DIMENSION = Coordinate.DIMENSION * Coordinate.DIMENSION;

    @Mock
    private Game game;

    @InjectMocks
    private BoardView boardView;

    @Test
    public void testGivenCompleteBoardWhenWriteThenPrintInCorrectOrder() {
        Console console = mock(Console.class);
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(console);
            InOrder colorPrinted = inOrder(console);
            Color[] colors = this.getBoardColors(
                    "X X"+
                    "XO "+
                    "O O"
            );
            OngoingStubbing<Color> stubbing = when(this.game.getColor(any(Coordinate.class)));
            for(int i = 0; i< colors.length; i++){
                stubbing = stubbing.thenReturn(colors[i]);
            }
            this.boardView.write(this.game);
            verify(console, times(2)).writeln("---------------");
            verify(console, times(BoardViewTest.BOARD_DIMENSION + Coordinate.DIMENSION)).write(" | ");
            verify(console, times(Coordinate.DIMENSION)).writeln();
            for(int i=0;i<colors.length;i++){
                colorPrinted.verify(console).write(this.colorToString(colors[i]));
            }
        }
    }

    @Test
    public void testGivenEmptyBoardWhenWriteThenPrint() {
        Console console = mock(Console.class);
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(console);
            when(this.game.getColor(any(Coordinate.class))).thenReturn(Color.NULL);
            this.boardView.write(this.game);
            verify(console, times(2)).writeln("---------------");
            verify(console, times(BoardViewTest.BOARD_DIMENSION + Coordinate.DIMENSION)).write(" | ");
            verify(console, times(Coordinate.DIMENSION)).writeln();
            verify(console, times(BoardViewTest.BOARD_DIMENSION)).write(" ");
        }
    }

    private Color[] getBoardColors(String board){
        assert board.length() == BoardViewTest.BOARD_DIMENSION;
        assert Pattern.matches("[XO ]{9}", board);
        Color[] colors = new Color[BoardViewTest.BOARD_DIMENSION];
        for (int i = 0; i < BoardViewTest.BOARD_DIMENSION; i++) {
            if(board.charAt(i) == 'X'){
                colors[i] = Color.X;
            }else if(board.charAt(i) == 'O'){
                colors[i] = Color.O;
            }else{
                colors[i] = Color.NULL;
            }
        }
        return colors;
    }

    private String colorToString(Color color){ //TODO VER SI PONER EN EL MODELO DE COLOR
        if(color==Color.X){
            return "X";
        }else if(color==Color.O){
            return "O";
        }else{
            return " ";
        }
    }

}
