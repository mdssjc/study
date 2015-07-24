/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.mdssjc.algorithms.chapter01;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcelo dos Santos <mdssjc@gmail.com>
 */
public class LinkedStackOfStringsTest {
    
    public LinkedStackOfStringsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of push method, of class LinkedStackOfStrings.
     */
    @org.junit.Test
    public void testPush() {
        System.out.println("push");
        String item = "";
        LinkedStackOfStrings instance = new LinkedStackOfStrings();
        instance.push(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pop method, of class LinkedStackOfStrings.
     */
    @org.junit.Test
    public void testPop() {
        System.out.println("pop");
        LinkedStackOfStrings instance = new LinkedStackOfStrings();
        String expResult = "";
        String result = instance.pop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class LinkedStackOfStrings.
     */
    @org.junit.Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        LinkedStackOfStrings instance = new LinkedStackOfStrings();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class LinkedStackOfStrings.
     */
    @org.junit.Test
    public void testSize() {
        System.out.println("size");
        LinkedStackOfStrings instance = new LinkedStackOfStrings();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
