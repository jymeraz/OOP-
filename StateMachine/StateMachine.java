import java.util.Scanner;

public class StateMachine {
	public String state;
	public String action;

	// The state machine begins at resting state.
	// Call method to allow user to exit resting state.
	public StateMachine() {
		state = "Resting";
		action = "";
		resting();
	}

	// The current state is first printed.
	// The resting state has two possible options the user can take.
	// Based on the user response, the state will be updated.
	// The method with that state will be called an present additional choice.
	// The user can only exit the buggy in the resting state.
	public void resting() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Current state: " + state);
		System.out.println("Pick an action by entering its corresponding number: ");
		System.out.println("\t1. Press right pedal 1 time to accelerate forwards");
		System.out.println("\t2. Hold left pedal for more than 5 seconds to accelerate backwards");
		System.out.println("\tIf you wish to exit, input any other number.");
		int choice = scanner.nextInt();
		System.out.println();
		if (choice == 1) {
			state = "Accelerating Forward";
			drivingForward();
		} else if (choice == 2) {
			state = "Accelerating Backwards";
			drivingBackwards();
		} else {
			System.out.println("You chose to exit. Goodbye.");
			System.exit(1);
		}
	}

	// The current state is first printed.
	// Driving forwards includes three sub-states.
	// Based on the current sub-state, different options are presented.
	// The state is updated based on the users response.
	// The method drivingForward() is called with the updated state.
	// The user can only exit the driving forward state to the resting state through
	// the decelerating forward state.
	public void drivingForward() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Current state: " + state);
		if (state.equals("Accelerating Forward")) {
			// Different options are presented to the user.
			System.out.println("Pick an action by entering its corresponding number: ");
			System.out.println("\t1. Press right pedal 2 times to decelerate forwards");
			System.out.println("\t2. Hold right pedal for more than 5 seconds to have constant forward speed");
			int choice = scanner.nextInt();
			System.out.println();
			// Based on the users choice, the state is updated.
			// The method drivingForward() is called again.
			if (choice == 1) {
				state = "Decelerating Forward";
				drivingForward();
			} else if (choice == 2) {
				state = "Constant Forward Speed";
				drivingForward();
			} else {
				// The state is not updated when the user input is invalid.
				System.out.println("Invalid input.");
				drivingForward();
			}
		} else if (state.equals("Decelerating Forward")) {
			// The option to return to the resting state is only presented in the
			// decelerating forward state.
			System.out.println("Pick an action by entering its corresponding number: ");
			System.out.println("\t1. Press right pedal 1 time to accelerate forwards");
			System.out.println("\t2. Hold right pedal for more than 5 seconds to have constant forward speed");
			System.out.println("\t3. Press left pedal 1 time to rest");
			int choice = scanner.nextInt();
			System.out.println();
			if (choice == 1) {
				state = "Accelerating Forward";
				drivingForward();
			} else if (choice == 2) {
				state = "Constant Forward Speed";
				drivingForward();
			} else if (choice == 3) {
				state = "Resting";
				resting();
			} else {
				System.out.println("Invalid input.");
				drivingForward();
			}
		} else if (state.equals("Constant Forward Speed")) {
			System.out.println("Pick an action by entering its corresponding number: ");
			System.out.println("\t1. Press right pedal 1 time to accelerate forwards");
			System.out.println("\t2. Press right pedal 2 times to decelerate forwards");
			int choice = scanner.nextInt();
			System.out.println();
			if (choice == 1) {
				state = "Accelerating Forward";
				drivingForward();
			} else if (choice == 2) {
				state = "Decelerating Forward";
				drivingForward();
			} else {
				System.out.println("Invalid input.");
				drivingForward();
			}
		}
	}

	// The current state is first printed.
	// Driving backwards includes three sub-states.
	// Based on the current sub-state, different options are presented.
	// The state is updated based on the users response.
	// The method drivingBackwards() is called with the updated state.
	// The user can only exit the driving backwards state to the resting state
	// through the decelerating backwards state.
	public void drivingBackwards() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Current state: " + state);
		if (state.equals("Accelerating Backwards")) {
			// Different options are presented to the user.
			System.out.println("Pick an action by entering its corresponding number: ");
			System.out.println("\t1. Press left pedal 2 times to decelerate backwards");
			System.out.println("\t2. Press left pedal 1 time to have constant backwards speed");
			int choice = scanner.nextInt();
			System.out.println();
			// Based on the users choice, the state is updated.
			// The method drivingBackwards() is called again.
			if (choice == 1) {
				state = "Decelerating Backwards";
				drivingBackwards();
			} else if (choice == 2) {
				state = "Constant Backwards Speed";
				drivingBackwards();
			} else {
				// The state is not updated when the user input is invalid.
				System.out.println("Invalid input.");
				drivingBackwards();
			}
		} else if (state.equals("Decelerating Backwards")) {
			System.out.println("Pick an action by entering its corresponding number: ");
			System.out.println("\t1. Hold left pedal for more than 5 seconds to accelerate backwards");
			System.out.println("\t2. Press left pedal 1 time to have constant backwards speed");
			System.out.println("\t3. Press right pedal 1 time to rest");
			int choice = scanner.nextInt();
			System.out.println();
			if (choice == 1) {
				state = "Accelerating Backwards";
				drivingBackwards();
			} else if (choice == 2) {
				state = "Constant Backwards Speed";
				drivingBackwards();
			} else if (choice == 3) {
				// The option to return to the resting state is only presented in the
				// decelerating backwards state.
				state = "Resting";
				resting();
			} else {
				System.out.println("Invalid input.");
				drivingBackwards();
			}
		} else {
			System.out.println("Pick an action by entering its corresponding number: ");
			System.out.println("\t1. Hold left pedal for more than 5 seconds to accelerate backwards");
			System.out.println("\t2. Press left pedal 2 times to decelerate backwards");
			int choice = scanner.nextInt();
			System.out.println();
			if (choice == 1) {
				state = "Accelerating Backwards";
				drivingBackwards();
			} else if (choice == 2) {
				state = "Decelerating Backwards";
				drivingBackwards();
			} else {
				System.out.println("Invalid input.");
				drivingBackwards();
			}
		}
	}
}
