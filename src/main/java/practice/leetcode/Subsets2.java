/*
 * Author: Kartik Gola
 * Date: 10/23/21, 3:13 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.*;

public class Subsets2 {

    // Approach 1 - Iterate using bitmask
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        final int n = nums.length;
        final int k = 1 << n;
        List<List<Integer>> ans = new ArrayList<>();
        Set<String> vis = new HashSet<>();
        // Sort first, to ensure there are no duplicates
        // Example, [2,1,2] can create 2 duplicates like [2], [2]
        Arrays.sort(nums);

        // Check all possible bitmask combinations
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

    private List<List<Integer>> subsetsWithDup2(int[] nums, int i) {
        List<List<Integer>> ans = new ArrayList<>();
        if (i == nums.length) {
            ans.add(new ArrayList<>());
            return ans;
        }
        List<List<Integer>> sub = subsetsWithDup2(nums, i+1);
        ans.addAll(sub);
        for (List<Integer> al: sub) {
            List<Integer> temp = new ArrayList<>(al);
            temp.add(nums[i]);
            ans.add(temp);
        }
        return ans;
    }

    // Approach 2 - Aggregate results of recursive calls
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        return new ArrayList<>(new HashSet<>(subsetsWithDup2(nums, 0)));
    }

    private final List<List<Integer>> ans = new ArrayList<>();

    private void subsetsWithDup3(int[] nums, int j, List<Integer> al) {
        Collections.sort(al);
        ans.add(al);
        for (int i = j; i < nums.length; ++i) {
            List<Integer> temp = new ArrayList<>(al);
            temp.add(nums[i]);
            subsetsWithDup3(nums, i+1, temp);
        }
    }

    // Approach 3 - Use global ans[][], and make each recursive call independent
    public List<List<Integer>> subsetsWithDup3(int[] nums) {
        subsetsWithDup3(nums, 0, new ArrayList<>());
        return new ArrayList<>(new HashSet<>(ans));
    }
}
