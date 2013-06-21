package com.xyp.codesnippet.sort;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Peter Xu
 */
public class BubbleSortTest {
    
    static int[] arrayToSort = SortTestSuite.generateRandomArray(10);

    public BubbleSortTest() {
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
     * Test of bubbleSort method, of class BubbleSort.
     */
    @Test
    public void testBubbleSort() {
        long start = System.currentTimeMillis();
        BubbleSort.bubbleSort(arrayToSort);
        long end = System.currentTimeMillis();
        long consume = end - start;
        System.out.println("bubble sort consume:"+ consume);
    }
}