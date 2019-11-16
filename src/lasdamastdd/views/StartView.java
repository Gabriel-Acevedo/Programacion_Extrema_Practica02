package lasdamastdd.views;

import lasdamastdd.controllers.StartController;

public class StartView extends SubView {

    public StartView() {
        super();
    }

    public void interact(StartController startController) {
        assert startController != null;
        MessageView.TITLE.writeln();
        new GameView().write(startController);
        startController.start();
    }
}
