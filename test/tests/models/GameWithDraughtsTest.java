package tests.models;

import lasdamastdd.models.Color;
import lasdamastdd.models.Coordinate;
import lasdamastdd.models.Draught;
import lasdamastdd.models.Game;
import lasdamastdd.models.GameBuilder2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class GameWithDraughtsTest {

    @Test
    public void WhenWhitePawnAtLimitThenNewDraugts() {
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
    public void WhenWhitePawnReachLimitAndEatingThenNewDraugts() {
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
    }
    
    
    @Test
    public void WhenBlackPawnReachLimitThenNewDraugts() {
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
    }  
    
    
    @Test
    public void WhenBlackPawnReachLimitAndEatingThenNewDraugts() {
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
    }  
    
    @Test
    public void WhenWhiteDraughtMoveLongDistanceThenNotError() {
        Coordinate origin = new Coordinate(0, 1);
        Coordinate target = new Coordinate(4, 5);
        Game game = new GameBuilder2()
                .row(" B      ")
                .row("        ")
                .row("        ")
                .row("        ")
                .row("        ")
                .row("    n   ")
                .row("        ")
                .row("        ")
                .build();
        game.getBoard().put(origin, new Draught(Color.WHITE));
        game.move(origin, target);
        assertEquals(Draught.class, game.getPiece(target).getClass());
        assertEquals(Color.WHITE, game.getPiece(target).getColor());
    }
    
    
    @Test
    public void WhenBlackDraughtMoveLongDistanceThenNotError() {
        Coordinate origin = new Coordinate(4, 3);
        Coordinate target = new Coordinate(1, 6);
        Game game = new GameBuilder2()
                .row(" B      ")
                .row("        ")
                .row("        ")
                .row("        ")
                .row("   N    ")
                .row("        ")
                .row("        ")
                .row("        ")
                .build();
        game.getBoard().put(origin, new Draught(Color.BLACK));
        game.getTurn().change();
        game.move(origin, target);
        assertEquals(Draught.class, game.getPiece(target).getClass());
        assertEquals(Color.BLACK, game.getPiece(target).getColor());
    }
    
    @Test
    public void testGivenGameWhenWhiteDraughtMoveAnyDiagonalDirectionAndEatingThenNotError() {
        Coordinate origin = new Coordinate(2, 0);
        Coordinate target = new Coordinate(4, 2);
        Game game = new GameBuilder2()
                .row("        ")
                .row("        ")
                .row("B       ")
                .row(" n      ")
                .row("        ")
                .row("        ")
                .row("        ")
                .row("        ")
                .build();
        game.getBoard().put(origin, new Draught(Color.WHITE));
        game.move(origin, target);
        assertEquals(null, game.getPiece(origin.betweenDiagonal(target)));
        assertEquals(Draught.class, game.getPiece(target).getClass());
        assertEquals(Color.WHITE, game.getPiece(target).getColor());
    }
 
    
    @Test
    public void WhenWhiteDraughtIsBlockedThenTrue() {
        Coordinate origin = new Coordinate(2, 3);
        Game game = new GameBuilder2()
                .row(" n n n  ")
                .row("n n n   ")
                .row("   B    ")
                .row("  n n   ")
                .row(" n   n  ")
                .row("n     n ")
                .row("       n")
                .row("        ")
                .build();
        game.getBoard().remove(origin);
        game.getBoard().put(origin, new Draught(Color.WHITE));
        assertEquals(Color.WHITE, game.getTurn().getColor());
        assertTrue(game.isBlocked());
    }
    
    
    @Test
    public void WhenBlackDraughtsIsBlockedThenTrue() {
        Coordinate origin = new Coordinate(2, 3);
        Game game = new GameBuilder2()
                .row(" n   n  ")
                .row("b b b b ")
                .row(" b N   b")
                .row("b b b   ")
                .row(" b   b  ")
                .row("b     b ")
                .row("       b")
                .row("        ")
                .build();
        game.getBoard().remove(origin);
        game.getBoard().put(origin, new Draught(Color.BLACK));
        game.getTurn().change();
        assertEquals(Color.BLACK, game.getTurn().getColor());
        assertTrue(game.isBlocked());
    }
    
}
