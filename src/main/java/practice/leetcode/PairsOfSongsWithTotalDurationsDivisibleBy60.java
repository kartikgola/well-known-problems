/*
 * Author: Kartik Gola
 * Date: 12/9/20, 12:48 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 */

package practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    // Given, a + b = 60k; where k >= 1
    // => (a + b) % 60
    // => (a % 60) + (b % 60)
    // => 60
    // We can say that, (a % 60) + (b % 60) = 60
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int[] map = new int[60];
        for (int t: time) {
            t = t % 60;
            count += (t == 0 ? map[t] : map[60 - t]);
            map[t] += 1;
        }
        return count;
    }

    public int numPairsDivisibleBy60_2(int[] times) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int time: times) {
            int mod = time % 60;
            // pair can be [60, 60], so we take mod twice!
            int diff = (60 - mod) % 60;
            ans += map.getOrDefault(diff, 0);
            map.put(mod, map.getOrDefault(mod, 0)+1);
        }
        return ans;
    }
}
