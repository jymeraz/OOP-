package state_pattern_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import state.AcceleratingBackwards;
import state.AcceleratingForwards;
import state.Context;
import state.Stationary;

public class Stationary_test {

	@Test
	public void pressRightPedalOnce_test() {
		Context context = new Context();
		Stationary startState = new Stationary();
		AcceleratingForwards newState = new AcceleratingForwards();

		assertSame(newState.getClass(), startState.pressRightPedalOnce(context).getClass());
		assertEquals(newState.toString(), startState.pressRightPedalOnce(context).toString());
		assertTrue(startState.pressRightPedalOnce(context).toString().equals("Accelerating forwards"));

	}

	@Test
	public void pressRightPedalTwice_test() {
		Context context = new Context();
		Stationary startState = new Stationary();

		assertSame(startState, startState.pressRightPedalTwice(context));
		assertEquals(startState.toString(), startState.pressRightPedalTwice(context).toString());
		assertTrue(startState.pressRightPedalTwice(context).toString().equals("Stationary"));

	}

	@Test
	public void holdRightPedalOverFiveSec_test() {
		Context context = new Context();
		Stationary startState = new Stationary();

		assertSame(startState, startState.holdRightPedalOverFiveSec(context));
		assertEquals(startState.toString(), startState.holdRightPedalOverFiveSec(context).toString());
		assertTrue(startState.holdRightPedalOverFiveSec(context).toString().equals("Stationary"));

	}

	@Test
	public void pressLeftPedalOnce_test() {
		Context context = new Context();
		Stationary startState = new Stationary();

		assertSame(startState, startState.pressLeftPedalOnce(context));
		assertEquals(startState.toString(), startState.pressLeftPedalOnce(context).toString());
		assertTrue(startState.pressLeftPedalOnce(context).toString().equals("Stationary"));
	}

	@Test
	public void pressLeftPedalTwice_test() {
		Context context = new Context();
		Stationary startState = new Stationary();

		assertSame(startState, startState.pressLeftPedalTwice(context));
		assertEquals(startState.toString(), startState.pressLeftPedalTwice(context).toString());
		assertTrue(startState.pressLeftPedalTwice(context).toString().equals("Stationary"));

	}

	@Test
	public void holdLeftPedalOverFiveSec_test() {
		Context context = new Context();
		Stationary startState = new Stationary();
		AcceleratingBackwards newState = new AcceleratingBackwards();

		assertSame(newState.getClass(), startState.holdLeftPedalOverFiveSec(context).getClass());
		assertEquals(newState.toString(), startState.holdLeftPedalOverFiveSec(context).toString());
		assertTrue(startState.holdLeftPedalOverFiveSec(context).toString().equals("Accelerating backwards"));
	}

	@Test
	public void toString_test() {
		Stationary startState = new Stationary();

		assertSame("Stationary", startState.toString());
		assertEquals("stationary", startState.toString().toLowerCase());
		assertTrue(startState.toString().equals("Stationary"));
	}

}
