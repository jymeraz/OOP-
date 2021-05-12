public class Computer extends Player {
	public String difficulty_level;

	// Constructor.
	public Computer(String difficulty_level) {
		this.difficulty_level = difficulty_level;
		this.placeShip();
		this.throwTorpedo();
	}

	// Print the details of the computer.
	public void printComputer() {
		System.out.println("Difficulty level: " + difficulty_level);
		this.print();
	}
}
