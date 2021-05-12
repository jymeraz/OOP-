public class Game {
	public int start_time;
	public int end_time;
	public String game_type;
	// Keep track of the number of games and the associations.
	static int num_games;
	public Game[] game_list = new Game[1];
	public Player[] player_list = new Player[2];
	public Round[] round_list = new Round[1];

	// Constructor.
	// Creates instance of Player and Rounds.
	public Game(String type, String player1, String player2) {
		num_games += 1;
		Round new_round = new Round();
		round_list[0] = new_round;
		this.game_type = type;

		// Create players based on type of Game.
		if (type.equals("Human/Human")) {
			Human new_player1 = new Human(player1);
			Human new_player2 = new Human(player2);
			player_list[0] = new_player1;
			player_list[1] = new_player2;
		} else {
			Human new_player1 = new Human(player1);
			Computer new_player2 = new Computer(player2);
			player_list[0] = new_player1;
			player_list[1] = new_player2;
		}
	}

	// Return true if all players have ships and torpedos.
	public boolean continueGame(int player1_ships, int player2_ships, int player1_torpedos, int player2_torpedos) {
		System.out.println("Checking if players still have ships and torpedos.");
		return true;
	}

	// Return the results of the game.
	public String overallResults(int player1_ships, int player2_ships, int player1_torpedos, int player2_torpedos) {
		System.out.println("Printing results: win, lose, tie");
		return "";
	}

	// Add an instance of the Game.
	// Check that the multiplicity is not violated.
	public void add(String type, String player1, String player2) {
		Game new_game = new Game(type, player1, player2);
		if (num_games > 1) {
			System.out.println("Error. Game multiplicity violated.");
		} else {
			game_list[0] = new_game;
		}
	}

	// Remove a game object.
	// Check that the multiplicity is not violated.
	public void remove() {
		game_list[0] = null;
		num_games -= 1;
		if (num_games < 1) {
			System.out.println("Error. Game multiplicity violated.");
		}
	}

	// Print the details of the game.
	public void print() {
		System.out.println("Game type: " + game_type);
		System.out.println("Start time: " + start_time);
	}

	// Print all the objects participating in the association.
	public void associationList() {
		System.out.println("Object: Game");
		this.print();
		System.out.println();
		System.out.println("Object: Player");
		for (int i = 0; i < player_list.length; i++) {
			System.out.println("Player " + (i + 1));
			player_list[i].print();
			System.out.println();
		}
		System.out.println("Object: Round");
		for (int i = 0; i < round_list.length; i++) {
			round_list[i].print();
		}
		System.out.println();
	}
}
