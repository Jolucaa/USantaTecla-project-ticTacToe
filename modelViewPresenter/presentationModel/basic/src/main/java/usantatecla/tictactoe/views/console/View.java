package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;

public class View{

	private StartView startView;
	private PlayView playView;
	private ResumeView resumeView;

	public View(StartController startController, PlayController playController, ResumeController resumeController) {
		this.startView = new StartView(startController);
		this.playView = new PlayView(playController);
		this.resumeView = new ResumeView(resumeController);
	}

	public void interact() {
		do {
			this.start();
			this.play();
		} while (this.isResumed());
	}

	protected void start(){
		this.startView.interact();
	}

	protected void play(){
		this.playView.interact();
	}

	protected boolean isResumed(){
		return this.resumeView.interact();
	}

}
