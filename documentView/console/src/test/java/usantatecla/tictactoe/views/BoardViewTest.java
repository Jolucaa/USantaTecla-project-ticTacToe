package usantatecla.tictactoe.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.*;
import usantatecla.tictactoe.types.Color;
import usantatecla.utils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class BoardViewTest {

    @Mock
    private Game game;

    @InjectMocks
    private BoardView boardView;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    public void testGivenCompleteBoardWhenWriteThenPrintInCorrectOrder() { //TODO Reducir tamanyo
        Console console = mock(Console.class);
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(console);
            InOrder colorPrinted = inOrder(console);
            String[] board = {
                    "X X",
                    "XO ",
                    "O O"
            };
            Color[] colors = this.getBoardColors(board);
            when(this.game.getColor(any(Coordinate.class))).thenReturn(
                    colors[0],colors[1],colors[2],
                    colors[3],colors[4],colors[5],
                    colors[6],colors[7],colors[8]);
            this.boardView.write();
            verify(console, times(2)).writeln("---------------");
            verify(console, times(Coordinate.DIMENSION*Coordinate.DIMENSION + Coordinate.DIMENSION)).write(" | ");
            verify(console, times(Coordinate.DIMENSION)).writeln();
            for(int i=0;i<colors.length;i++){
                if(colors[i]==Color.X){
                    colorPrinted.verify(console).write("X");
                }else if(colors[i]==Color.O){
                    colorPrinted.verify(console).write("O");
                }else{
                    colorPrinted.verify(console).write(" ");
                }
            }
        }
    }

    @Test
    public void testGivenEmptyBoardWhenWriteThenPrint() { //TODO CON O SIN USAR METODO PRIVADO
        Console console = mock(Console.class);
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(console);
            /*Board board = new BoardBuilder().rows(
                    "   ",
                    "   ",
                    "   ").build();*/
            when(this.game.getColor(any(Coordinate.class))).thenReturn(Color.NULL);
            this.boardView.write();
            verify(console, times(2)).writeln("---------------");
            verify(console, times(Coordinate.DIMENSION*Coordinate.DIMENSION + Coordinate.DIMENSION)).write(" | ");
            verify(console, times(Coordinate.DIMENSION)).writeln();
            verify(console, times(Coordinate.DIMENSION*Coordinate.DIMENSION)).write(" ");
        }
    }

    private Color[] getBoardColors(String[] board){ //TODO REDUCIR TAMANYO
        assert board.length == 3;
        List<String> strings = new ArrayList<>();
        Color[] colors = new Color[Coordinate.DIMENSION*Coordinate.DIMENSION];
        for (String row : board) {
            assert Pattern.matches("[XO ]{3}", row);
            strings.add(row);
        }
        int cont=0;
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                if(strings.get(i).charAt(j) == 'X'){
                    colors[cont] = Color.X;
                }else if(strings.get(i).charAt(j) == 'O'){
                    colors[cont] = Color.O;
                }else{
                    colors[cont] = Color.NULL;
                }
                cont++;
            }
        }
        return colors;
    }


}
