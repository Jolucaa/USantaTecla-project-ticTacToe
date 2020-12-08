package usantatecla.tictactoe;

import usantatecla.tictactoe.views.graphics.GraphicView;

public class GraphicsTicTacToe extends TicTacToe {
	
	@Override
	protected GraphicView createView(){
		return new GraphicView();
	}

	public static void main(String[] args) {
		new GraphicsTicTacToe().play();
	}

}