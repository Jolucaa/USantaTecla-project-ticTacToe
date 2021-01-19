package usantatecla.tictactoe;

import static org.mockito.Mockito.*;

public class PlayerBuilder {

    private Color color;
    private String[] rows;
    private boolean isUser;

    public PlayerBuilder() {
        this.rows = new String[]{
                "   ",
                "   ",
                "   "};
    }

    public PlayerBuilder color(Color color) {
        this.color = color;
        return this;
    }

    public PlayerBuilder user() {
        this.isUser = true;
        return this;
    }

    public PlayerBuilder machine() {
        this.isUser = false;
        return this;
    }

    public PlayerBuilder rows(String... rows) {
        this.rows = rows;
        return this;
    }

    public Player build() {
        Board board = new BoardBuilder().rows(this.rows).build();
        Player player;
        if (this.isUser) {
            player = new UserPlayer(this.color, board);
        } else {
            player = new MachinePlayer(this.color, board);
        }
        player = spy(player);
        return player;
    }


}
