public class Human extends Player {
	public String name;

	// Constructor.
	public Human(String name) {
		this.name = name;
		this.placeShip();
		this.throwTorpedo();
	}

	// Print the details of the human.
	public void printHuman() {
		System.out.println("Name: " + name);
		this.print();
	}
}
