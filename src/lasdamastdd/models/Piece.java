package lasdamastdd.models;

public class Piece {

    private Color color;
    private static final int MAX_DISTANCE = 2;

    public Piece(Color color) {
        assert color != null;
        this.color = color;
    }

    public Error isCorrect(Coordinate origin, Coordinate target, PieceProvider pieceProvider) {
        if (!origin.isDiagonal(target)) {
            return Error.NOT_DIAGONAL;
        }
        if (!this.isAdvanced(origin, target)) {
            return Error.NOT_ADVANCED;
        }
        int distance = origin.diagonalDistance(target);
        if (distance > Piece.MAX_DISTANCE) {
            return Error.BAD_DISTANCE;
        }
        if (!pieceProvider.isEmpty(target)) {
            return Error.NOT_EMPTY_TARGET;
        }
        if (distance == Piece.MAX_DISTANCE) {
            if (pieceProvider.getPiece(origin.betweenDiagonal(target)) == null) {
                return Error.EATING_EMPTY;
            }
        }
        return null;
    }

    boolean isLimit(Coordinate coordinate) {
        return coordinate.getRow() == Board.INITIAL_LIMIT && this.getColor() == Color.WHITE || coordinate.getRow() == Board.FINAL_LIMIT && this.getColor() == Color.BLACK;
    }

    public boolean isAdvanced(Coordinate origin, Coordinate target) {
        assert origin != null;
        assert target != null;
        int difference = origin.getRow() - target.getRow();
        if (color == Color.WHITE) {
            return difference > 0;
        }
        return difference < 0;
    }

    public Color getColor() {
        return this.color;
    }

}
