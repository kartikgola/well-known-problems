/*
 * Author: Kartik Gola
 * Date: 12/9/20, 12:48 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 */

package leetcode;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int[] map = new int[60];

        // Given, a + b = 60k
        // We can say that, (a % 60) + (b % 60) = 60
        for (int t: time) {
            t = t % 60;
            count += (t == 0 ? map[t] : map[60 - t]);
            map[t] += 1;
        }
        return count;
    }
}
