/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

package leetcode;

public class FindFirstAndLastPositionOfElementInSortedArray {

    private int findFirst(int[] nums, int x) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            int m = l+(r-l)/2;
            // p(x) = middle value is greater than equal to x
            // this makes sure that l is always pointing to the least index that satisfies p(x)
            if (nums[m] >= x)
                r = m;
            else
                l = m+1;
        }
        // blank array condition
        if (l >= nums.length)
            return -1;
        return nums[l] == x ? l : -1;
    }

    private int findLast(int[] nums, int x) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            int m = l+(r-l)/2;
            // predicate = middle value is greater than equal to x+1
            // this makes sure that l is always pointing to the least index that satisfies p(x)
            if (nums[m] >= x+1)
                r = m;
            else
                l = m+1;
        }
        // blank array condition
        if (l >= nums.length)
            return -1;
        return nums[l] == x ? l : (l-1 >= 0 && nums[l-1] == x ? l-1 : -1);
    }

    public int[] searchRange(int[] nums, int x) {
        return new int[]{findFirst(nums, x), findLast(nums, x)};
    }
}
