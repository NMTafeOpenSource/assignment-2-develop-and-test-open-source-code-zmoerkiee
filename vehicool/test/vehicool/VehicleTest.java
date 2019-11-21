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
public class VehicleTest {
    
    public VehicleTest() {
    }
    
    
    @Test
    public void testAddKilos(){
        System.out.println("Testing AddKilos");
        Vehicle kuruma = new Vehicle("Ford", "Taurus", 1996, "1EPK496", 200000, 40.0);
        kuruma.addKilos(22222);
        assertEquals(222222, kuruma.getOdo());
    }
    
    @Test
    public void testOutOfFuel(){
        Vehicle kuruma = new Vehicle("Ford", "Taurus", 1996, "1EPK496", 200000, -40.0);
        assertEquals("Out of fuel!", kuruma.checkFuel());
    }
    
    @Test
    public void testHasFuel(){
        Vehicle kuruma = new Vehicle("Ford", "Taurus", 1996, "1EPK496", 200000, 40.0);
        assertEquals("This vehicle has 40.0 litres of fuel remaining", kuruma.checkFuel());
    }
    
}
