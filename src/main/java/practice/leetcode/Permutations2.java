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

    // Approach 1 - Gen. all permutations and keep Set<String> to mark seen
    // and aggregate results of recursive calls
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        return permuteUnique(nums, new HashSet<>(), 0);
    }

    private final Set<String> seen = new HashSet<>();
    private final List<List<Integer>> ans = new ArrayList<>();

    private void permuteUnique2(int[] nums, int mask, List<Integer> al, String key) {
        if (mask == (1 << nums.length)-1) {
            if (!seen.contains(key)) {
                ans.add(al);
                seen.add(key);
            }
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if ((mask & (1 << i)) == 0) {
                List<Integer> temp = new ArrayList<>(al);
                temp.add(nums[i]);
                permuteUnique2(nums, mask | (1 << i), temp, key + nums[i] + ",");
            }
        }
    }

    // Approach 2 - Gen. all permutations and keep mask to mark seen
    // and keep all recursive calls independent using global ans[][]
    public List<List<Integer>> permuteUnique2(int[] nums) {
        Arrays.sort(nums);
        permuteUnique2(nums, 0, new ArrayList<>(), "");
        return ans;
    }

    private void permuteUnique3(int n, Map<Integer, Integer> map, List<Integer> al) {
        if (al.size() == n) {
            ans.add(al);
            return;
        }
        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            int num = e.getKey();
            int count = e.getValue();
            if (count == 0)
                continue;
            List<Integer> temp = new ArrayList<>(al);
            temp.add(num);
            map.put(num, count-1);
            permuteUnique3(n, map, temp);
            map.put(num, count);
        }
    }

    // Approach 3 - Generate only the required permutations by using unique values in nums[]
    public List<List<Integer>> permuteUnique3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        permuteUnique3(nums.length, map, new ArrayList<>());
        return ans;
    }

}
