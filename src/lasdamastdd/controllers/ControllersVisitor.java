package lasdamastdd.controllers;

public interface ControllersVisitor {

    public void visit(StartController startController);

    public void visit(PlayController playController);

    public void visit(ResumeController resumeController);
}
