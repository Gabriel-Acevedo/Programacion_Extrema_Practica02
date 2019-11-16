package lasdamastdd.models;

public class Draught extends Piece {

    public Draught(Color color) {
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
        if (!pieceProvider.isEmpty(target)) {
            return Error.NOT_EMPTY_TARGET;
        }
        return null;
    }

    @Override
    public boolean isAdvanced(Coordinate origin, Coordinate target) {
        assert origin != null;
        assert target != null;
        return true;
    }
    
}
