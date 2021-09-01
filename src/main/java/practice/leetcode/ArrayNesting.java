/*
 * Author: Kartik Gola
 * Date: 9/1/21, 10:41 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class ArrayNesting {

    public int arrayNesting(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        int ans = 0;

        for (int i = 0; i < nums.length; ++i) {
            int size = 0;
            int j = i;
            while (!vis[j]) {
                vis[j] = true;
                j = nums[j];
                size++;
            }
            ans = Math.max(ans, size);
        }

        return ans;
    }
}
