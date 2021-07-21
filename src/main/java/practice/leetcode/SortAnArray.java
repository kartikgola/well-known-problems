/*
 * Author: Kartik Gola
 * Date: 15/07/20, 11:26 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.Random;

public class SortAnArray {

    Random rand = new Random();

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int partition(int[] nums, int lo, int hi, int pvt) {
        int pvtElem = nums[pvt];
        swap(nums, pvt, hi);
        int i = lo;
        for ( int j = lo; j <= hi; ++j ) {
            if ( nums[j] < pvt ) {
                swap(nums, j, i);
                ++i;
            }
        }
        swap(nums, i, hi);
        return i;
    }

    private void sort(int[] nums, int lo, int hi) {
        if ( lo < hi ) {
            int pvt = lo + rand.nextInt(hi - lo);
            pvt = partition(nums, lo, hi, pvt);
            sort(nums, pvt - 1, lo);
            sort(nums, pvt + 1, hi);
        }
    }

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }
}
