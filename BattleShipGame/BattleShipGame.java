
public class BattleShipGame {

	public static void main(String[] args) {
		// Create a new Game.
		// Print the association of objects that is created from the new game.
		// Print the association of objects that each player has.
		Game game = new Game("Human/Human", "John", "Stacy");
		game.associationList();
		game.player_list[0].associationList();

		// Add objects to try to disrupt the multiplicity.
		// Additional round should not disrupt the multiplicity.
		// Additional players, ships, and torpedos should disrupt the multiplicity.
		game.add("Human/Human", "John", "Stacy");
		game.round_list[0].add();
		game.player_list[0].add();
		game.player_list[0].ship_list[0].add(3, 4);
		game.player_list[0].torpedo_list[0].add(1, 6);
		System.out.println();

		// Remove the objects to try to disrupt the multiplicity.
		// First game removed is the previous game that was created, so multiplicity is
		// not violated.
		// Second game removed disrupts the multiplicity.
		// Player removed disrupts multiplicity.
		// Ship and torpedo removed should not disrupt the multiplicity.
		game.remove();
		game.remove();
		game.player_list[0].remove();
		game.player_list[0].ship_list[0].remove();
		game.player_list[0].ship_list[0].remove();
		game.player_list[0].torpedo_list[0].remove();
		game.player_list[0].torpedo_list[0].remove();
		System.out.println();

		// Throw torpedo from player class.
		// Place ship from player class.
		// Update points from player class.
		game.player_list[0].throwTorpedo();
		game.player_list[0].placeShip();
		game.player_list[0].updatePoints();
		System.out.println();

		// Throw torpedo from round class.
		// Update the status of a ship being hit.
		// View the results.
		game.round_list[0].throwTorpedo();
		game.round_list[0].hitStatus();
		game.round_list[0].viewResults();
		System.out.println();
	}

}
