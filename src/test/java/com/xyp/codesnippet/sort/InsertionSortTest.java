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
public class InsertionSortTest {
    
    static int[] arrayToSort = SortTestSuite.generateRandomArray(10);
    
    public InsertionSortTest() {
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
     * Test of insertionSort method, of class InsertionSort.
     */
    @Test
    public void testInsertionSort() {
        long start = System.currentTimeMillis();
        InsertionSort.insertionSort(arrayToSort);
        long end = System.currentTimeMillis();
        long consume = end - start;
        System.out.println("insertion sort consume:"+ consume);
    }
}