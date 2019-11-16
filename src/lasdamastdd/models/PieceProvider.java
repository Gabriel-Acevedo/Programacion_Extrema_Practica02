package lasdamastdd.models;

interface PieceProvider {

    boolean isEmpty(Coordinate coordinate);

    Piece getPiece(Coordinate coordinate);
}
