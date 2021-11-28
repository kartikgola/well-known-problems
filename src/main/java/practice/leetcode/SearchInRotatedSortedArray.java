/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        while (l < r) {
            int m = l+(r-l)/2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < nums[r]) {
                if (target <= nums[r] && target > nums[m])
                    l = m+1;
                else
                    r = m-1;
            } else {
                if (target >= nums[l] && target < nums[m])
                    r = m-1;
                else
                    l = m+1;
            }
        }

        return nums[l] == target ? l : -1;
    }

}
