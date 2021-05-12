package state_pattern_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import state.AcceleratingForwards;
import state.ConstantForwardsSpeed;
import state.Context;
import state.DeceleratingForwards;

public class ConstantForwardsSpeed_test {

	@Test
	public void pressRightPedalOnce_test() {
		Context context = new Context();
		ConstantForwardsSpeed startState = new ConstantForwardsSpeed();
		AcceleratingForwards newState = new AcceleratingForwards();

		assertSame(newState.getClass(), startState.pressRightPedalOnce(context).getClass());
		assertEquals(newState.toString(), startState.pressRightPedalOnce(context).toString());
		assertTrue(startState.pressRightPedalOnce(context).toString().equals("Accelerating forwards"));

	}

	@Test
	public void pressRightPedalTwice_test() {
		Context context = new Context();
		ConstantForwardsSpeed startState = new ConstantForwardsSpeed();
		DeceleratingForwards newState = new DeceleratingForwards();

		assertSame(newState.getClass(), startState.pressRightPedalTwice(context).getClass());
		assertEquals(newState.toString(), startState.pressRightPedalTwice(context).toString());
		assertTrue(startState.pressRightPedalTwice(context).toString().equals("Decelerating forwards"));

	}

	@Test
	public void holdRightPedalOverFiveSec_test() {
		Context context = new Context();
		ConstantForwardsSpeed startState = new ConstantForwardsSpeed();

		assertSame(startState, startState.holdRightPedalOverFiveSec(context));
		assertEquals(startState.toString(), startState.holdRightPedalOverFiveSec(context).toString());
		assertTrue(startState.holdRightPedalOverFiveSec(context).toString().equals("Constant forwards speed"));

	}

	@Test
	public void pressLeftPedalOnce_test() {
		Context context = new Context();
		ConstantForwardsSpeed startState = new ConstantForwardsSpeed();

		assertSame(startState, startState.pressLeftPedalOnce(context));
		assertEquals(startState.toString(), startState.pressLeftPedalOnce(context).toString());
		assertTrue(startState.pressLeftPedalOnce(context).toString().equals("Constant forwards speed"));

	}

	@Test
	public void pressLeftPedalTwice_test() {
		Context context = new Context();
		ConstantForwardsSpeed startState = new ConstantForwardsSpeed();

		assertSame(startState, startState.pressLeftPedalTwice(context));
		assertEquals(startState.toString(), startState.pressLeftPedalTwice(context).toString());
		assertTrue(startState.pressLeftPedalTwice(context).toString().equals("Constant forwards speed"));

	}

	@Test
	public void holdLeftPedalOverFiveSec_test() {
		Context context = new Context();
		ConstantForwardsSpeed startState = new ConstantForwardsSpeed();

		assertSame(startState, startState.holdLeftPedalOverFiveSec(context));
		assertEquals(startState.toString(), startState.holdLeftPedalOverFiveSec(context).toString());
		assertTrue(startState.holdLeftPedalOverFiveSec(context).toString().equals("Constant forwards speed"));
	}

	@Test
	public void toString_test() {
		ConstantForwardsSpeed startState = new ConstantForwardsSpeed();

		assertSame("Constant forwards speed", startState.toString());
		assertEquals("constant forwards speed", startState.toString().toLowerCase());
		assertTrue(startState.toString().equals("Constant forwards speed"));
	}

}
