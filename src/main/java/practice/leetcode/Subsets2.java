/*
 * Author: Kartik Gola
 * Date: 10/23/21, 3:13 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.*;

public class Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        final int n = nums.length;
        final int k = 1 << n;
        List<List<Integer>> ans = new ArrayList<>();
        Set<String> vis = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < k; ++i) {
            List<Integer> al = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; ++j) {
                int mask = 1 << j;
                if ((i & mask) > 0) {
                    sb.append(nums[j])
                            .append(",");
                    al.add(nums[j]);
                }
            }
            if (vis.contains(sb.toString()))
                continue;
            vis.add(sb.toString());
            ans.add(al);
        }

        return ans;
    }

    private List<List<Integer>> f(int[] nums, int i) {
        List<List<Integer>> ans = new ArrayList<>();
        if (i == nums.length) {
            ans.add(new ArrayList<>());
            return ans;
        }
        List<List<Integer>> sub = f(nums, i+1);
        ans.addAll(sub);
        for (List<Integer> al: sub) {
            List<Integer> temp = new ArrayList<>(al);
            temp.add(nums[i]);
            ans.add(temp);
        }
        return ans;
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        return new ArrayList<>(new HashSet<>(f(nums, 0)));
    }
}
