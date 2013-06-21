package com.xyp.codesnippet;

/**
 *
 * @author Peter Xu
 */
public class CountN {

    /**
     * @param num the number to process
     * @param digitToFind the digit to find from the number
     * @return the count of digit found from the number
     */
    public static int countNumber(int num, int digitToFind) {
        return countNumber(num, digitToFind, 0);
    }
    
    /**
     * @param quotient the number to process every recursion
     * @param digitToFind the digit to find from the number
     * @param count digit found from the number every recursion
     * @return 
     */
    private static int countNumber(int quotient, int digitToFind, int count) {
        if ((quotient % 10) == digitToFind) {
            count++;
        }
        if (quotient >= 10) {
            count = countNumber(quotient / 10, digitToFind, count);
        }
        return count;
    }
}