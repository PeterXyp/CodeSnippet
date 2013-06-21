package com.xyp.codesnippet.sort;

/**
 *
 * @author Peter Xu
 */
public class QuickSort {

    public static void quickSort(int[] array){
        quickSort(array, 0, array.length - 1);
    }
    
    private static void quickSort(int[] array, int low, int high) {
        if (low > high){
            return;
        }
        int index = partition1(array, low, high);
        quickSort(array, low, index - 1);
        quickSort(array, index + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int key = array[low];
        while (low < high) {
            while (array[high] > key && low < high) {
                high--;
            }
            array[low] = array[high];
            while (array[low] <= key && low < high) {
                low++;
            }
            array[high] = array[low];
        }
        array[high] = key;
        return high;
    }
    
    private static int partition1(int[] array, int low, int high) {
        int key = array[low];
        while(low < high){
            for (; high > low; high--) {
                if (array[high] <= key){
                    array[low] = array[high];
                    break;
                }
            }
            for (; low < high; low++) {
                if (array[low] > key){
                    array[high] = array[low];
                    break;
                }
            }
        }
        array[high] = key;
        return high;
    }
}
