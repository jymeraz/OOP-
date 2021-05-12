package state_pattern_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import state.AcceleratingForwards;
import state.ConstantForwardsSpeed;
import state.Context;
import state.DeceleratingForwards;

public class AcceleratingForwards_test {

	@Test
	public void pressRightPedalOnce_test() {
		Context context = new Context();
		AcceleratingForwards startState = new AcceleratingForwards();

		assertSame(startState, startState.pressRightPedalOnce(context));
		assertEquals(startState.toString(), startState.pressRightPedalOnce(context).toString());
		assertTrue(startState.pressRightPedalOnce(context).toString().equals("Accelerating forwards"));

	}

	@Test
	public void pressRightPedalTwice_test() {
		Context context = new Context();
		AcceleratingForwards startState = new AcceleratingForwards();
		DeceleratingForwards newState = new DeceleratingForwards();

		assertSame(newState.getClass(), startState.pressRightPedalTwice(context).getClass());
		assertEquals(newState.toString(), startState.pressRightPedalTwice(context).toString());
		assertTrue(startState.pressRightPedalTwice(context).toString().equals("Decelerating forwards"));

	}

	@Test
	public void holdRightPedalOverFiveSec_test() {
		Context context = new Context();
		AcceleratingForwards startState = new AcceleratingForwards();
		ConstantForwardsSpeed newState = new ConstantForwardsSpeed();

		assertSame(newState.getClass(), startState.holdRightPedalOverFiveSec(context).getClass());
		assertEquals(newState.toString(), startState.holdRightPedalOverFiveSec(context).toString());
		assertTrue(startState.holdRightPedalOverFiveSec(context).toString().equals("Constant forwards speed"));

	}

	@Test
	public void pressLeftPedalOnce_test() {
		Context context = new Context();
		AcceleratingForwards startState = new AcceleratingForwards();

		assertSame(startState, startState.pressLeftPedalOnce(context));
		assertEquals(startState.toString(), startState.pressLeftPedalOnce(context).toString());
		assertTrue(startState.pressLeftPedalOnce(context).toString().equals("Accelerating forwards"));

	}

	@Test
	public void pressLeftPedalTwice_test() {
		Context context = new Context();
		AcceleratingForwards startState = new AcceleratingForwards();

		assertSame(startState, startState.pressLeftPedalTwice(context));
		assertEquals(startState.toString(), startState.pressLeftPedalTwice(context).toString());
		assertTrue(startState.pressLeftPedalTwice(context).toString().equals("Accelerating forwards"));

	}

	@Test
	public void holdLeftPedalOverFiveSec_test() {
		Context context = new Context();
		AcceleratingForwards startState = new AcceleratingForwards();

		assertSame(startState, startState.holdLeftPedalOverFiveSec(context));
		assertEquals(startState.toString(), startState.holdLeftPedalOverFiveSec(context).toString());
		assertTrue(startState.holdLeftPedalOverFiveSec(context).toString().equals("Accelerating forwards"));
	}

	@Test
	public void toString_test() {
		DeceleratingForwards startState = new DeceleratingForwards();

		assertSame("Decelerating forwards", startState.toString());
		assertEquals("decelerating forwards", startState.toString().toLowerCase());
		assertTrue(startState.toString().equals("Decelerating forwards"));
	}

}
