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
public class ServiceTest {
    
    public ServiceTest() {
    }

    @Test
    public void testRecordService() {
        Vehicle vroom = new Vehicle("Ford", "Taurus", 1996, "1EPK496", 200000, 40);
        Service sally = new Service();
        sally.recordService(vroom.getOdo());
        assertEquals(200000, sally.getLastServiceOdometerKm());
        assertEquals(1, sally.getServiceCount());
    }

    @Test
    public void testGetTotalScheduledServices() {
        Vehicle vroom = new Vehicle("Ford", "Taurus", 1996, "1EPK496", 200000, 40);
        Service sally = new Service();
        sally.recordService(vroom.getOdo());
        assertEquals(20, sally.getTotalScheduledServices());
    }
    
}
