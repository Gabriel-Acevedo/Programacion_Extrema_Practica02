package tests.models;

import lasdamastdd.models.Color;
import lasdamastdd.models.Coordinate;
import lasdamastdd.models.Draught;
import lasdamastdd.models.Game;
import lasdamastdd.models.GameBuilder2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class GameWithDraughtsTest {

    @Test
    public void testGivenGameWhenWhitePawnAtLimitThenNewDraugts() {
        Coordinate origin = new Coordinate(1, 0);
        Coordinate target = new Coordinate(0, 1);
        Game game = new GameBuilder2()
             .row("        ")
             .row("b       ")
             .row("   n    ")
             .row("        ")
             .row("        ")
             .row("        ")
             .row("        ")
             .row("        ")
             .build();
        game.move(origin, target);
        assertEquals(Draught.class, game.getPiece(target).getClass());
        assertEquals(Color.WHITE, game.getPiece(target).getColor());
    }

}
