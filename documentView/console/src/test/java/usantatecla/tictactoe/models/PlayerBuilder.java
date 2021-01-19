package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Color;
import usantatecla.tictactoe.types.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.mockito.Mockito.*;

public class PlayerBuilder {

    private Player player;
    private Color color;
    private Board board;
    private List<String> strings;
    private List<Coordinate> coordinates;

    public PlayerBuilder() {
        this.board = new Board();
        this.strings = new ArrayList<>();
        this.coordinates = new ArrayList<>();
    }

    public PlayerBuilder setColor(Color color) {
        this.color = color;
        return this;
    }

    public PlayerBuilder setTypeUserPlayer() {
        this.player = spy(new UserPlayer(this.color, this.board));
        return this;
    }

    public PlayerBuilder setTypeMachinePlayer() {
        this.player = spy(new MachinePlayer(this.color, this.board));
        return this;
    }

    public PlayerBuilder rows(String... rows) {
        this.strings.clear();
        this.checkRows(rows);
        if(this.coordinates.isEmpty()) {
            if (!this.strings.isEmpty()) {
                this.coordinates = this.readRows();
                this.putCoordinate();
            }
        }else{
            if (!this.strings.isEmpty()) {
                List<Coordinate> coordinates = this.readRows();
                this.moveToken(this.getOriginCoordinate(coordinates),
                        this.getTargetCoordinate(coordinates));
                this.coordinates = coordinates;
            }
        }
        return this;
    }

    private void checkRows(String[] rows) {
        assert rows.length == 3;
        for (String row : rows) {
            assert Pattern.matches("[XO ]{3}", row);
            this.strings.add(row);
        }
    }

    public PlayerBuilder moveToken(Coordinate origin, Coordinate target){
        assert !origin.isNull() && !target.isNull();

        doReturn(origin, target).when(this.player).getCoordinate(any());
        this.player.play();
        return this;
    }

    public Player build() {
        return this.player;
    }

    private List<Coordinate> readRows() {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < this.strings.size(); i++) {
            for (int j = 0; j < this.strings.get(i).length(); j++) {
                if(this.strings.get(i).charAt(j) == this.color.toString().charAt(0)) {
                    coordinates.add(new Coordinate(i, j));
                }
            }
        }
        return coordinates;
    }

    private Coordinate getTargetCoordinate(List<Coordinate> coordinates){
        for(int i=0; i<coordinates.size(); i++){
            if(!this.coordinates.contains(coordinates.get(i))){
                return coordinates.get(i);
            }
        }
        return new Coordinate();
    }

    private Coordinate getOriginCoordinate(List<Coordinate> coordinates) {
        for (int i = 0; i < coordinates.size(); i++) {
            if (!coordinates.contains(this.coordinates.get(i))) {
                return this.coordinates.get(i);
            }
        }
        return new Coordinate();
    }

    private void putCoordinate() {
        assert this.coordinates.size() <= Coordinate.DIMENSION;

        for (int i = 0; i < this.coordinates.size(); i++) {
            this.putToken(this.coordinates.get(i));
        }
    }

    private void putToken(Coordinate coordinate){
        doReturn(coordinate).when(this.player).getCoordinate(any());
        this.player.play();
    }


}
