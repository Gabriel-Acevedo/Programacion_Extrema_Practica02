package tests.controllers;

import lasdamastdd.controllers.PlayController;
import lasdamastdd.models.Color;
import lasdamastdd.models.Coordinate;
import lasdamastdd.models.Game;
import lasdamastdd.models.State;
import lasdamastdd.models.StateValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class PlayControllerTest {

    @Test
    public void WhenMovementRequiereCorrectThenNotError() {
        PlayController playController = new PlayController(new Game(), new State());
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        assertNull(playController.isCorrect(origin, target));
        playController.move(origin, target);
        assertNull(playController.getPiece(origin));
        assertEquals(playController.getPiece(target).getColor(), Color.WHITE);
    }
    
    @Test
    public void WhenEndGameThenNextStateFinal() {
        PlayController playController = new PlayController(new Game(), new State());
        playController.setStateValue(StateValue.IN_GAME);
        playController.endGame();
        assertEquals(playController.getStateValue(), StateValue.FINAL);
    }
}
