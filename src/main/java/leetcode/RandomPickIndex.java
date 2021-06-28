/*
 * Author: Kartik Gola
 * Date: 10/02/2021, 10:30
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/random-pick-index/
 */

package leetcode;

import java.util.*;

public class RandomPickIndex {

    private Random rand = new Random();
    private Map<Integer, List<Integer>> map = new HashMap<>();

    public RandomPickIndex(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(rand.nextInt(list.size()));
    }
}
