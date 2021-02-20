package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;

public class ResumeController extends Controller implements AcceptorController {

    public ResumeController(Session session) {
        super(session);
    }

    public void resume() {
        this.session.reset();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
