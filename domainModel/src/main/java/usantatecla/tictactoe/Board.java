package usantatecla.tictactoe;

import java.util.ArrayList;
import java.util.List;

import usantatecla.utils.Direction;

class Board {

	private Color[][] colors;

	Board() {
		this.colors = new Color[Coordinate.DIMENSION][Coordinate.DIMENSION];
		this.reset();
	}

	void reset() {
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				this.colors[i][j] = Color.NULL;
			}
		}
	}

	void put(Coordinate coordinate, Color color) {
		assert !coordinate.isNull();
		// TODO Nuevo assert para verificar que no se puede hacer un put cuando ya hay 3 colores
		assert (!color.isNull()&&
				this.getCoordinates(color).size()<coordinate.getDimension());
		this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
	}

	void move(Coordinate origin, Coordinate target) {
		assert !origin.isNull() && !this.isEmpty(origin);
		assert !target.isNull() && this.isEmpty(target);
		assert !origin.equals(target);

		final Color color = this.getColor(origin);
		this.remove(origin);
		this.put(target, color);
	}

	private void remove(Coordinate coordinate) {
		this.put(coordinate, Color.NULL);
	}

	private Color getColor(Coordinate coordinate) {
		assert !coordinate.isNull();

		return this.colors[coordinate.getRow()][coordinate.getColumn()];
	}

	boolean isOccupied(Coordinate coordinate, Color color) {
		return this.getColor(coordinate) == color;
	}

	boolean isEmpty(Coordinate coordinate) {
		return this.isOccupied(coordinate, Color.NULL);
	}

	boolean isTicTacToe(Color color) {
		assert !color.isNull();

		List<Direction> directions = this.getDirections(color);
		if (directions.size() < Coordinate.DIMENSION - 1) {
			return false;
		}
		//TODO Coordinate.DIMENSION -> En el caso de que haya dos elementos
		// en la lista siempre está comparando con 3
		for (int i = 0; i < directions.size() - 1; i++) {
			if (directions.get(i) != directions.get(i + 1)) {
				return false;
			}
		}
		return !directions.get(0).isNull();
	}

	private List<Direction> getDirections(Color color) {
		assert !color.isNull();

		List<Direction> directions = new ArrayList<Direction>();
		List<Coordinate> coordinates = this.getCoordinates(color);
		//TODO aqui
		if(!coordinates.isEmpty()){
			for (int i = 0; i < coordinates.size() - 1; i++) {
				directions.add(coordinates.get(i).getDirection(coordinates.get(i + 1)));
			}
		}
		return directions;
	}

	private List<Coordinate> getCoordinates(Color color) {
		assert !color.isNull();

		List<Coordinate> coordinates = new ArrayList<Coordinate>();
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.getColor(new Coordinate(i,j)) == color) {
					coordinates.add(new Coordinate(i, j));
				}
			}
		}
		return coordinates;
	}

	void write() {
		Message.HORIZONTAL_LINE.writeln();
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			Message.VERTICAL_LINE.write();
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				this.getColor(new Coordinate(i, j)).write();
				Message.VERTICAL_LINE.write();
			}
		}
		Message.HORIZONTAL_LINE.writeln();
	}

}
