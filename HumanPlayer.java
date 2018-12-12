package defaultpac;

public class HumanPlayer extends Player {
	/*
	 * This is the the class for the Human Player
	 * it of course doesnt require AI since your the one 
	 * inputting a position. This class primary consists of boolean, int, and character passing
	 * methods which are interlinked with the other classes.
	 */
	
	public String playerName = "Rohan";

	public static final int ID = 1;
	
	// Human symbol is O
	public static final char SYMBOL = 'O';

	public HumanPlayer() {
		super(HumanPlayer.ID);
	}

	// To make a move which is valid is checking if the square is empty
	// which calls squareIsEmpty methody through i and j. Checks all values
	// through the grid. 
	public boolean makeMove(final Board board, final int i, final int j) {
		if (!board.squareIsEmpty(i, j))
			return false;

		// Set position
		board.setSquare(i, j, Player.HUMAN);
		return true;
	}

	
	// The remaining methods below are similar to the methods from the ComputerPlayer class
	// however these are just for the Human. 
	@Override
	public char getSymbol() {
		return HumanPlayer.SYMBOL;
	}

	@Override
	public String toString() {
		return playerName;
	}

	@Override
	public int getID() {
		return HumanPlayer.ID;
	}
}
