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
public class ShellSortTest {
    
    static int[] arrayToSort = SortTestSuite.generateRandomArray(10);
    
    public ShellSortTest() {
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
     * Test of shellSort method, of class ShellSort.
     */
    @Test
    public void testShellSort() {
        long start = System.currentTimeMillis();
        ShellSort.shellSort(arrayToSort);
        long end = System.currentTimeMillis();
        long consume = end - start;
        System.out.println("shell sort consume:"+ consume);
    }
}