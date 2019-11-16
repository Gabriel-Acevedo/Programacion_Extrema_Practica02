package lasdamastdd.views;

import lasdamastdd.controllers.Controller;
import lasdamastdd.models.Board;
import lasdamastdd.models.Coordinate;
import lasdamastdd.models.Piece;

public class GameView extends SubView {
    
    public void write(Controller controller) {
        assert controller != null;
        this.console.writeln();
        this.writeNumbersLine(Board.DIMENSION);
        for (int i = 0; i < Board.DIMENSION; i++) {
            this.console.write((i + 1) + "");
            for (int j = 0; j < Board.DIMENSION; j++) {
               Piece piece = controller.getPiece(new Coordinate(i, j));
                if (piece == null) {
                    this.console.write(Piece.pieceTypes[Piece.pieceTypes.length - 1]);
                } else {
                    for (int p = 0; p < Piece.PIECES.length; p++) {
                        if (Piece.PIECES[p].getClass() == piece.getClass() && Piece.PIECES[p].getColor() == piece.getColor()) {
                            this.console.write(Piece.pieceTypes[p]);
                        }
                    }
                }
            }
            this.console.writeln((i + 1) + "");
        }
        this.writeNumbersLine(Board.DIMENSION);
        this.console.writeln();
    }

    private void writeNumbersLine(final int DIMENSION) {
        this.console.write(" ");
        for (int i = 0; i < DIMENSION; i++) {
            this.console.write((i + 1) + "");
        }
        this.console.writeln();
    }

}
