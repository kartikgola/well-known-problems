/*
 * Author: Kartik Gola
 * Date: 10/24/21, 11:18 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

    private List<List<Integer>> permute(int[] nums, int i) {
        List<List<Integer>> ans = new ArrayList<>();
        if (i == nums.length) {
            ans.add(new ArrayList<>()); // [[]]
            return ans;
        }
        // Example, sub = [[2,3], [3,2]]
        // For each list in sub, add curr elem (say, 1) to all positions
        // [2,3] => [1,2,3], [2,1,3], [2,3,1]
        // [3,2] => [1,3,2], [3,1,2], [3,2,1]
        List<List<Integer>> sub = permute(nums, i+1);
        for (List<Integer> al: sub) {
            for (int j = 0; j <= al.size(); ++j) {
                List<Integer> temp = new ArrayList<>(al);
                temp.add(j, nums[i]);
                ans.add(temp);
            }
        }
        return ans;
    }

    // Approach 1 - Aggregate results of recursive calls
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
    }

    private List<List<Integer>> ans = new ArrayList<>();

    private void permute(int[] nums, int mask, List<Integer> al) {
        if ((mask == (1 << nums.length)-1)) {
            ans.add(al);
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if ((mask & (1 << i)) == 0) {
                List<Integer> temp = new ArrayList<>(al);
                temp.add(nums[i]);
                permute(nums, mask | (1 << i), temp);
            }
        }
    }

    // Approach 2 - Use global ans[][] and make each recursive call independent
    public List<List<Integer>> permute2(int[] nums) {
        permute(nums, 0, new ArrayList<>());
        return ans;
    }
}
