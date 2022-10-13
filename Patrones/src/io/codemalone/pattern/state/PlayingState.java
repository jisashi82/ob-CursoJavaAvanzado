package io.codemalone.pattern.state;

public class PlayingState extends State{

	public PlayingState(Player player) {
		super(player);
	}

	@Override
	public String onLock() {
		player.changeState(new LockedState(player));
		player.setCurrentTrackAfterStop();
		return "Stop Playing";
	}

	@Override
	public String onPlay() {
		player.changeState(new ReadyState(player));
		return "Paused ...";
	}

	@Override
	public String onNext() {
		return player.nextTrack();
	}

	@Override
	public String onPrevious() {
		return player.prevoiusTrack();
	}

}
