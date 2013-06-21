package com.xyp.codesnippet.sort;

/**
 *
 * @author Peter Xu
 * Bubble Sort A[0..n]
 * FOR i = n-1 to 1
 *   FOR j = 0 to i
 *     if A[j] > A[j+1]
 *       swap(A[j],A[j+1])
 */
public class BubbleSort {

    public static void bubbleSort(int[] arrayToSort){
        int len = arrayToSort.length;
        for (int i = len - 1; i > 0; i--) {
            for (int j = 0; j < i; j++){
                if (arrayToSort[j] > arrayToSort[j + 1]){
                    int temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = temp;
                }
            }
        }
    }
}
