package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;

public class ResumeController extends UseCaseController implements AcceptorController {

    public ResumeController(Session session) {
        super(session);
    }

    public void reset() {
        this.session.reset();
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
