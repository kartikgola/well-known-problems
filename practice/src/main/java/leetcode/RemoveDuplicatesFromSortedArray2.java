/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class RemoveDuplicatesFromSortedArray2 {

    public int removeDuplicates(int[] nums) {
        int j = 1; // write head
        int prev = 0; // previous number to compare current number with

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[prev]) {
                if (i-prev < 2) {
                    nums[j++] = nums[i];
                } // else do nothing
            } else {
                nums[j++] = nums[i];
                prev = i;
            }
        }

        return j;
    }
}
