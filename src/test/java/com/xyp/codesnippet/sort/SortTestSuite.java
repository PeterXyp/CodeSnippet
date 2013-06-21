package com.xyp.codesnippet.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Peter Xu
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BubbleSortTest.class, InsertionSortTest.class, MergeSortTest.class,
    QuickSortTest.class, SelectionSortTest.class, ShellSortTest.class
})
public class SortTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
        int size = 100000;
        int[] arrayToSort = generateRandomArray(size);
//        int[] arrayToSort = generateSortedArray(size);
//        int[] arrayToSort = generateReverseArray(size);
        
        BubbleSortTest.arrayToSort = Arrays.copyOf(arrayToSort, size);
        InsertionSortTest.arrayToSort = Arrays.copyOf(arrayToSort, size);
        MergeSortTest.arrayToSort = Arrays.copyOf(arrayToSort, size);
        QuickSortTest.arrayToSort = Arrays.copyOf(arrayToSort, size);
        SelectionSortTest.arrayToSort = Arrays.copyOf(arrayToSort, size);
        ShellSortTest.arrayToSort = Arrays.copyOf(arrayToSort, size);
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    protected static int[] generateRandomArray(int size){
        int[] arrayToSort = new int[size];
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            arrayToSort[i] = rd.nextInt(size);
        }
        return arrayToSort;
    }
    
    private static int[] generateSortedArray(int size){
        int[] arrayToSort = new int[size];
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            arrayToSort[i] = rd.nextInt(size);
        }
        Arrays.sort(arrayToSort);
        System.out.println(Arrays.toString(arrayToSort));
        return arrayToSort;
    }
    private static int[] generateReverseArray(int size){
        Integer[] array = new Integer[size];
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rd.nextInt(size);
        }

        Arrays.sort(array, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2){
                    return 1;
                } else if (o1 > o2){
                    return -1;
                } else{
                    return 0;
                }
            }
        });
        int[] arrayToSort = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayToSort[i] = array[i];
            
        }
        System.out.println(arrayToSort);
        return arrayToSort;
    }
}