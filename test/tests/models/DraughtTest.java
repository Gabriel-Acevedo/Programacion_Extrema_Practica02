/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.models;

import lasdamastdd.models.Color;
import lasdamastdd.models.Coordinate;
import lasdamastdd.models.Draught;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Gabri
 */
public class DraughtTest {
    
    @Test
    public void WhenDraughtIsAdvancedThenTrue() {
        assertTrue(new Draught(Color.WHITE).isAdvanced(new Coordinate(2, 3), new Coordinate(3, 4)));
        assertTrue(new Draught(Color.BLACK).isAdvanced(new Coordinate(4, 1), new Coordinate(5, 2)));
        assertTrue(new Draught(Color.BLACK).isAdvanced(new Coordinate(6, 1), new Coordinate(2, 4)));
    }
    
}
