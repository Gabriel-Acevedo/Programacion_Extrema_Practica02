package lasdamastdd.models;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }
    
    @Override
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

    @Override
    public boolean isAdvanced(Coordinate origin, Coordinate target) {
        assert origin != null;
        assert target != null;
        int difference = origin.getRow() - target.getRow();
        if (this.color == Color.WHITE) {
            return difference > 0;
        }
        return difference < 0;
    }
}
