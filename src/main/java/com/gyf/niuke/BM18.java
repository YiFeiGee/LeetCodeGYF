package com.gyf.niuke;

/**
 * 二维数组中的查找
 */
public class BM18 {

    public boolean Find (int target, int[][] array) {
        // write code here
        if (array == null) {
            return false;
        }
        int m = array.length - 1;
        int n = 0;
        while (m >= 0 && n < array[0].length) {
            if (array[m][n] < target) {
                n++;
            } else if (array[m][n] > target) {
                m--;
            } else {
                return true;
            }
        }
        return false;
    }

}
