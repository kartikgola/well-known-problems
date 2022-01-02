/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class SortColors {

    // O(n^2) approach
    // Keep the array sorted & rotate right whenever a number is misplaced
    public void sortColors(int[] nums) {
        // pre[i] = previous index of nums[i] OR previous index of max(nums[i]-1, nums[i]-2) if nums[i] is not present
        int[] pre = new int[]{-1,-1,-1};
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            int p = pre[num];
            // 0,0,1,1,2,2,0
            if (p == -1) {
                if (num == 1)
                    p = pre[0];
                else if (num == 2)
                    p = pre[1] != -1 ? pre[1] : pre[0];
            }
            // rotate-right the values in nums[p+1, i-1]
            for (int j = i-1; j > p; --j) {
                int curr = nums[j];
                nums[j+1] = curr;
                pre[curr] = Math.max(pre[curr], j+1);
            }
            nums[p+1] = num;
            pre[num] = p+1;
        }
    }

    // O(n) 1-pass approach
    public void sortColors2(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        for (int i = 0; i <= blue; i++) {
            if (nums[i] == 0) {
                swap(nums, i, red);
                red++;
            } else if (nums[i] == 2) {
                swap(nums, i, blue);
                i--;
                blue--;
            }
        }
    }
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
