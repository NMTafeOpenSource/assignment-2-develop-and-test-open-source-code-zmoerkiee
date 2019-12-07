/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicool;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Elkenhound
 */
public class RentalCostTest {
    
    RentalCost renter;
    
    @Before
    public void initialize(){
        renter = new RentalCost(200.0, 2);
    }

    @Test
    public void testCalculateByDays() {
        assertEquals(400.0, renter.CalculateByDays(), 0.0);
    }
    
}
