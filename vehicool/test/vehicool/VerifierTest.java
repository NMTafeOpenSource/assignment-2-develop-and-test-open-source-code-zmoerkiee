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
public class VerifierTest {
    
    
    Verifier v;
    
    @Before
    public void initialize(){
        v = new Verifier();
    }

    @Test
    public void testChkDubIsString() {
        assertEquals(false, v.chkDub("champin'"));
    }

    @Test
    public void testChkDubIsBlank() {
        assertEquals(false, v.chkDub(""));
    }

    @Test
    public void testChkDubIsInt() {
        assertEquals(true, v.chkDub("22"));
    }

    @Test
    public void testChkDubIsDouble() {
        assertEquals(true, v.chkDub("22.22"));
    }
    
    @Test
    public void testChkDubIsNegative() {
        assertEquals(false, v.chkDub("-22"));
    }

    @Test
    public void testChkIntIsString() {
        assertEquals(false, v.chkInt("champin'"));
    }

    @Test
    public void testChkIntIsBlank() {
        assertEquals(false, v.chkInt(""));
    }

    @Test
    public void testChkIntIsInt() {
        assertEquals(true, v.chkInt("22"));
    }

    @Test
    public void testChkIntIsDouble() {
        assertEquals(false, v.chkInt("22.22"));
    }
    
    @Test
    public void testChkIntIsNegative() {
        assertEquals(false, v.chkInt("-22"));
    }

    @Test
    public void testChkStringIsString() {
        assertEquals(true, v.chkString("champin'"));
    }

    @Test
    public void testChkStringIsBlank() {
        assertEquals(false, v.chkString(""));
    }

    @Test
    public void testChkStringIsInt() {
        assertEquals(true, v.chkString("22"));
    }

    @Test
    public void testChkStringIsDouble() {
        assertEquals(true, v.chkString("22.22"));
    }
    
    @Test
    public void testChkStringIsNegative() {
        assertEquals(true, v.chkString("-22"));
    }
    
}
