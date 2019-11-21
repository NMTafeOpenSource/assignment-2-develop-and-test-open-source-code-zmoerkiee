/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicool;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elkenhound
 */
public class RentalCostTest {
    
    public RentalCostTest() {
    }

    @Test
    public void testCalculateByDays() {
        RentalCost renter = new RentalCost(200.0, 2, 3000);
        assertEquals(400.0, renter.CalculateByDays(), 0.0);
    }

    @Test
    public void testCalculateByDist() {
        RentalCost renter = new RentalCost(2.0, 2, 3000);
        assertEquals(6000.0, renter.CalculateByDist(), 0.0);
    }
    
}
