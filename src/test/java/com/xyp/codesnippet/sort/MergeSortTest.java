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
public class MergeSortTest {
    
    static int[] arrayToSort = SortTestSuite.generateRandomArray(10);
    
    public MergeSortTest() {
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
     * Test of mergeSort method, of class MergeSort.
     */
    @Test
    public void testMergeSort() {
        long start = System.currentTimeMillis();
        arrayToSort = MergeSort.mergeSort(arrayToSort);
        long end = System.currentTimeMillis();
        long consume = end - start;
        System.out.println("merge sort consume:"+ consume);
    }
}