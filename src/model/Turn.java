package model;

public class Turn {
	
	private char actualLetter;
	private int actualNumber;
	private boolean state;
	
	private TurnType turntype;

	public Turn(char actualLetter, int actualNumber) {
		this.actualLetter = actualLetter;
		this.actualNumber = actualNumber;
		state = false;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public char getActualLetter() {
		return actualLetter;
	}

	public void setActualLetter(char actualLetter) {
		this.actualLetter = actualLetter;
	}

	public int getActualNumber() {
		return actualNumber;
	}

	public void setActualNumber(int actualNumber) {
		this.actualNumber = actualNumber;
	}


	public TurnType getTurntype() {
		return turntype;
	}

	public void setTurntype(TurnType turntype) {
		this.turntype = turntype;
	}

	public String getName() {
		String msg = actualLetter + Integer.toString(actualNumber);
		return msg;
	}
}