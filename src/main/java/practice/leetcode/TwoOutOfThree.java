/*
 * Author: Kartik Gola
 * Date: 12/18/21, 3:14 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TwoOutOfThree {

    private int[] map(int[] nums) {
        int[] ans = new int[101];
        for (int x: nums)
            ans[x]++;
        return ans;
    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new ArrayList<>();
        int[] m1 = map(nums1);
        int[] m2 = map(nums2);
        int[] m3 = map(nums3);

        for (int i = 1; i <= 100; ++i) {
            int flag = 0;
            if (m1[i] > 0)
                flag++;
            if (m2[i] > 0)
                flag++;
            if (m3[i] > 0)
                flag++;
            if (flag >= 2)
                ans.add(i);
        }

        return ans;
    }
}
