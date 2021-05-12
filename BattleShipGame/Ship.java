public class Ship {
	public int size;
	public int value;
	static int num_ships;

	// Constructor.
	public Ship(int size, int value) {
		this.size = size;
		this.value = value;
		num_ships += 1;
	}

	// Add an instance of the ship.
	// Check that the multiplicity is not violated.
	public Ship add(int size, int value) {
		Ship new_ship = new Ship(size, value);
		if (num_ships > 6) {
			System.out.println("Error. Ship multiplicity violated.");
		}
		return new_ship;
	}

	// Remove a ship object.
	// Check that the multiplicity is not violated.
	public void remove() {
		num_ships -= 1;
		if (num_ships < 1) {
			System.out.println("Error. Ship multiplicity violated.");
		}
	}

	// Print the details of the ship.
	public void print() {
		System.out.println("Size: " + size);
		System.out.println("Value: " + value);
	}
}
