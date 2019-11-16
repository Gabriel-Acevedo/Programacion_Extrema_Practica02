package lasdamastdd.controllers;

import lasdamastdd.models.Coordinate;
import lasdamastdd.models.Game;
import lasdamastdd.models.Piece;
import lasdamastdd.models.State;

public abstract class Controller {

    protected Game game;
    protected State state;

    protected Controller(Game game, State state) {
        assert game != null;
        assert state != null;
        this.game = game;
        this.state = state;
    }
  
    public Piece getPiece(Coordinate coordinate){
        assert coordinate != null;
        return this.game.getPiece(coordinate);
    }

    abstract public void accept(ControllersVisitor controllersVisitor);
}
