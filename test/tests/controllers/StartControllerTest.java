package tests.controllers;

import lasdamastdd.controllers.StartController;
import lasdamastdd.models.Game;
import lasdamastdd.models.State;
import lasdamastdd.models.StateValue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StartControllerTest {

    @Test
    public void givenStartControllerWhenStartGameThenChangeState() {
        State state = new State();
        StartController startController = new StartController(new Game(), state);
        assertEquals(StateValue.INITIAL, state.getValueState());
        startController.start();
        assertEquals(StateValue.IN_GAME, state.getValueState());
    }

}
