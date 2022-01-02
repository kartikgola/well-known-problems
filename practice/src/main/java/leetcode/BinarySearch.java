/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class BinarySearch {

    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while ( i <= j ) {
            int m = i + (j - i) / 2;
            if ( nums[m] == target )
                return m;
            else if ( nums[m] < target ) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return -1;
    }
}
