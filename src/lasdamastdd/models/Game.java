package lasdamastdd.models;

import lasdamastdd.views.GameView;

public class Game {

    private Board board;

    private Turn turn;

    public static final int EMPTY_SQUARES_START_ROW = 3;
    public static final int EMPTY_SQUARES_FINISH_ROW = 4;

    public Game() {
        this.turn = new Turn();
        this.board = new Board();
        for (int i = 0; i < Board.DIMENSION; i++) {
            for (int j = 0; j < Board.DIMENSION; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                Piece piece = this.getInitialPiece(coordinate);
                if (piece != null) {
                    this.board.put(coordinate, piece);
                }
            }
        }
    }

    public Game(Board board) {
        this.turn = new Turn();
        this.board = board;
    }

    public Piece getInitialPiece(Coordinate coordinate) {
        if (coordinate.isBlack()) {
            if (coordinate.getRow() < EMPTY_SQUARES_START_ROW) {
                return new Piece(Color.BLACK);
            } else if (coordinate.getRow() > EMPTY_SQUARES_FINISH_ROW) {
                return new Piece(Color.WHITE);
            }
        }
        return null;
    }

    public void move(Coordinate origin, Coordinate target) {
        assert this.isCorrect(origin, target) == null;
        if (origin.diagonalDistance(target) == 2) {
            this.board.remove(origin.betweenDiagonal(target));
        }
        this.board.move(origin, target);
        this.turn.change();

    }

    public Error isCorrect(Coordinate origin, Coordinate target) {
        assert origin != null;
        assert target != null;
        if (board.isEmpty(origin)) {
            return Error.EMPTY_ORIGIN;
        }
        if (this.turn.getColor() != this.board.getColor(origin)) {
            return Error.OPPOSITE_PIECE;
        }
        return this.board.getPiece(origin).isCorrect(origin, target, this.board);
    }

    public Color getColor(Coordinate coordinate) {
        assert coordinate != null;
        return this.board.getColor(coordinate);
    }

    public Color getColor() {
        return this.turn.getColor();
    }

    public boolean hasNoPieces() {
        return this.board.getPieces(this.turn.getColor()).isEmpty();
    }

    public Piece getPiece(Coordinate coordinate) {
        assert coordinate != null;
        return this.board.getPiece(coordinate);
    }

    @Override
    public String toString() {
        return this.board + "\n" + this.turn;
    }

    Board getBoard() {
        return this.board;
    }

    Turn getTurn() {
        return this.turn;
    }


}
