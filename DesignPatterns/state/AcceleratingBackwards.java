package state;

public class AcceleratingBackwards implements State {

	public State pressRightPedalOnce(Context context) {
		context.setState(this);
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
		context.setStateDeceleratingBackwards();
		return context.getState();

	}

	public State holdLeftPedalOverFiveSec(Context context) {
		context.setState(this);
		return context.getState();

	}

	public String toString() {
		return "Accelerating backwards";
	}

}
