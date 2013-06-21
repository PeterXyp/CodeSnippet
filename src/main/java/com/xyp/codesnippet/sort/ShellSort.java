package com.xyp.codesnippet.sort;

/**
 *
 * @author Peter Xu
 */
public class ShellSort {

    public static void shellSort(int[] array) {
        int len = array.length;
        int span = 0;
        while (span < len) {
            span = span * 3 + 1;
        }

        while (span > 0) {
            for (int i = span; i < len; i++) {
                for (int j = i; j >= span; j = j - span) {
                    if (array[j] < array[j - span]) {
                        int temp = array[j];
                        array[j] = array[j - span];
                        array[j - span] = temp;
                    }
                }
            }
            span = span / 3;
        }
    }
}
