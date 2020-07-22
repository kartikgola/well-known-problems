/*
 * Author: Kartik Gola
 * Date: 6/25/20 7:05 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while ( slow != fast );

        slow = nums[0];
        while ( slow != fast ) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
