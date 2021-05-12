public class Player {
	public int torpedos;
	public int ships;
	public int num_points;
	// Keep track of the number of games and the associations.
	static int num_players;
	static Player[] player_list = new Player[2];
	public Ship[] ship_list = new Ship[6];
	public Torpedo[] torpedo_list = new Torpedo[30];

	// Constructor
	public Player() {
		num_players += 1;
	}

	// Place the ships at the start of the game.
	public void placeShip() {
		Ship.num_ships = 0;
		Ship new_ship = new Ship(2, 1);
		ship_list[0] = new_ship;
		for (int i = 1; i < 6; i++) {
			ship_list[i] = new_ship.add(2, 1);
			System.out.println("Ship " + i + " placed.");
		}
		ships = Ship.num_ships;
	}

	// Initialize the torpedos for each player.
	public void throwTorpedo() {
		Torpedo.num_torpedos = 0;
		Torpedo new_torpedo = new Torpedo(1, 2);
		torpedo_list[0] = new_torpedo;
		for (int i = 1; i < 30; i++) {
			torpedo_list[i] = new_torpedo.add(1, 2);
		}
		torpedos = Torpedo.num_torpedos;
	}

	// Update the players points.
	public void updatePoints() {
		num_points += 1;
		System.out.println("Points updated.");
	}

	// Add an instance of the Player.
	// Check that the multiplicity is not violated.
	public void add() {
		Player new_player = new Player();
		if (num_players > 2) {
			System.out.println("Error. Player multiplicity violated.");
		} else {
			for (int i = 0; i < 2; i++) {
				if (player_list[i] == null) {
					player_list[i] = new_player;
				}
			}
		}
	}

	// Remove a player object.
	// Check that the multiplicity is not violated.
	public void remove() {
		num_players -= 1;
		if (!(num_players == 2)) {
			System.out.println("Error. Player multiplicity violated.");
		}
	}

	// Print the details of the player.
	public void print() {
		System.out.println("Number of ships: " + this.ships);
		System.out.println("Number of torpedos: " + this.torpedos);
	}

	// Print all the objects participating in the association.
	public void associationList() {
		System.out.println("Object: Player");
		this.print();
		System.out.println();
		System.out.println("Object: Ship");
		for (int i = 0; i < ship_list.length; i++) {
			System.out.println("Ship " + (i + 1));
			ship_list[i].print();
			System.out.println();
		}
		System.out.println("Object: Torpedo");
		for (int i = 0; i < torpedo_list.length; i++) {
			System.out.println("Torpedo " + (i + 1));
			torpedo_list[i].print();
			System.out.println();
		}
	}
}
