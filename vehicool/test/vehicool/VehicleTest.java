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
public class VehicleTest {
    
    Vehicle kuruma;
    
    @Before
    public void initialize(){
        kuruma = new Vehicle("Ford", "Taurus", 1996, "1EPK496", 5000, 40, 22);
    }
    
    @Test
    public void testAddKilos(){
        System.out.println("Testing AddKilos");
        kuruma.addKilos(5000);
        assertEquals(10000, kuruma.getOdo());
    }
    
    @Test
    public void testChkFuelOutOfFuel(){
        kuruma.setTank(0);
        assertEquals("This vehicle is out of fuel", kuruma.checkFuel());
    }
    
    @Test
    public void testChkFuelHasFuel(){
        kuruma.setTank(40);
        assertEquals("This vehicle has 40.0 litres of fuel remaining", kuruma.checkFuel());
    }
    
    @Test
    public void testProfitCalc(){
        kuruma.addFuel(20, 20);
        kuruma.recRental(1, 0, 0);
        double value = kuruma.profitCalc();
        assertEquals(2, value, 0);
    }
    
    @Test
    public void testAddFuel(){
        kuruma.addFuel(20, 0);
        assertEquals(60, kuruma.getTank(), 0);
    }
    
    @Test
    public void testRemFuel(){
        kuruma.remFuel(20);
        assertEquals(20, kuruma.getTank(), 0);
    }
    
    @Test
    public void testRecRental(){
        kuruma.recRental(3, 5200, 60);
        /*
        Testing against print details output because method works on private
        classes that are only visible from print details and print save details.
        */
        String expected = "Vehicle: Ford Taurus 1996\nRegistration No: 1EPK496"
                + "\nTotal KMs travelled: 5200\nTotal services: 0\nTotal "
                + "revenue: $66.0\nTotal cost: $0.0\nTotal profit: $66.0\nThis "
                + "vehicle does not need a service.\nDistance traveled since "
                + "last service: 5200km\nFuel economy: 0.0L per 100KM";
        assertEquals(expected, kuruma.printDetails());
    }
    
    @Test
    public void testRecService(){
        kuruma.recService(200);
        /*
        Testing against print details output because method works on private
        classes that are only visible from print details and print save details.
        */
        String expected = "Vehicle: Ford Taurus 1996\nRegistration No: 1EPK496"
                + "\nTotal KMs travelled: 5000\nTotal services: 1\nTotal "
                + "revenue: $0.0\nTotal cost: $200.0\nTotal profit: $-200.0\nThis "
                + "vehicle does not need a service.\nDistance traveled since "
                + "last service: 0km\nFuel economy: 0.0L per 100KM";
        assertEquals(expected, kuruma.printDetails());
    }
    
}
