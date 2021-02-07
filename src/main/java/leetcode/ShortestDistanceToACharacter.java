/*
 * Author: Kartik Gola
 * Date: 07/02/2021, 18:47
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/shortest-distance-to-a-character/
 */

package leetcode;

public class ShortestDistanceToACharacter {

    public int[] shortestToChar(String s, char c) {
        final int n = s.length();
        int[] ans = new int[n];
        // 'left' will hold the first 'c' towards left-side
        // 'right' will hold the first 'c' towards right-side
        int left = -1000_000, right = 0;

        // set 'right' as first index of 'c'
        while (right < n && s.charAt(right) != c) ++right;
        if (right == n)
            return ans;

        for (int i = 0; i < n; ++i) {
            if (right < i) {
                // swap values
                left = right++;
                // set 'right' as next index of 'c'
                while (right < n && s.charAt(right) != c)
                    ++right;
                // if we have reached end, set right as MAXIMUM
                // so that we always get answer from 'left'
                if (right == n)
                    right = 1000_000;
            }

            ans[i] = Math.min(i - left, right - i);
        }

        return ans;
    }
}
