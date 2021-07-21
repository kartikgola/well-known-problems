/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

public class FirstAndLastPositionOfElementInSortedArray {

    private int findOccurance(int[] nums, int target, boolean first) {
        int i = 0, j = nums.length - 1;
        int p = -1;
        while ( i < j ) {
            int m = i + (j - i) / 2;
            if ( nums[m] > target ) {
                j = m - 1;
            } else if ( nums[m] < target ) {
                i = m + 1;
            } else {
                p = m;
                if ( first ) j = m - 1;
                else i = m + 1;
            }
        }
        return nums[i] == target ? i : p;
    }

    public int[] searchRange(int[] nums, int target) {
        if ( nums.length == 0 )
            return new int[]{-1, -1};
        return new int[]{findOccurance(nums, target, true), findOccurance(nums, target, false)};
    }

}
