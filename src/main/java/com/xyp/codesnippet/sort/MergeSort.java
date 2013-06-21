package com.xyp.codesnippet.sort;

import java.util.Arrays;

/**
 *
 * @author Peter Xu
 */
public class MergeSort {

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int middle = array.length / 2;
        int[] array1 = Arrays.copyOfRange(array, 0, middle);
        int[] array2 = Arrays.copyOfRange(array, middle, array.length);
        int[] sortedArray1 = mergeSort(array1);
        int[] sortedArray2 = mergeSort(array2);
        return merge(sortedArray1, sortedArray2);
    }

    private static int[] merge(int[] array1, int[] array2) {
        int len1 = array1.length;
        int len2 = array2.length;
        int[] result = new int[len1 + len2];
        int idx = 0;
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            if (array1[i] <= array2[j]) {
                result[idx++] = array1[i++];
            } else {
                result[idx++] = array2[j++];
            }
        }
        //if array1 reach the last element first
        //then put the remaining elments of array2 into result array
        //vice versa
        if (i == len1) {
            while (j < len2) {
                result[idx++] = array2[j++];
            }
        } else {
            while (i < len1) {
                result[idx++] = array1[i++];
            }
        }
        return result;
    }
}
