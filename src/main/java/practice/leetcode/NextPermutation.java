/*
 * Author: Kartik Gola
 * Date: 08/02/2021, 00:13
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/next-permutation/
 */

package practice.leetcode;

public class NextPermutation {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j)
            swap(nums, i++, j--);
    }

    public void nextPermutation(int[] nums) {
        final int n = nums.length;
        int i = n - 1;

        // Example => 3,2,2,5,4,1,0
        // Indices => 0,1,2,3,4,5,6
        // Keep moving from right to left till left > right
        while (i-1 >= 0 && nums[i-1] >= nums[i])
            --i;
        // Now, i = 3

        // In case we did not find any greater number on the left
        // we reverse the order and return
        if (i-1 == -1) {
            reverse(nums, i, n-1);
        } else {
            // Numbers in the range [i, n-1] are now already present in decreasing order
            // Move from right to left in this range & find an index 'j' such nums[j] > nums[i-1]
            int j = n - 1;
            while (j > i && nums[j] <= nums[i-1])
                --j;

            // Swap the number at 'j' and 'i-1'
            swap(nums, i-1, j);

            // Reverse the subarray in range [i, n-1] since this is in decreasing order
            // and next permutation should be in increasing order
            reverse(nums, i, n-1);
        }
    }
}
