package lasdamastdd.views;

import lasdamastdd.controllers.Controller;
import lasdamastdd.models.Board;
import lasdamastdd.models.Color;
import lasdamastdd.models.Coordinate;
import lasdamastdd.models.Draught;
import lasdamastdd.models.Pawn;
import lasdamastdd.models.Piece;

public class GameView extends SubView {

    private static final String[] PIECES = new String[]{"b", "n","B", "N", " "};
    
    public void write(Controller controller) {
        assert controller != null;
        this.console.writeln();
        this.writeNumbersLine(Board.DIMENSION);
        for (int i = 0; i < Board.DIMENSION; i++) {
            this.console.write((i + 1) + "");
            for (int j = 0; j < Board.DIMENSION; j++) {
               Piece piece = controller.getPiece(new Coordinate(i, j));
                if (piece == null) {
                    this.console.write(GameView.PIECES[4]);
                }
                else if(piece.getColor() == Color.WHITE && (piece instanceof Pawn)){
                    this.console.write(GameView.PIECES[0]);
                }
                else if(piece.getColor() == Color.BLACK && (piece instanceof Pawn)){
                    this.console.write(GameView.PIECES[1]);
                }
                else if(piece.getColor() == Color.WHITE && (piece instanceof Draught)){
                    this.console.write(GameView.PIECES[2]);
                }
                else if(piece.getColor() == Color.BLACK && (piece instanceof Draught)){
                    this.console.write(GameView.PIECES[3]);
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
