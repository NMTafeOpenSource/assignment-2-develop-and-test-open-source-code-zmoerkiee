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
public class FuelPurchaseTest {
    
    FuelPurchase frank;
    
    @Before
    public void initialize(){
        frank = new FuelPurchase();
    }

    @Test
    public void testFuelEcGreaterThanZero() {
        double fEc = frank.fuelEconomy(12345, 45678);
        assertEquals(27.02613949822672, fEc, 0);
    }

    @Test
    public void testFuelEcLessThanZero() {
        double fEc = frank.fuelEconomy(-12345, 45678);
        assertEquals(0, fEc, 0);
    }

    @Test
    public void testFuelEcEqualsZero() {
        double fEc = frank.fuelEconomy(0, 45678);
        assertEquals(0, fEc, 0);
    }
    
}
