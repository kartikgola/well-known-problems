/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;

public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        final int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        //     i j     k
        // 1 2 5 10 11 13 15 20
        //     i j  k
        // 1 2 5 10 20 20 20 20
        //     i j           k
        // 1 2 5 10 13 13 13 13
        //     i j  k
        // 1 2 5 10 13 15 20 25
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n-1; ++j) {
                int ab = nums[i] + nums[j];
                int k = Arrays.binarySearch(nums, j+1, n, ab-1);
                if (k < 0) k = -1*(k+1);

                // In case of perfect match, move to the right-most index
                if (k < n && nums[k] == ab-1)
                    while (k+1 < n && nums[k+1] == nums[k]) ++k;

                // In case of perfect match, we need to add 1 since the index is inclusive
                if (k < n && nums[k] == ab-1)
                    ans += k-(j+1)+1;
                else
                    ans += k-(j+1);
            }
        }

        return ans;
    }
}
