package usantatecla.tictactoe.views.graphics;

import usantatecla.tictactoe.models.Game;

public class GraphicsView extends usantatecla.tictactoe.views.View {

	private PlayView playView;
	private StartView startView;

	public GraphicsView(Game game) {
		super(game);
		this.startView = new StartView(this.game);
		this.playView = new PlayView(this.game);
	}

	@Override
	protected void start() {
		this.startView.interact();
	}

	@Override
	protected void play() {
		this.startView.setVisible(false);
		this.playView.interact();
	}

	@Override
	protected boolean resume() {
		if (new ResumeView().isResumedGame()) {
			this.game.reset();
			return true;
		}
		this.playView.setVisible(false);
		System.exit(0);
		return false;
	}

}
