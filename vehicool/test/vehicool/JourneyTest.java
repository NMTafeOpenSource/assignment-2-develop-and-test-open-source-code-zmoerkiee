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
public class JourneyTest {
    
    Journey jeb;
    
    @Before
    public void initialize(){
        Journey jeb = new Journey();
    }

    @Test
    public void testDistanceGreater(){
        int dist = jeb.distance(2400, 2000);
        assertEquals(400, dist);
    }

    @Test
    public void testDistanceLesser(){
        int dist = jeb.distance(2400, 2500);
        assertEquals(-100, dist);
    }

    @Test
    public void testDistanceEqual(){
        int dist = jeb.distance(2000, 2000);
        assertEquals(0, dist);
    }
    
}
