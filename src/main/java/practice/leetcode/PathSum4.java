/*
 * Author: Kartik Gola
 * Date: 10/18/21, 11:02 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class PathSum4 {

    private int ans = 0;

    private boolean isLeaf(int[] nums, int i) {
        return (2*i+1 >= nums.length || nums[2*i+1] == 999) && (2*i+2 >= nums.length || nums[2*i+2] == 999);
    }

    private void f(int[] nums, int sum, int i) {
        if (i >= nums.length || nums[i] == 999)
            return;
        sum += nums[i] % 10;
        f(nums, sum, 2*i+1);
        f(nums, sum, 2*i+2);
        if (isLeaf(nums, i))
            ans += sum;
    }

    public int pathSum(int[] nums) {
        int[] arr = new int[(1 << 4)-1];
        for (int i = 0, d = 1, p = 1, k = 0, j = 0; i < arr.length; ++i) {
            int node = 999;
            if (k < nums.length) {
                int x = nums[k];
                int pos = (x % 100) / 10;
                int dep = x / 100;
                if (dep == d && pos == p)
                    node = nums[k++];
            }
            arr[j++] = node;
            p++;
            if (i+1 == (1 << d)-1) {
                // depth increases when (1<<d) nodes are processed
                d++;
                // position resets to 1 at each new depth
                p = 1;
            }
        }
        f(arr, 0, 0);
        return ans;
    }
}
