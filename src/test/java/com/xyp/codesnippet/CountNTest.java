package com.xyp.codesnippet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter Xu
 */
public class CountNTest {
    
    public CountNTest() {
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
     * Test of countNumber method, of class CountN.
     */
    @Test
    public void testCountNumber() {
        System.out.println("countNumber");
        int num = 1010;
        int digitToFind = 0;
        int expResult = 2;
        int result = CountN.countNumber(num, digitToFind);
        assertEquals(expResult, result);
    }
}
