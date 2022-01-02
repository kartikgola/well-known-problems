/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    private final Random rand = new Random();
    private final int MAX_OPS = 2 * (int)2e5;
    private final Map<Integer, Integer> map = new HashMap<>(); // Map of <value, position_in_nums>
    private final int[] nums = new int[MAX_OPS]; // treat as if length of nums is denoted by 'len'
    private int len = 0; // denotes the no. of elements currently in nums

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, len);
        nums[len++] = val;
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int pos = map.get(val);
        if (pos < len-1) {
            // bring the last element to 'pos'
            int last = nums[len-1];
            nums[pos] = last;
            map.put(last, pos);
        }
        map.remove(val);
        --len;
        return true;
    }

    public int getRandom() {
        return nums[rand.nextInt(len)];
    }
}
