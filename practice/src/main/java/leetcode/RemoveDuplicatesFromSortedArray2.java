/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class RemoveDuplicatesFromSortedArray2 {

    public int removeDuplicates(int[] nums) {
        final int n = nums.length;
        final int k = 2; // max permissible repetitions
        if (n <= k) return n;

        int count = 1; // stores current count of occurances
        int prev = 0;  // stores previous write index

        for (int i = 1; i < n; ++i) {
            if (nums[i] != nums[i - 1]) {
                // fill up min(count, k) positions with previous value
                for (int j = prev; j < prev + Math.min(count, k); ++j)
                    nums[j] = nums[i - 1];
                // increase prev and reset count
                prev += Math.min(count, k);
                count = 1;
            } else ++count;
        }

        // At this point, it can be [x x x y] or [x x x y y] or [x y z] or [x y y]
        for (int j = prev; j < prev + Math.min(count, k); ++j)
            nums[j] = nums[n - 1];
        prev += Math.min(count, k);

        return prev;
    }
}
