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
public class QuickSortTest {
    
    static int[] arrayToSort = SortTestSuite.generateRandomArray(10);
    
    public QuickSortTest() {
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
     * Test of quickSort method, of class QuickSort.
     */
    @Test
    public void testQuickSort() {
        long start = System.currentTimeMillis();
        QuickSort.quickSort(arrayToSort);
        long end = System.currentTimeMillis();
        long consume = end - start;
        System.out.println("quick sort consume:"+ consume);
    }
}