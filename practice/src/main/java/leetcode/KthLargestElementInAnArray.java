/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Random;

public class KthLargestElementInAnArray {

    Random rand = new Random();

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    int partition(int[] nums, int lo, int hi, int randPvt) {
        int pvtElem = nums[randPvt];
        swap(nums, randPvt, hi);
        int i = lo;

        for ( int j = lo; j <= hi; ++j ) {
            if ( nums[j] < pvtElem ) {
                swap(nums, j, i);
                ++i;
            }
        }

        swap(nums, i, hi);
        return i;
    }

    int quickSelect(int[] nums, int lo, int hi, int k) {
        if ( lo < hi ) {
            int randPvt = lo + rand.nextInt(hi - lo);
            int part = partition(nums, lo, hi, randPvt);

            if ( part == k )
                return nums[part];
            else if ( part > k )
                return quickSelect(nums, lo, part - 1, k);
            else
                return quickSelect(nums, part + 1, hi, k);
        } else {
            return nums[lo];
        }
    }

    public int findKthLargest(int[] nums, int k) {
        final int n = nums.length;
        // Largest kth element is located at index = n-k
        // Consequently, smallest kth element is located at index = k-1
        return quickSelect(nums, 0, n - 1, n - k);
    }

}