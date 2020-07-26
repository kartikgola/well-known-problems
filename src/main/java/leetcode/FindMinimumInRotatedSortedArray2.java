/*
 * Author: Kartik Gola
 * Date: 7/26/20 12:45 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */

package leetcode;

public class FindMinimumInRotatedSortedArray2 {

    public int findMinRec(int[] nums) {
        return findMinRec(nums, 0, nums.length - 1);
    }

    private int findMinRec(int[] nums, int left, int right) {
        if ( left >= right )
            return Math.min(nums[left], nums[right]);
        int mid = left + (right - left) / 2;
        // We cannot compare mid with left because it can fool us into going on wrong side
        // Example, 2,3,4,1,1 => mid > left, so we go right?
        //          1,2,4,5,6 => mid > left, so we go left?
        if ( nums[mid] < nums[right] ) {
            return findMinRec(nums, left, mid);
        } else if ( nums[mid] > nums[right] ) {
            return findMinRec(nums, mid + 1, right);
        } else {
            return Math.min(findMinRec(nums, left, mid), findMinRec(nums, mid + 1, right));
        }
    }

    public int findMinIter(int[] nums) {
        int left = 0,
                right = nums.length - 1;

        while ( left < right ) {
            int mid = left + (right - left) / 2;
            if ( nums[mid] < nums[right] ) {
                right = mid;
            } else if ( nums[mid] > nums[right] ) {
                left = mid + 1;
            } else {
                right = right - 1;
            }
        }

        return nums[left];
    }
}
