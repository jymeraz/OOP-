import java.util.Scanner;

public class StateMachineBonus {
	public String state;
	public String action;

	// The state machine begins at resting state.
	// Call method to allow user to exit resting state.
	public StateMachineBonus() {
		state = "Resting";
		action = "";
		resting();
	}

	// The current state is first printed.
	// The resting state has two possible options the user can take.
	// Based on the user response, the state will be updated.
	// The method with that state will be called an present additional choice.
	// The user can only exit the buggy in the resting state.
	// The user can only interact with the drill and camera features in the resting
	// state.
	public void resting() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Current state: " + state);
		System.out.println("Pick an action by entering its corresponding number: ");
		System.out.println("\t1. Press right pedal 1 time to accelerate forwards");
		System.out.println("\t2. Hold left pedal for more than 5 seconds to accelerate backwards");
		System.out.println("\t3. Press button 1 for 2 times to interact with the drill");
		System.out.println("\t4. Hold button 1 for 5 seconds to interact with the color camera");
		System.out.println("\t5. Hold button 1 for 10 seconds to interact with the 16-mm camera");
		System.out.println("\tIf you wish to exit, input any other number.");
		int choice = scanner.nextInt();
		System.out.println();
		if (choice == 1) {
			state = "Accelerating Forward";
			drivingForward();
		} else if (choice == 2) {
			state = "Accelerating Backwards";
			drivingBackwards();
		} else if (choice == 3) {
			state = "Drill Feature Off";
			drill();
		} else if (choice == 4) {
			state = "Color Camera";
			camera();
		} else if (choice == 5) {
			state = "16-mm Camera";
			camera();
		} else {
			System.out.println("You chose to exit. Goodbye.");
			System.exit(1);
		}
	}

	// The current state is first printed.
	// The drill can either be turned on or off.
	// Based on the current sub-state, different options are presented.
	// The state is updated based on the users response.
	// The method drill() is called with the updated state.
	// The user can only exit the drill state if the drill is off.
	public void drill() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Current state: " + state);
		if (state.equals("Drill Feature Off")) {
			System.out.println("Pick an action by entering its corresponding number: ");
			System.out.println("\t1. Press button 1 to turn the drill on");
			System.out.println("\t2. Press button 2 to stop interacting with the drill");
			int choice = scanner.nextInt();
			System.out.println();
			if (choice == 1) {
				state = "Drill Feature On";
				drill();
			} else if (choice == 2) {
				state = "Resting";
				resting();
			} else {
				// The state is not updated when the user input is invalid.
				System.out.println("Invalid input.");
				drill();
			}
		} else if (state.equals("Drill Feature On")) {
			System.out.println("Pick an action by entering its corresponding number: ");
			System.out.println("\t1. Press button 1 to turn the drill off");
			int choice = scanner.nextInt();
			System.out.println();
			if (choice == 1) {
				state = "Drill Feature Off";
				drill();
			} else {
				System.out.println("Invalid input.");
				drill();
			}
		}
	}

	// The current state is first printed.
	// There are two sub-states that can each take pictures.
	// Based on the current sub-state, different options are presented.
	// The state is updated based on the users response.
	// The method camera() is called with the updated state.
	// The user can only exit the camera state if no pictures are currently being
	// taken.
	public void camera() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Current state: " + state);
		if (state.equals("Color Camera")) {
			System.out.println("Pick an action by entering its corresponding number: ");
			System.out.println("\t1. Press button 1 to take a picture");
			System.out.println("\t2. Press button 2 to stop interacting with the camera");
			int choice = scanner.nextInt();
			System.out.println();
			if (choice == 1) {
				state = "Take Picture";
				System.out.println("Current state: " + state);
				System.out.println("\tAction: Image is saved\n");
				state = "Color Camera";
				camera();
			} else if (choice == 2) {
				state = "Resting";
				resting();
			} else {
				// The state is not updated when the user input is invalid.
				System.out.println("Invalid input.");
				camera();
			}
		} else if (state.equals("16-mm Camera")) {
			System.out.println("Pick an action by entering its corresponding number: ");
			System.out.println("\t1. Press button 1 to activate the temporizer");
			System.out.println("\t2. Press button 2 to stop interacting with the camera");
			int choice = scanner.nextInt();
			System.out.println();
			if (choice == 1) {
				state = "Activate Temporizer";
				System.out.println("Current state: " + state);
				System.out.println("\tAction: Image is saved\n");
				state = "16-mm Camera";
				camera();
			} else if (choice == 2) {
				state = "Resting";
				resting();
			} else {
				System.out.println("Invalid input.");
				camera();
			}
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
		} else {
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
