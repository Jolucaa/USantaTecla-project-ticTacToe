package usantatecla.tictactoe.models;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GameBuilder {
    private List<String> strings;
    private Integer users;

    public GameBuilder() {
        this.strings = new ArrayList<String>();
    }

    public GameBuilder numberUsers(int users){
        assert users<=Turn.NUMBER_PLAYERS && users>=0;
        this.users = users;
        return this;
    }

    public GameBuilder rows(String... rows) {
        assert rows.length == 3;
        for (String row : rows) {
            assert Pattern.matches("[XO ]{3}", row);
            this.strings.add(row);
        }
        return this;
    }

    public Game build(){
        Game game = new Game();
        if(this.users==null){
            game.setUsers(0);
        }
        if(this.strings.size()!=0){
            for(int i=0;i<this.strings.size();i++){
                //this.setRow(i, game);
            }
        }
        return game;
    }

    /*private void setRow(int row,Game game){
        if(game.getToken())
    } */

}
