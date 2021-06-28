/*
 * Author: Kartik Gola
 * Date: 22/09/2020, 19:29
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/majority-element/
 */

package leetcode;

public class MajorityElement {

    private int count(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for ( int i = lo; i <= hi; ++i ) {
            if ( nums[i] == num ) {
                ++count;
            }
        }
        return count;
    }

    private int majority(int[] nums, int lo, int hi) {
        if ( lo == hi )
            return nums[lo];

        final int mid = (hi - lo) / 2 + lo;
        final int left = majority(nums, lo, mid);
        final int right = majority(nums, mid + 1, hi);

        if ( left == right )
            return left;

        final int leftCount = count(nums, left, lo, hi);
        final int rightCount = count(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majority(nums, 0, nums.length - 1);
    }

}
