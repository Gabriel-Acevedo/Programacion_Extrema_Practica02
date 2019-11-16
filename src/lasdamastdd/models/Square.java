package lasdamastdd.models;

class Square {

    private Piece piece;

    Square() {
    }

    void put(Piece piece) {
        assert piece != null;
        this.piece = piece;
    }

    Piece remove() {
        Piece removedPiece = this.getPiece();
        this.piece = null;
        return removedPiece;
    }

    Piece getPiece() {
        return this.piece;
    }

    boolean isEmpty() {
        return this.getPiece() == null;
    }

    Color getColor() {
        if (this.getPiece() == null) {
            return null;
        }
        return this.getPiece().getColor();
    }

}
