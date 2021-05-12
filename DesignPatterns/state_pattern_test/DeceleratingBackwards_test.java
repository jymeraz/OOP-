package state_pattern_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import state.AcceleratingBackwards;
import state.ConstantBackwardsSpeed;
import state.Context;
import state.DeceleratingBackwards;
import state.Stationary;

public class DeceleratingBackwards_test {

	@Test
	public void pressRightPedalOnce_test() {
		Context context = new Context();
		DeceleratingBackwards startState = new DeceleratingBackwards();
		Stationary newState = new Stationary();

		assertSame(newState.getClass(), startState.pressRightPedalOnce(context).getClass());
		assertEquals(newState.toString(), startState.pressRightPedalOnce(context).toString());
		assertTrue(startState.pressRightPedalOnce(context).toString().equals("Stationary"));

	}

	@Test
	public void pressRightPedalTwice_test() {
		Context context = new Context();
		DeceleratingBackwards startState = new DeceleratingBackwards();

		assertSame(startState, startState.pressRightPedalTwice(context));
		assertEquals(startState.toString(), startState.pressRightPedalTwice(context).toString());
		assertTrue(startState.pressRightPedalTwice(context).toString().equals("Decelerating backwards"));

	}

	@Test
	public void holdRightPedalOverFiveSec_test() {
		Context context = new Context();
		DeceleratingBackwards startState = new DeceleratingBackwards();

		assertSame(startState, startState.holdRightPedalOverFiveSec(context));
		assertEquals(startState.toString(), startState.holdRightPedalOverFiveSec(context).toString());
		assertTrue(startState.holdRightPedalOverFiveSec(context).toString().equals("Decelerating backwards"));

	}

	@Test
	public void pressLeftPedalOnce_test() {
		Context context = new Context();
		DeceleratingBackwards startState = new DeceleratingBackwards();
		ConstantBackwardsSpeed newState = new ConstantBackwardsSpeed();

		assertSame(newState.getClass(), startState.pressLeftPedalOnce(context).getClass());
		assertEquals(newState.toString(), startState.pressLeftPedalOnce(context).toString());
		assertTrue(startState.pressLeftPedalOnce(context).toString().equals("Constant backwards speed"));

	}

	@Test
	public void pressLeftPedalTwice_test() {
		Context context = new Context();
		DeceleratingBackwards startState = new DeceleratingBackwards();

		assertSame(startState, startState.pressLeftPedalTwice(context));
		assertEquals(startState.toString(), startState.pressLeftPedalTwice(context).toString());
		assertTrue(startState.pressLeftPedalTwice(context).toString().equals("Decelerating backwards"));

	}

	@Test
	public void holdLeftPedalOverFiveSec_test() {
		Context context = new Context();
		DeceleratingBackwards startState = new DeceleratingBackwards();
		AcceleratingBackwards newState = new AcceleratingBackwards();

		assertSame(newState.getClass(), startState.holdLeftPedalOverFiveSec(context).getClass());
		assertEquals(newState.toString(), startState.holdLeftPedalOverFiveSec(context).toString());
		assertTrue(startState.holdLeftPedalOverFiveSec(context).toString().equals("Accelerating backwards"));
	}

	@Test
	public void toString_test() {
		DeceleratingBackwards startState = new DeceleratingBackwards();

		assertSame("Decelerating backwards", startState.toString());
		assertEquals("decelerating backwards", startState.toString().toLowerCase());
		assertTrue(startState.toString().equals("Decelerating backwards"));
	}

}
