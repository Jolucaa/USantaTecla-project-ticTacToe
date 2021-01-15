package usantatecla.tictactoe.types;


public enum Error {

	NOT_EMPTY("The square is not empty"),
	NOT_OWNER("There is not a token of yours"),
	SAME_COORDINATES("The origin and target squares are the same"),
	WRONG_COORDINATES("The coordinates are wrong"),
	NULL;

	private String message;

	Error(){
	}

	Error(String message){
		this.message = message;
	}

	public boolean isNull() {
		return this == Error.NULL;
	}

	@Override
	public String toString() {
		return this.message;
	}
}
