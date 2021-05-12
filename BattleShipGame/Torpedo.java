public class Torpedo {
	public int x_coordinates;
	public int y_coordinates;
	static int num_torpedos;

	// Constructor.
	public Torpedo(int x, int y) {
		x_coordinates = x;
		y_coordinates = y;
		num_torpedos += 1;
	}

	// Add an instance of the torpedo.
	// Check that the multiplicity is not violated.
	public Torpedo add(int x, int y) {
		Torpedo new_torpedo = new Torpedo(x, y);
		if (num_torpedos > 30) {
			System.out.println("Error. Torpedo multiplicity violated.");
		}
		return new_torpedo;
	}

	// Remove a torpedo object.
	// Check that the multiplicity is not violated.
	public void remove() {
		num_torpedos -= 1;
		if (num_torpedos < 1) {
			System.out.println("Error. Torpedo multiplicity violated.");
		}
	}

	// Print the details of the torpedo.
	public void print() {
		System.out.println("x-coordinates: " + x_coordinates);
		System.out.println("y-coordinates: " + y_coordinates);
	}
}
