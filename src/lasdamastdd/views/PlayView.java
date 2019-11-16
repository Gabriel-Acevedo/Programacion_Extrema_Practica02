package lasdamastdd.views;

import lasdamastdd.controllers.PlayController;
import lasdamastdd.models.Coordinate;
import lasdamastdd.models.Error;

public class PlayView extends SubView {

    private static final String[] COLORS = {"blancas", "negras"};
    private static final String FORMAT = "xx.xx";

    public PlayView() {
        super();
    }

    public void interact(PlayController playController) {
        assert playController != null;
        String color = "";
        Error error = null;
        Coordinate origin = null;
        Coordinate target = null;
        String format = "";
        GameView gameView = new GameView();

        do {
            try {
                gameView.write(playController);
                error = null;
                color = PlayView.COLORS[playController.getColor().ordinal()];
                format = this.console.readString("Mueven las " + color + ": ");

                if (format.length() != PlayView.FORMAT.length()) {
                    this.console.writeln("Error!!! Formato incorrecto");
                    error = Error.BAD_FORMAT;
                } else {
                    origin = Coordinate.getInstance(format.substring(0, 2));
                    target = Coordinate.getInstance(format.substring(3, 5));
                    if (origin == null || target == null) {
                        error = Error.BAD_FORMAT;
                    }
                }/*
                if (error != null) {
                    
                }*/

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {

                if (format.equals("-1")) {
                    this.console.writeln(MessageView.GIVE_UP_DEFEAT.getMessage());
                    error = null;
                    playController.endGame();
                } else {
                    this.console.writeln(MessageView.INVALID_FORMAT.getMessage());
                }
            }
        } while (error != null);
        error = playController.isCorrect(origin, target);
        if (error == null) {
            playController.move(origin, target);
            if (playController.hasNoPieces()) {
                this.console.write(MessageView.NOT_MOVE_DEFEAT.getMessage());
            }
        } else {
            console.writeln("Error!!!" + error.name());
        }
    }

}
