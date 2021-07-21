/*
 * Author: Kartik Gola
 * Date: 10/10/2020, 12:06
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/binary-search/
 */

package practice.leetcode;

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
