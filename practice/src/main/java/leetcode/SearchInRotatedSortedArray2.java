/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class SearchInRotatedSortedArray2 {

    public boolean search(int[] nums, int target) {
        int l = 0,
            r = nums.length - 1,
            m = -1;

        while ( l <= r ) {
            m = l + (r - l) / 2;
            if ( nums[m] == target )
                return true;

            // right part is sorted
            if ( nums[m] < nums[r] ) {
                if ( target > nums[m] && target <= nums[r] )
                    l = m + 1;
                else
                    r = m - 1;
            } else if ( nums[m] > nums[r] ) {
                // left part is sorted
                if ( target < nums[m] && target >= nums[l] )
                    r = m - 1;
                else
                    l = m + 1;
            } else {
                r = r - 1;
            }
        }

        return false;
    }
}
