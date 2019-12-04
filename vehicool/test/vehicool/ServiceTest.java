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
public class ServiceTest {
    
    Service sally;
    
    @Before
    public void initialize(){
        sally = new Service();
    }

    @Test
    public void testServiceNeededGreater() {
        boolean needsService = sally.serviceNeeded(30000, 1);
        assertEquals(true, needsService);
    }

    @Test
    public void testServiceNeededLesser() {
        boolean needsNoService = sally.serviceNeeded(10000, 2);
        assertEquals(false, needsNoService);
    }

    @Test
    public void testServiceNeededEqual() {
        boolean needsService = sally.serviceNeeded(20000, 2);
        assertEquals(true, needsService);
    }

    @Test
    public void testServiceNeededsub10k() {
        boolean needsService = sally.serviceNeeded(4956, 2);
        assertEquals(false, needsService);
    }
    
    @Test
    public void testprintServiceNeededGreater() {
        String needsService = sally.printServiceNeeded(30000, 1);
        assertEquals("This vehicle is due for a service.", needsService);
    }

    @Test
    public void testprintServiceNeededLesser() {
        String needsNoService = sally.printServiceNeeded(10000, 2);
        assertEquals("This vehicle does not need a service.", needsNoService);
    }

    @Test
    public void testprintServiceNeededEqual() {
        String needsService = sally.printServiceNeeded(20000, 2);
        assertEquals("This vehicle is due for a service.", needsService);
    }
    
}
