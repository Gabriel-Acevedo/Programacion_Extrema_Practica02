package tests.models;

import lasdamastdd.models.Board;
import lasdamastdd.models.Color;
import lasdamastdd.models.Coordinate;
import lasdamastdd.models.Draught;
import lasdamastdd.models.Game;
import lasdamastdd.models.GameBuilder2;
import lasdamastdd.models.Piece;
import lasdamastdd.models.Turn;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

public class GameWithDraughtsTest {

    @Mock
    Turn turn;

    @Mock
    Piece piece;

    @Mock
    Board board;

    @InjectMocks
    Game game;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

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
        verify(board).remove(target);
        verify(board).put(target, new Draught(Color.WHITE));
    }
}
