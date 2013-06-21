package com.xyp.codesnippet.sort;

/**
 *
 * @author Peter Xu
 * Selection Sort A[1..n]
 * FOR i = 1 TO n-1
 *   min = i //index that store the minimal value
 *   FOR j = i+1 TO n
 *     if A[j] < A[min]
 *       min = j
 *   swap(A[i],A[min])
 */
public class SelectionSort {
    
    public static void selectionSort(int[] arrayToSort){
        int len = arrayToSort.length;
        int min;
        for (int i = 0; i < len - 1; i++) {
            min = i;
            for (int j = i + 1; j < len; j++) {
                if (arrayToSort[j] < arrayToSort[min]){
                    min = j;
                }
            }
            int temp = arrayToSort[i];
            arrayToSort[i] = arrayToSort[min];
            arrayToSort[min] = temp;
        }
    }
}
