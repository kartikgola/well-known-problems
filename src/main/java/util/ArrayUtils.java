/*
 * Author: Kartik Gola
 * Date: 08/02/2021, 00:14
 * Copyright (c) 2021 | https://rattl.io
 */

package util;

public class ArrayUtils {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] maxKIndices(int[] nums, int k) {
        k = Math.min(k, nums.length);
        int[] ans = new int[k];
        for (int i = 0; i < nums.length; ++i) {
            int p = i;
            for (int j = 0; j < ans.length; ++j) {
                if (nums[p] >= nums[ans[j]]) {
                    int temp = ans[j];
                    ans[j] = p;
                    p = temp;
                }
            }
        }
        return ans;
    }

    public static int[] minKIndices(int[] nums, int k) {
        k = Math.min(k, nums.length);
        int[] ans = new int[k];
        for (int i = 0; i < nums.length; ++i) {
            int p = i;
            for (int j = 0; j < ans.length; ++j) {
                if (nums[p] <= nums[ans[j]]) {
                    int temp = ans[j];
                    ans[j] = p;
                    p = temp;
                }
            }
        }
        return ans;
    }
}
