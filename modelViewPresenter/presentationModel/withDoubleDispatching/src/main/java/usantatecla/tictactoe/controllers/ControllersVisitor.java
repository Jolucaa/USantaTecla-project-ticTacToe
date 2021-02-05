package usantatecla.tictactoe.controllers;

// TODO Cambiar nombres a 'visit'
public interface ControllersVisitor {

    void visitStartController(StartController startController);
	
	void visitPlayController(PlayController playController);
	
	boolean visitResumeController(ResumeController resumeController);
    
}