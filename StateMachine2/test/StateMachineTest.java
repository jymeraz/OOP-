package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.StateMachine;

public class StateMachineTest {

	@Test
	public void resting_test() {
		StateMachine state_machine = new StateMachine();

		assertEquals("Accelerating Forward", state_machine.resting("Press right pedal 1 time"));

		state_machine.state = "Resting";
		assertTrue(state_machine.resting("Hold left pedal for more than 5 seconds").equals("Accelerating Backwards"));

		state_machine.state = "Resting";
		assertFalse(state_machine.resting("Press left pedal 1 time").equals("Accelerating Forward"));
	}

	@Test
	public void drivingForward_test() {
		StateMachine state_machine = new StateMachine();

		state_machine.state = "Accelerating Forward";
		assertEquals("Decelerating Forward", state_machine.drivingForward("Press right pedal 2 times"));

		state_machine.state = "Accelerating Forward";
		assertTrue(state_machine.drivingForward("Hold right pedal for more than 5 seconds")
				.equals("Constant Forward Speed"));

		state_machine.state = "Accelerating Forward";
		assertFalse(state_machine.drivingForward("Press right pedal 1 time").equals("Decelerating Forward"));

		state_machine.state = "Decelerating Forward";
		assertEquals("Accelerating Forward", state_machine.drivingForward("Press right pedal 1 time"));

		state_machine.state = "Decelerating Forward";
		assertTrue(state_machine.drivingForward("Hold right pedal for more than 5 seconds")
				.equals("Constant Forward Speed"));

		state_machine.state = "Decelerating Forward";
		assertFalse(state_machine.drivingForward("Press left pedal 1 time").equals("Constant Forward Speed"));

		state_machine.state = "Decelerating Forward";
		assertEquals("Decelerating Forward", state_machine.drivingForward("Press left pedal 2 times"));

		state_machine.state = "Constant Forward Speed";
		assertEquals("Accelerating Forward", state_machine.drivingForward("Press right pedal 1 time"));

		state_machine.state = "Constant Forward Speed";
		assertTrue(state_machine.drivingForward("Press right pedal 2 times").equals("Decelerating Forward"));

		state_machine.state = "Constant Forward Speed";
		assertFalse(state_machine.drivingForward("Press left pedal 2 times").equals("Decelerating Forward"));
	}

	@Test
	public void drivingBackwards_test() {
		StateMachine state_machine = new StateMachine();

		state_machine.state = "Accelerating Backwards";
		assertEquals("Decelerating Backwards", state_machine.drivingBackwards("Press left pedal 2 times"));

		state_machine.state = "Accelerating Backwards";
		assertTrue(state_machine.drivingBackwards("Press left pedal 1 time").equals("Constant Backwards Speed"));

		state_machine.state = "Accelerating Backwards";
		assertFalse(state_machine.drivingBackwards("Press right pedal 1 time").equals("Constant Backwards Speed"));

		state_machine.state = "Decelerating Backwards";
		assertEquals("Accelerating Backwards",
				state_machine.drivingBackwards("Hold left pedal for more than 5 seconds"));

		state_machine.state = "Decelerating Backwards";
		assertTrue(state_machine.drivingBackwards("Press left pedal 1 time").equals("Constant Backwards Speed"));

		state_machine.state = "Decelerating Backwards";
		assertFalse(state_machine.drivingBackwards("Press right pedal 1 time").equals("Accelerating Backwards"));

		state_machine.state = "Decelerating Backwards";
		assertEquals("Decelerating Backwards", state_machine.drivingBackwards("Press left pedal 2 times"));

		state_machine.state = "Constant Backwards Speed";
		assertEquals("Accelerating Backwards",
				state_machine.drivingBackwards("Hold left pedal for more than 5 seconds"));

		state_machine.state = "Constant Backwards Speed";
		assertTrue(state_machine.drivingBackwards("Press left pedal 2 times").equals("Decelerating Backwards"));

		state_machine.state = "Constant Backwards Speed";
		assertFalse(state_machine.drivingBackwards("Press left pedal 1 time").equals("Resting"));
	}

}
