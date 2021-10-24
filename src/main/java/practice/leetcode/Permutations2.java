/*
 * Author: Kartik Gola
 * Date: 10/24/21, 12:12 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.*;

public class Permutations2 {

    private List<List<Integer>> permuteUnique(int[] nums, Set<String> vis, int i) {
        List<List<Integer>> ans = new ArrayList<>();
        if (i == nums.length) {
            ans.add(new ArrayList<>());
            return ans;
        }
        for (List<Integer> sub: permuteUnique(nums, vis, i+1)) {
            for (int j = 0; j <= sub.size(); ++j) {
                List<Integer> temp = new ArrayList<>(sub);
                if (j == sub.size())
                    temp.add(nums[i]);
                else
                    temp.add(j, nums[i]);
                String key = temp.toString();
                if (vis.contains(key))
                    continue;
                vis.add(key);
                ans.add(temp);
            }
        }
        return ans;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        return permuteUnique(nums, new HashSet<>(), 0);
    }

}
