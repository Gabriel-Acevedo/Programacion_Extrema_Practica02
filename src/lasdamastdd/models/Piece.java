package lasdamastdd.models;

public class Piece {

    Color color;
    private Pawn pawn;
    private Draught draught;
    public static final int MAX_DISTANCE = 2;

    public static final String[] pieceTypes = {"b", "n", "B", "N", " "};
    public static Piece[] PIECES = new Piece[]{
        new Pawn(Color.WHITE),
        new Pawn(Color.BLACK),
        new Draught(Color.WHITE),
        new Draught(Color.BLACK)
    };
    
    public Piece(Color color) {
        assert color != null;
        this.color = color;
    }

    public Error isCorrect(Coordinate origin, Coordinate target, PieceProvider pieceProvider) {
        if(this instanceof Draught){
            return draught.isCorrect(origin, target, pieceProvider);
        }
        return pawn.isCorrect(origin, target, pieceProvider);
    }

    boolean isLimit(Coordinate coordinate) {
        return coordinate.getRow() == Board.INITIAL_LIMIT && this.getColor() == Color.WHITE || coordinate.getRow() == Board.FINAL_LIMIT && this.getColor() == Color.BLACK;
    }

    public boolean isAdvanced(Coordinate origin, Coordinate target) {
        if(this instanceof Draught){
            return draught.isAdvanced(origin, target);
        }
        return pawn.isAdvanced(origin, target);
    }

    public Color getColor() {
        return this.color;
    }

}
