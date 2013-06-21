package com.xyp.codesnippet.sort;

/**
 *
 * @author Peter Xu
 * Insertion Sort A[1..n]
 * FOR i = 2 TO n
 *  key = A[i]
 *    //{PUT A[i] into the sorted sequence A[0..i-1]}
 *    WHILE i > 0 and key < A[i-1]
 *      A[i] = A[i-1]
 *      i--
 *    A[i] = key
 */
public class InsertionSort {
    
    public static void insertionSort(int[] arrayToSort){
        for (int i = 1; i < arrayToSort.length; i++) {
            int key = arrayToSort[i];
            while(i > 0 && key < arrayToSort[i - 1]){
                arrayToSort[i] = arrayToSort[i - 1];
                i--;
            }
            arrayToSort[i] = key;
        }
    }
}
