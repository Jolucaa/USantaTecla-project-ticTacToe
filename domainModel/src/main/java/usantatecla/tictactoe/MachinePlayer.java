package usantatecla.tictactoe;

class MachinePlayer extends Player {

	MachinePlayer(Color color, Board board) {		
		super(color, board);
	}

	protected Coordinate getCoordinate(Message message){
		Coordinate coordinate = new Coordinate();
		coordinate.random(); // TODO ¿Hacer método estático para dar directamente coordenada random?
		return coordinate;
	}	
	
}
