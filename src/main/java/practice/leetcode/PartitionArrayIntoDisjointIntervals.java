/*
 * Author: Kartik Gola
 * Date: 7/23/21, 3:07 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class PartitionArrayIntoDisjointIntervals {

    public int partitionDisjoint(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = nums[0];
        for (int i = 1; i < nums.length; ++i)
            max[i] = Math.max(max[i-1], nums[i]);

        min[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i > -1; --i)
            min[i] = Math.min(min[i+1], nums[i]);

        int left = 0;
        while (left < nums.length-1 && max[left] > min[left+1])
            ++left;

        return left+1;
    }
}
