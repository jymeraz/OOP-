package state;

public class Context {
	private State state;
	private State stationary;
	private State acceleratingForwards;
	private State deceleratingForwards;
	private State constantForwardsSpeed;
	private State acceleratingBackwards;
	private State deceleratingBackwards;
	private State constantBackwardsSpeed;

	public Context() {
		state = null;
		stationary = new Stationary();
		acceleratingForwards = new AcceleratingForwards();
		deceleratingForwards = new DeceleratingForwards();
		constantForwardsSpeed = new ConstantForwardsSpeed();
		acceleratingBackwards = new AcceleratingBackwards();
		deceleratingBackwards = new DeceleratingBackwards();
		constantBackwardsSpeed = new ConstantBackwardsSpeed();
	}

	public void setStateStationary() {
		this.state = stationary;
	}

	public void setStateAcceleratingForwards() {
		this.state = acceleratingForwards;
	}

	public void setStateDeceleratingForwards() {
		this.state = deceleratingForwards;
	}

	public void setStateConstantForwardsSpeed() {
		this.state = constantForwardsSpeed;
	}

	public void setStateAcceleratingBackwards() {
		this.state = acceleratingBackwards;
	}

	public void setStateDeceleratingBackwards() {
		this.state = deceleratingBackwards;
	}

	public void setStateConstantBackwardsSpeed() {
		this.state = constantBackwardsSpeed;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

}
