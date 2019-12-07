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
        boolean needsService = sally.serviceNeeded(35000, 20000);
        assertEquals(true, needsService);
    }

    @Test
    public void testServiceNeededLesser() {
        boolean needsNoService = sally.serviceNeeded(10000, 20000);
        assertEquals(false, needsNoService);
    }

    @Test
    public void testServiceNeededEqual() {
        boolean needsNoService = sally.serviceNeeded(20000, 20000);
        assertEquals(false, needsNoService);
    }

    @Test
    public void testServiceNeededExact() {
        boolean needsService = sally.serviceNeeded(30000, 20000);
        assertEquals(true, needsService);
    }
    
    @Test
    public void testPrintServiceNeededGreater() {
        String needsService = sally.printServiceNeeded(35000, 10000);
        assertEquals("This vehicle is due for a service.", needsService);
    }

    @Test
    public void testPrintServiceNeededLesser() {
        String needsNoService = sally.printServiceNeeded(10000, 20000);
        assertEquals("This vehicle does not need a service.", needsNoService);
    }

    @Test
    public void testPrintServiceNeededExact() {
        String needsService = sally.printServiceNeeded(30000, 20000);
        assertEquals("This vehicle is due for a service.", needsService);
    }

    @Test
    public void testPrintServiceNeededEqual() {
        String needsNoService = sally.printServiceNeeded(20000, 20000);
        assertEquals("This vehicle does not need a service.", needsNoService);
    }
    
}
