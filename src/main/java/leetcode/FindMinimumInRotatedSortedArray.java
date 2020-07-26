/*
 * Author: Kartik Gola
 * Date: 24/07/20, 8:38 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */

package leetcode;

class FindMinimumInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while ( left <= right ) {
            int mid = left + (right - left) / 2;
            if ( nums[mid] == target )
                return mid;
            // 3 4 5 6 7 1 2
            // l     m     r
            else if ( nums[mid] >= nums[left] ) {
                if ( nums[left] <= target && target < nums[mid] )
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                // 6 7 1 2 3 4 5
                // l     m     r
                if ( nums[right] >= target && target > nums[mid] )
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
