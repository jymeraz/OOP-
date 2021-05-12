import java.util.Scanner;

public class Geometry {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Prompt the user to enter coordinates.
		System.out.print("Enter coordinates: ");
		String square = scanner.nextLine();
		boolean continueResponse = true;

		// Create a loop to allow the user to enter multiple coordinates until they
		// choose to exit.
		while (continueResponse) {
			String[] inputFormat = new String[5];
			String temp = square;
			int iter = 0;

			// Save the user's response into an array of size 5.
			// The first index contains the contents before the first coordinate.
			// The second index contains the first coordinate.
			// The third index contains the contents between the first and second
			// coordinates.
			// The fourth index contains the second coordinate.
			// The fifth index contains the contents after the second coordinate.
			while (temp.length() > 0) {
				String format = "";
				while (temp.length() > 0 && !Character.isDigit(temp.charAt(0)) && !Character.isLetter(temp.charAt(0))) {
					format += temp.charAt(0);
					temp = temp.substring(1);
				}
				inputFormat[iter] = format;
				iter++;
				if (temp.length() > 0) {
					inputFormat[iter] = String.valueOf(temp.charAt(0));
					temp = temp.substring(1);
					iter++;
				}
			}

			// Convert the user's coordinates to integers.
			int x;
			int y = Integer.parseInt(inputFormat[3]);
			if (Character.isDigit(inputFormat[1].charAt(0))) {
				x = Integer.parseInt(inputFormat[1]);
			} else {
				x = inputFormat[1].toUpperCase().charAt(0) - 65;
			}

			// Print an error statement if the user's inputs were out of bounds.
			if (x < 0 || x > 8 || y < 0 || y > 8) {
				System.out.print(
						"Error. The numbers chosen must be between the inclusive range of 0-8. The letters chosen must be between the inclusive range a-i.\n");
			} else {
				// Call the methods to print the edge adjacent squares, corner adjacent squares,
				// and non adjacent squares.
				edgeAdjacent(inputFormat, x, y);
				cornerAdjacent(inputFormat, x, y);
				notAdjacent(inputFormat, x, y);
			}

			// Prompt the user to enter another coordinate if they choose to continue.
			boolean validResponse = false;
			while (!validResponse) {
				System.out.print("Would you like to try again?(enter yes/no): ");
				String userResponse = scanner.nextLine().toLowerCase();
				if (userResponse.equals("no")) {
					continueResponse = false;
					System.out.print("Thank you. Goodbye.");
					validResponse = true;
				} else if (userResponse.equals("yes")) {
					System.out.print("Enter coordinates: ");
					square = scanner.nextLine();
					validResponse = true;
				} else {
					System.out.print("Invalid Response. ");
				}
			}
		}
		scanner.close();
	}

	// Print the edge adjacent squares in the same format as the user input.
	public static void edgeAdjacent(String[] inputFormat, int x, int y) {
		// Create a new array.
		// Compute and save the the edge adjacent squares.
		int[][] result = new int[4][2];
		result[0][0] = x - 1;
		result[0][1] = y;
		result[1][0] = x;
		result[1][1] = y + 1;
		result[2][0] = x + 1;
		result[2][1] = y;
		result[3][0] = x;
		result[3][1] = y - 1;

		// Print the edge adjacent squares that are within the board size.
		// Print the coordinates in the same format as the user input.
		System.out.print("List of all edge-adjacent squares: ");
		for (int i = 0; i < result.length; i++) {
			if ((result[i][0] >= 0 && result[i][0] < 9) && (result[i][1] >= 0 && result[i][1] < 9)) {
				// Convert the number in the results to a character if the user used a character
				// in their input.
				if (!Character.isDigit(inputFormat[1].charAt(0))) {
					System.out.print(inputFormat[0] + Character.toLowerCase((char) (result[i][0] + 65)) + inputFormat[2]
							+ result[i][1]);
				} else {
					System.out.print(inputFormat[0] + result[i][0] + inputFormat[2] + result[i][1]);
				}
				if (inputFormat[4] != null) {
					System.out.print(inputFormat[4]);
				}
				// Print commas between each coordinate.
				if (i < result.length - 1) {
					System.out.print(", ");
				}
			}
		}
		System.out.println();
	}

	// Print the corner adjacent squares in the same format as the user input.
	public static void cornerAdjacent(String[] inputFormat, int x, int y) {
		// Create a new array.
		// Compute and save the the corner adjacent squares.
		int[][] result = new int[4][2];
		result[0][0] = x - 1;
		result[0][1] = y + 1;
		result[1][0] = x + 1;
		result[1][1] = y + 1;
		result[2][0] = x + 1;
		result[2][1] = y - 1;
		result[3][0] = x - 1;
		result[3][1] = y - 1;

		// Print the corner adjacent squares that are within the board size.
		// Print the coordinates in the same format as the user input.
		System.out.print("List of all corner-adjacent squares: ");
		for (int i = 0; i < result.length; i++) {
			if ((result[i][0] >= 0 && result[i][0] < 9) && (result[i][1] >= 0 && result[i][1] < 9)) {
				// Convert the number in the results to a character if the user used a character
				// in their input.
				if (!Character.isDigit(inputFormat[1].charAt(0))) {
					System.out.print(inputFormat[0] + Character.toLowerCase((char) (result[i][0] + 65)) + inputFormat[2]
							+ result[i][1]);
				} else {
					System.out.print(inputFormat[0] + result[i][0] + inputFormat[2] + result[i][1]);
				}
				if (inputFormat[4] != null) {
					System.out.print(inputFormat[4]);
				}
				// Print commas between each coordinate.
				if (i < result.length - 1) {
					System.out.print(", ");
				}
			}
		}
		System.out.println();
	}

	// Print the non adjacent squares in the same format as the user input.
	public static void notAdjacent(String[] inputFormat, int x, int y) {
		// Iterate through the size of the board and print the coordinates if they are
		// not adjacent to the inputed square.
		System.out.print("List of all non-adjacent squares: ");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				// Check if the coordinates are adjacent to the inputed square.
				if (!(i + 1 == x && j + 1 == y) && !(i + 1 == x && j - 1 == y) && !(i - 1 == x && j + 1 == y)
						&& !(i - 1 == x && j - 1 == y) && !(i + 1 == x && j == y) && !(i - 1 == x && j == y)
						&& !(i == x && j - 1 == y) && !(i == x && j + 1 == y)) {
					if (!Character.isDigit(inputFormat[1].charAt(0))) {
						System.out.print(inputFormat[0] + Character.toLowerCase((char) (i + 65)) + inputFormat[2] + j);
					} else {
						System.out.print(inputFormat[0] + i + inputFormat[2] + j);
					}
					if (inputFormat[4] != null) {
						System.out.print(inputFormat[4]);
					}
					// Print commas between each coordinate.
					if (i < 8 || j < 8) {
						System.out.print(", ");
					}
				}
			}
		}
		System.out.println();
	}
}
