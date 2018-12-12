
package defaultpac;

import java.util.ArrayList;

public class ComputerPlayer extends Player {
	/*
	 * THIS CLASS IS THE MAIN CLASS WHICH INCLUDES THE MINIMAX 
	 * ALGORITHM WITH ALPHA BETA PRUNING. PLEASE REFER TO THE HARDCOPY HANDOUT
	 * GIVEN OR THE PDF IN THE GOOGLE FOLDER.
	 */
	public static final int ID = 0;

	public static final char SYMBOL = 'X';

	public ComputerPlayer() {
		super(ComputerPlayer.ID);
	}

	public Move makeMove(final Board board) {
		final Move move = computeBestMove(board, Player.COMPUTER);
		board.makeMove(move.i, move.j, Player.COMPUTER);
		return move;
	}

	// Gets the AI symbol which is X
	@Override
	public char getSymbol() {
		return ComputerPlayer.SYMBOL;
	}

	/*
	 * This is the minimax recursive function. 
	 * REFER to the Handout given for further explanation.
	 */
	Move computeBestMove(final Board board, final int player) {
		final int winner = board.gameOver();

		/*
		 * This is the evaluation function which gives 
		 * +10 for the AI Win, -10 for a loss, and 0 for a draw
		 */
		if (winner == Board.COMPUTER)
			return new Move(10);
		else if (winner == Board.HUMAN)
			return new Move(-10);
		else if (winner == Board.DRAW)
			return new Move(0);

		// Moves stored in the ArrayList
		final ArrayList<Move> moves = new ArrayList<Move>();

		/* 
		 * Minimax (recursive) at level of depth for maximizing or minimizing player
       		with alpha-beta cut-off. Return int[3] of {score, row, col}  
		 */
		 
		// Nested for loop which goes through the board to determine best possible 
		// move for the AI to place. Checks all the empty squares since the Human is playing
		// first. 
		
		/*
		 * Minimax Search Algorithm is an adaption to the sorting algorithms learned from class
		 * rather than sorting it searches, in this case to find the most ideal position for the AI
		 * to play. Since it is nested for loop it's Big O Notation is O(n^2) however, since it is not sorting
		 * a huge array, there is less of a time delay.
		 */
		for (int i = 0; i < board.getSize(); ++i)
			for (int j = 0; j < board.getSize(); j++)
				if (board.squareIsEmpty(i, j)) {
					final Move move = new Move(i, j);
					
					// Make a move
					board.setSquare(i, j, player);

					if (player == Player.COMPUTER)
						move.score = computeBestMove(board, Player.HUMAN).score;
					else
						move.score = computeBestMove(board, Player.COMPUTER).score;

					// Reset the move
					board.setSquare(i, j, Board.EMPTY_VAL);
					moves.add(move);
				}

		int bestMove = 0;
		
		// Minimax Function considering all
		// the possible ways the game can go and returns
		// the value of the board
		if (player == Player.COMPUTER) {
			// Find maximum score
			int bestScore = -1000000;
			for (int i = 0; i < moves.size(); ++i)
				// This is what determines which move is better and allows for a better path to victory
				// This is explained better in the hardcopy document
				if (moves.get(i).score > bestScore) {
					bestMove = i;
					bestScore = moves.get(i).score;
				}
		} else {
			// Find minimum score
			int bestScore = 1000000;
			for (int i = 0; i < moves.size(); ++i)
				if (moves.get(i).score < bestScore) {
					bestMove = i;
					bestScore = moves.get(i).score;
				}
		}

		return moves.get(bestMove);
	}

	@Override
	public String toString() {
		return "Computer";
	}

	@Override
	public int getID() {
		return ComputerPlayer.ID;
	}
}
