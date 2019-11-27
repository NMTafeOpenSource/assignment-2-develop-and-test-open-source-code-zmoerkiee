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
public class JourneyTest {
    
    public JourneyTest() {
    }

    @Test
    public void testAddKilometers() {
        Journey janet = new Journey();
        janet.addKilometers(50);
        assertEquals(50, janet.getKilometers(), 0);
    }
    
}
