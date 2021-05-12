package main;

/**
 * A class implementing the state machine for the lunar rover. This class keeps
 * track of the current state of the rover in addition to the change in state
 * caused by specific events. Three different methods are used to separate the
 * states of resting, driving forwards, and driving backwards.
 *
 * @author Janeth Meraz
 * @version 1.0 (11/03/20)
 * @since version 0.5
 */

public class StateMachine {
	/**
	 * The current state of the state machine. This attribute allows us to keeps
	 * track of the current state, which facilitates the action of updating it when
	 * given an event.
	 */
	public String state;

	/**
	 * Sole constructor.
	 */
	public StateMachine() {
		state = "Resting";
	}

	/**
	 * Returns the updated state given that the current state in this method is the
	 * Resting state. The state is updated based on a given event.
	 *
	 * @param event the event taking place
	 * @return the updated state of the state machine; the previous state if it is
	 *         not successfully updated
	 */
	public String resting(String event) {
		if (event.equals("Press right pedal 1 time")) {
			state = "Accelerating Forward";
		} else if (event.equals("Hold left pedal for more than 5 seconds")) {
			state = "Accelerating Backwards";
		}
		return state;
	}

	/**
	 * Returns the updated state given that the current state in this method is a
	 * variation of driving forwards. These variations include Accelerating Forward,
	 * Decelerating Forward, and Constant Forward Speed. Based on the variation and
	 * the event, the current state is updated.
	 *
	 * @param event the event taking place
	 * @return the updated state of the state machine; the previous state if it is
	 *         not successfully updated
	 */
	public String drivingForward(String event) {
		if (state.equals("Accelerating Forward")) {
			if (event.equals("Press right pedal 2 times")) {
				state = "Decelerating Forward";
			} else if (event.equals("Hold right pedal for more than 5 seconds")) {
				state = "Constant Forward Speed";
			}
		} else if (state.equals("Decelerating Forward")) {
			if (event.equals("Press right pedal 1 time")) {
				state = "Accelerating Forward";
			} else if (event.equals("Hold right pedal for more than 5 seconds")) {
				state = "Constant Forward Speed";
			} else if (event.equals("Press left pedal 1 time")) {
				state = "Resting";
			}
		} else {
			if (event.equals("Press right pedal 1 time")) {
				state = "Accelerating Forward";
			} else if (event.equals("Press right pedal 2 times")) {
				state = "Decelerating Forward";
			}
		}
		return state;
	}

	/**
	 * Returns the updated state given that the current state in this method is a
	 * variation of driving backwards. These variations include Accelerating
	 * Backwards, Decelerating Backwards, and Constant Backwards Speed. Based on the
	 * variation and the event, the current state is updated.
	 *
	 * @param event the event taking place
	 * @return the updated state of the state machine; the previous state if it is
	 *         not successfully updated
	 */
	public String drivingBackwards(String event) {
		if (state.equals("Accelerating Backwards")) {
			if (event.equals("Press left pedal 2 times")) {
				state = "Decelerating Backwards";
			} else if (event.equals("Press left pedal 1 time")) {
				state = "Constant Backwards Speed";
			}
		} else if (state.equals("Decelerating Backwards")) {
			if (event.equals("Hold left pedal for more than 5 seconds")) {
				state = "Accelerating Backwards";
			} else if (event.equals("Press left pedal 1 time")) {
				state = "Constant Backwards Speed";
			} else if (event.equals("Press right pedal 1 time")) {
				state = "Resting";
			}
		} else {
			if (event.equals("Hold left pedal for more than 5 seconds")) {
				state = "Accelerating Backwards";
			} else if (event.equals("Press left pedal 2 times")) {
				state = "Decelerating Backwards";
			}
		}
		return state;
	}
}
