
package defaultpac;

public class Board {
	
	/*
	 * This is the board class which is basically setting up and linking up the recruive minimax function
	 * altogether. There are the methods of clearing the board, associating the AI and the Human, the primary one
	 * of checking if the game is over. 
	 */
	
	// Basic Global Variables created
	public static final int COMPUTER = 0;
	public static final int HUMAN = 1;

	public static final int ROWS = 3;
	public static final int COLS = 3;
	public static final int EMPTY_VAL = -1;
	public static final int DRAW = -2;

	// Setting up the board in a 2D Array
	public int[][] squares = new int[Board.ROWS][Board.COLS];

	public ComputerPlayer ai;
	public HumanPlayer human;

	// Passing AI and Human through the Board, calling from the ComputerPlayer and HumanPlayer classes
	// incorporating Object Oriented & Inheritance.
	public Board(final ComputerPlayer ai, final HumanPlayer human) {
		this.ai = ai;
		this.human = human;

		clearBoard();
	}

	// Just a clear board method which clears board.
	public void clearBoard() {
		for (int i = 0; i < Board.ROWS; ++i)
			for (int j = 0; j < Board.COLS; ++j)
				squares[i][j] = Board.EMPTY_VAL;
	}

	// Gets the position of each square through 2D array
	public int getSquare(final int i, final int j) {
		return squares[i][j];
	}

	public void setSquare(final int i, final int j, final int player) {
		squares[i][j] = player;
	}

	public boolean squareIsEmpty(final int i, final int j) {
		return (squares[i][j] == -1);
	}

	// Going to be used for the checker if the game is over
	public boolean makeMove(final int i, final int j, final int player) {
		if (squares[i][j] != -1)
			return false;

		squares[i][j] = player;

		return true;
	}

	public int getSize() {
		return Board.ROWS;
	}

	public int Empty() {
		return Board.EMPTY_VAL;
	}

	// Ability to print the Board to console can be called upon whenever
	public void printToConsole() {
		System.out.println("Board: ");
		for (int i = 0; i < Board.ROWS; ++i) {
			for (int j = 0; j < Board.COLS; j++)
				System.out.print(squares[i][j] + " ");

			System.out.println();
		}
	}

	/*
	 * This is the algorithm which justifies if a game is over. The 4 ways are 
	 * 3 in a ROW, COLUMN, LEFT DIAGONAL, and RIGHT DIAGONAL
	 */
	public int gameOver() {
		
		   // Rows
		/*
		 *  There is a for loop which goes through the Row checker because if you think of the board,
		 *  there are 3 ROWS, to test if there is a 3 in a row. It iterates through the board 3 times since 3 Rows 
		 *  and 3 Columns
		 */
		for (int i = 0; i < Board.ROWS; ++i)
			// Checks eacH position on the GRID 
			if ((getSquare(i, 0) != -1) && (getSquare(i, 1) != -1) && (getSquare(i, 0) == getSquare(i, 1))
					&& (getSquare(i, 1) == getSquare(i, 2)))
				// Justifies if the Human or the AI has won
				if (getSquare(i, 0) == Board.COMPUTER) 
					return Board.COMPUTER;
				else
					return Board.HUMAN;

		// Cols
		/*
		 * This is the same as the method above however, the check is now for Column so vertical check
		 * so that means that the getSquare for each checker is reversed as comapred to the one of the ROWS
		 */
		for (int i = 0; i < Board.COLS; ++i)
			if ((getSquare(0, i) != -1) && (getSquare(1, i) != -1) && (getSquare(0, i) == getSquare(1, i))
					&& (getSquare(1, i) == getSquare(2, i)))
				if (getSquare(0, i) == Board.COMPUTER)
					return Board.COMPUTER;
				else
					return Board.HUMAN; 

		// Left Diagonal
		/*
		 * This is checking if there is a Left Diagonal match which validates both from bottom to top or 
		 * vice versa.
		 */
		
		// calling back the getSquare method above to check the specific index using the 2D array
		if ((getSquare(0, 0) != -1) && (getSquare(1, 1) != -1) && (getSquare(0, 0) == getSquare(1, 1))
				&& (getSquare(1, 1) == getSquare(2, 2)))
			if (getSquare(0, 0) == Board.COMPUTER)
				
				return Board.COMPUTER;
			else
				return Board.HUMAN;

		// Right Diagonal
		
		/*
		 * This is the checking for the right diagonal and is just opposite to the left diagonal except
		 * that it starts from a different index on the Grid.
		 */
		if ((getSquare(0, 2) != -1) && (getSquare(1, 1) != -1) && (getSquare(0, 2) == getSquare(1, 1))
				&& (getSquare(1, 1) == getSquare(2, 0)))
			if (getSquare(0, 2) == Board.COMPUTER)
				return Board.COMPUTER;
			else
				return Board.HUMAN;

		boolean draw = true;

		// Check for draw
		for (int i = 0; i < Board.ROWS; ++i) {
			for (int j = 0; j < Board.COLS; j++)
				if (squares[i][j] == -1) {
					draw = false;
					break;
				}

			if (draw == false)
				break;
		}
		// Another way of writing the if statement with the ?
		// Just say draw is true 
		return (draw == true) ? Board.DRAW : Board.EMPTY_VAL;
	}
}
