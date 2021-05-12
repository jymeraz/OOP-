package state;

public interface State {
	public State pressRightPedalOnce(Context context);

	public State pressRightPedalTwice(Context context);

	public State holdRightPedalOverFiveSec(Context context);

	public State pressLeftPedalOnce(Context context);

	public State pressLeftPedalTwice(Context context);

	public State holdLeftPedalOverFiveSec(Context context);
}
