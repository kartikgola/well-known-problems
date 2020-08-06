/*
 * Author: Kartik Gola
 * Date: 02/08/20, 1:36 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMost2DistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        final Map<Character, Integer> map = new HashMap<>();
        final int n = s.length();
        final int k = 2;
        int left = 0, right = 0;
        int maxLen = Integer.MIN_VALUE;

        while ( right < n ) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            ++right;

            while ( map.size() > k ) {
                ch = s.charAt(left);
                map.put(ch, map.get(ch) - 1);
                if ( map.get(ch) == 0 )
                    map.remove(ch);
                ++left;
            }

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
