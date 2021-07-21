/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int l = 0,
            r = nums.length - 1,
            m = -1;

        while ( l <= r ) {
            m = l + (r - l) / 2;
            int left = nums[l], mid = nums[m], right = nums[r];

            if ( mid == target )
                return m;

            // right part is sorted
            if ( mid < right ) {
                if ( target > mid && target <= right )
                    l = m + 1;
                else
                    r = m - 1;
            } else {
                // left part is sorted
                if ( target < mid && target >= left )
                    r = m - 1;
                else
                    l = m + 1;
            }
        }

        return -1;
    }

}
