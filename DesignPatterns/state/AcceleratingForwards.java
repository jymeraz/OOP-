package state;

public class AcceleratingForwards implements State {
	public State pressRightPedalOnce(Context context) {
		context.setState(this);
		return context.getState();

	}

	public State pressRightPedalTwice(Context context) {
		context.setStateDeceleratingForwards();
		return context.getState();

	}

	public State holdRightPedalOverFiveSec(Context context) {
		context.setStateConstantForwardsSpeed();
		return context.getState();

	}

	public State pressLeftPedalOnce(Context context) {
		context.setState(this);
		return context.getState();

	}

	public State pressLeftPedalTwice(Context context) {
		context.setState(this);
		return context.getState();

	}

	public State holdLeftPedalOverFiveSec(Context context) {
		context.setState(this);
		return context.getState();

	}

	public String toString() {
		return "Accelerating forwards";
	}

}
