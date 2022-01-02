/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    private final List<List<Integer>> ans = new ArrayList<>();

    private void subsets(int[] nums, int start, List<Integer> al) {
        ans.add(al);
        for (int i = start; i < nums.length; ++i) {
            List<Integer> temp = new ArrayList<>(al);
            temp.add(nums[i]);
            subsets(nums, i+1, temp);
        }
    }

    // Using void recursive calls
    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums, 0, new ArrayList<>());
        return ans;
    }

    private List<List<Integer>> subsets(int[] nums, int i) {
        List<List<Integer>> ans = new ArrayList<>();
        if (i >= nums.length) {
            ans.add(new ArrayList<>());
            return ans;
        }
        List<List<Integer>> sub = subsets(nums, i+1);
        ans.addAll(sub);
        for (List<Integer> al: sub) {
            List<Integer> temp = new ArrayList<>(al);
            temp.add(nums[i]);
            ans.add(temp);
        }
        return ans;
    }

    // Using List<List<Integer>> recursive calls
    public List<List<Integer>> subsets2(int[] nums) {
        return subsets(nums, 0);
    }
}
