package lasdamastdd.views;

import lasdamastdd.controllers.ResumeController;
import lasdamastdd.utils.YesNoDialog;

public class ResumeView extends SubView {

    private YesNoDialog yesNoDialog;

    public ResumeView() {
        super();
        this.yesNoDialog = new YesNoDialog();
    }

    public void interact(ResumeController resumeController) {
        assert resumeController != null;
        if (this.yesNoDialog.read(MessageView.PLAY_AGAIN.getMessage())) {
            resumeController.reset();
        } else {
            resumeController.next();
        }

    }
}
