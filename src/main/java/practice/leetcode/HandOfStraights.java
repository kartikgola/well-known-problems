/*
 * Author: Kartik Gola
 * Date: 9/10/21, 8:22 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class HandOfStraights {

    private boolean f(Map<Integer, Integer> map, int k) {
        if (map.isEmpty())
            return true;
        int prev = map.keySet().iterator().next();
        map.put(prev, map.get(prev)-1);
        if (map.get(prev) == 0)
            map.remove(prev);
        for (int l = 1; l < k; ++l) {
            // check for only consecutive elements
            // that is, next element can only be 1 greater than prev
            if (map.getOrDefault(prev+1, 0) > 0) {
                map.put(prev+1, map.get(prev+1) - 1);
                if (map.get(prev+1) == 0)
                    map.remove(prev+1);
                prev = prev+1;
            } else return false;
        }
        return f(map, k);
    }

    public boolean isNStraightHand(int[] hand, int k) {
        if (hand.length % k != 0)
            return false;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        Arrays.sort(hand);
        for (int h: hand)
            map.put(h, map.getOrDefault(h, 0) + 1);
        return f(map, k);
    }

}
