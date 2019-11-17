package lasdamastdd.controllers;

import lasdamastdd.models.Color;
import lasdamastdd.models.Coordinate;
import lasdamastdd.models.Error;
import lasdamastdd.models.Game;
import lasdamastdd.models.Piece;
import lasdamastdd.models.State;
import lasdamastdd.models.StateValue;

public class PlayController extends Controller {

    public PlayController(Game game, State state) {
        super(game, state);
    }

    public void move(Coordinate origin, Coordinate target) {
        assert this.isCorrect(origin, target) == null;
        this.game.move(origin, target);
        if (this.game.hasNoPieces() || this.game.isBlocked()) {
            this.state.next();
        }
    }

    public Error isCorrect(Coordinate origin, Coordinate target) {
        assert origin != null;
        assert target != null;
        return this.game.isCorrect(origin, target);
    }

    public Piece getPiece(Coordinate coordinate) {
        return this.game.getPiece(coordinate);
    }

    public Color getColor() {
        return this.game.getColor();
    }

    public boolean hasNoPieces() {
        return this.game.hasNoPieces();
    }

    public void endGame() {
        this.game = new Game();
        this.state.next();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        assert controllersVisitor != null;
        controllersVisitor.visit(this);
    }
    
    public StateValue getStateValue(){
        return this.state.getValueState();
    }

    public void setStateValue(StateValue stateValue){
        this.state.setValueState(stateValue);
    }

}
