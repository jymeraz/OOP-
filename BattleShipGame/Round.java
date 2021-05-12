public class Round {
	public boolean is_hit;
	static int num_round;

	// Constructor.
	public Round() {
		num_round += 1;
		if (num_round == 1) {
			throwTorpedo();
		} else {
			Torpedo.num_torpedos -= 1;
		}
	}

	// Throw torpedo in each round.
	public void throwTorpedo() {
		System.out.println("Threw torpedo.");
	}

	// Update whether a ship was hit or not.
	public void hitStatus() {
		System.out.println("Update hit status.");
	}

	// Print whether a ship was hit or not.
	public boolean viewResults() {
		System.out.println("Viewing results.");
		return is_hit;
	}

	// Add an instance of a round.
	public Round add() {
		Round new_round = new Round();
		return new_round;
	}

	// Remove an instance of a round.
	public void remove() {
		num_round -= 1;
		if (num_round < 0) {
			System.out.println("Error. Round multiplicity violated.");
		}
	}

	// Print the details of the round.
	public void print() {
		System.out.println("Hit ship: " + is_hit);
	}
}
