
package defaultpac;

public class Move {
	/*
	 * Implementing the Object Oriented style by creating this sub classes for the primary classes
	 * such as Board, ComouterPlayer, and etc. 
	 */
	
	public int i;
	public int j;
	public int score;

	// Asscociates this.i to equate to i and this.j to eqaute to j
	public Move(final int i, final int j) {
		this.i = i;
		this.j = j;
	}

	// Passes through the score
	public Move(final int score) {
		this.score = score;
	}

	// Move which passes through i, j, and the score
	public Move(final int i, final int j, final int score) {
		this.i = i;
		this.j = j;
		this.score = score;
	}
}
