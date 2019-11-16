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
    
    @Test
    public void testGivenGameWhenWhitePawnReachLimitAndEatingThenNewDraugts() {
        Coordinate origin = new Coordinate(2, 0);
        Coordinate target = new Coordinate(0, 2);
        Game game = new GameBuilder2()
             .row("        ")
             .row(" n      ")
             .row("b       ")
             .row("        ")
             .row("        ")
             .row("        ")
             .row("        ")
             .row("        ")
             .build();
        game.move(origin, target);
        assertEquals(null, game.getPiece(origin.betweenDiagonal(target)));
        assertEquals(Draught.class, game.getPiece(target).getClass());
        assertEquals(Color.WHITE, game.getPiece(target).getColor());
        System.out.println(game.getBoard().toString());
    }
    
    
    @Test
    public void testGivenGameWhenBlackPawnReachLimitThenNewDraugts() {
        Coordinate origin = new Coordinate(6, 2);
        Coordinate target = new Coordinate(7, 1);
        Game game = new GameBuilder2()
             .row("        ")
             .row(" n      ")
             .row("b       ")
             .row("        ")
             .row("        ")
             .row("        ")
             .row("  n     ")
             .row("        ")
             .build();
        game.getTurn().change();
        game.move(origin, target);
        assertEquals(Draught.class, game.getPiece(target).getClass());
        assertEquals(Color.BLACK, game.getPiece(target).getColor());
        System.out.println(game.getBoard().toString());
    }  
    
    
    @Test
    public void testGivenGameWhenBlackPawnReachLimitAndEatingThenNewDraugts() {
        Coordinate origin = new Coordinate(5, 3);
        Coordinate target = new Coordinate(7, 1);
        Game game = new GameBuilder2()
             .row("        ")
             .row(" n      ")
             .row("b       ")
             .row("        ")
             .row("        ")
             .row("   n    ")
             .row("  b     ")
             .row("        ")
             .build();
        game.getTurn().change();
        game.move(origin, target);
        assertEquals(null, game.getPiece(origin.betweenDiagonal(target)));
        assertEquals(Draught.class, game.getPiece(target).getClass());
        assertEquals(Color.BLACK, game.getPiece(target).getColor());
        System.out.println(game.getBoard().toString());
    }  
    
}
