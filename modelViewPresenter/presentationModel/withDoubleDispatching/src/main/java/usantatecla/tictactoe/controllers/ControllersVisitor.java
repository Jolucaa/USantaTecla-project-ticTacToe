package usantatecla.tictactoe.controllers;

public interface ControllersVisitor {

    void visitStartController(StartController startController);
	
	void visitPlayController(PlayController playController);
	
	boolean visitResumeController(ResumeController resumeController);
    
}