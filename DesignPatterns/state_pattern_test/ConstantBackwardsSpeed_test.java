package state_pattern_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import state.AcceleratingBackwards;
import state.ConstantBackwardsSpeed;
import state.Context;
import state.DeceleratingBackwards;

public class ConstantBackwardsSpeed_test {

	@Test
	public void pressRightPedalOnce_test() {
		Context context = new Context();
		ConstantBackwardsSpeed startState = new ConstantBackwardsSpeed();

		assertSame(startState, startState.pressRightPedalOnce(context));
		assertEquals(startState.toString(), startState.pressRightPedalOnce(context).toString());
		assertTrue(startState.pressRightPedalOnce(context).toString().equals("Constant backwards speed"));

	}

	@Test
	public void pressRightPedalTwice_test() {
		Context context = new Context();
		ConstantBackwardsSpeed startState = new ConstantBackwardsSpeed();

		assertSame(startState, startState.pressRightPedalTwice(context));
		assertEquals(startState.toString(), startState.pressRightPedalTwice(context).toString());
		assertTrue(startState.pressRightPedalTwice(context).toString().equals("Constant backwards speed"));

	}

	@Test
	public void holdRightPedalOverFiveSec_test() {
		Context context = new Context();
		ConstantBackwardsSpeed startState = new ConstantBackwardsSpeed();

		assertSame(startState, startState.holdRightPedalOverFiveSec(context));
		assertEquals(startState.toString(), startState.holdRightPedalOverFiveSec(context).toString());
		assertTrue(startState.holdRightPedalOverFiveSec(context).toString().equals("Constant backwards speed"));

	}

	@Test
	public void pressLeftPedalOnce_test() {
		Context context = new Context();
		ConstantBackwardsSpeed startState = new ConstantBackwardsSpeed();

		assertSame(startState, startState.pressLeftPedalOnce(context));
		assertEquals(startState.toString(), startState.pressLeftPedalOnce(context).toString());
		assertTrue(startState.pressLeftPedalOnce(context).toString().equals("Constant backwards speed"));

	}

	@Test
	public void pressLeftPedalTwice_test() {
		Context context = new Context();
		ConstantBackwardsSpeed startState = new ConstantBackwardsSpeed();
		DeceleratingBackwards newState = new DeceleratingBackwards();

		assertSame(newState.getClass(), startState.pressLeftPedalTwice(context).getClass());
		assertEquals(newState.toString(), startState.pressLeftPedalTwice(context).toString());
		assertTrue(startState.pressLeftPedalTwice(context).toString().equals("Decelerating backwards"));

	}

	@Test
	public void holdLeftPedalOverFiveSec_test() {
		Context context = new Context();
		ConstantBackwardsSpeed startState = new ConstantBackwardsSpeed();
		AcceleratingBackwards newState = new AcceleratingBackwards();

		assertSame(newState.getClass(), startState.holdLeftPedalOverFiveSec(context).getClass());
		assertEquals(newState.toString(), startState.holdLeftPedalOverFiveSec(context).toString());
		assertTrue(startState.holdLeftPedalOverFiveSec(context).toString().equals("Accelerating backwards"));
	}

	@Test
	public void toString_test() {
		ConstantBackwardsSpeed startState = new ConstantBackwardsSpeed();

		assertSame("Constant backwards speed", startState.toString());
		assertEquals("constant backwards speed", startState.toString().toLowerCase());
		assertTrue(startState.toString().equals("Constant backwards speed"));
	}

}
