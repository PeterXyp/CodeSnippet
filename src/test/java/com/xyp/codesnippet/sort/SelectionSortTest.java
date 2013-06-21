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
public class SelectionSortTest {
    
    static int[] arrayToSort = SortTestSuite.generateRandomArray(10);
    
    public SelectionSortTest() {
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
     * Test of selectionSort method, of class SelectionSort.
     */
    @Test
    public void testSelectionSort() {
        long start = System.currentTimeMillis();
        SelectionSort.selectionSort(arrayToSort);
        long end = System.currentTimeMillis();
        long consume = end - start;
        System.out.println("selection sort consume:"+ consume);
    }
}