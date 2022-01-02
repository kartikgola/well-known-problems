/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class FindFirstAndLastPositionOfElementInSortedArray {

    private int l(int[] nums, int x, int i, int j) {
        while (i < j) {
            int m = i+(j-i)/2;
            if (nums[m] == x) {
                int k = l(nums, x, i, m-1);
                return k == -1 ? m : k;
            } else if (nums[m] > x) {
                return l(nums, x, i, m-1);
            } else {
                return l(nums, x, m+1, j);
            }
        }
        return nums[i] == x ? i : -1;
    }

    private int r(int[] nums, int x, int i, int j) {
        while (i < j) {
            int m = i+(j-i)/2;
            if (nums[m] == x) {
                int k = r(nums, x, m+1, j);
                return k == -1 ? m : k;
            } else if (nums[m] > x) {
                return r(nums, x, i, m-1);
            } else {
                return r(nums, x, m+1, j);
            }
        }
        return nums[i] == x ? i : -1;
    }

    public int[] searchRange(int[] nums, int x) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        return new int[]{l(nums, x, 0, nums.length-1), r(nums, x, 0, nums.length-1)};
    }
}
