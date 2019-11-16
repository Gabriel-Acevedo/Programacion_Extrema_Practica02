package lasdamastdd.views;

import lasdamastdd.utils.Console;

public enum MessageView {

    TITLE("DAMAS"),
    PLAY_AGAIN("¿Queréis jugar otra"),
    NOT_MOVE_DEFEAT("Derrota!!! No puedes mover tus fichas!!!"),
    GIVE_UP_DEFEAT("Derrota!!! Te has rendido!!!"),
    INVALID_FORMAT("Entrada no valida, prueba de nuevo");

    private String message;
    private static Console console = new Console();

    private MessageView(String message) {
        this.message = message;
    }

    void write() {
        MessageView.console.write(this.message);
    }

    void writeln() {
        MessageView.console.writeln(this.message);
    }
    
    String getMessage() {
        return this.message;
    }
}
