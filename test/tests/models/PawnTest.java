/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.models;

import lasdamastdd.models.Color;
import lasdamastdd.models.Coordinate;
import lasdamastdd.models.Pawn;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Gabri
 */
public class PawnTest {
   
    @Test
    public void WhenPawnIsAdvancedThenTrue() {
        assertTrue(new Pawn(Color.WHITE).isAdvanced(new Coordinate(5, 0), new Coordinate(4, 1)));
        assertTrue(new Pawn(Color.BLACK).isAdvanced(new Coordinate(2, 1), new Coordinate(3, 2)));
    }

    @Test
    public void WhenPawnIsAdvancedThenFalse() {
        assertFalse(new Pawn(Color.WHITE).isAdvanced(new Coordinate(5, 0), new Coordinate(6, 1)));
        assertFalse(new Pawn(Color.WHITE).isAdvanced(new Coordinate(5, 0), new Coordinate(5, 2)));
        assertFalse(new Pawn(Color.BLACK).isAdvanced(new Coordinate(2, 1), new Coordinate(2, 3)));
        assertFalse(new Pawn(Color.BLACK).isAdvanced(new Coordinate(2, 1), new Coordinate(1, 2)));
    }
    
}
