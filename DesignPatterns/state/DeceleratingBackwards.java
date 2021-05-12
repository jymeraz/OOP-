package state;

public class DeceleratingBackwards implements State {
	public State pressRightPedalOnce(Context context) {
		context.setStateStationary();
		return context.getState();

	}

	public State pressRightPedalTwice(Context context) {
		context.setState(this);
		return context.getState();

	}

	public State holdRightPedalOverFiveSec(Context context) {
		context.setState(this);
		return context.getState();

	}

	public State pressLeftPedalOnce(Context context) {
		context.setStateConstantBackwardsSpeed();
		return context.getState();

	}

	public State pressLeftPedalTwice(Context context) {
		context.setState(this);
		return context.getState();

	}

	public State holdLeftPedalOverFiveSec(Context context) {
		context.setStateAcceleratingBackwards();
		return context.getState();

	}

	public String toString() {
		return "Decelerating backwards";
	}

}
