/*
 * Author: Kartik Gola
 * Date: 02/08/20, 10:18 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/longest-repeating-character-replacement
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        final int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = Integer.MIN_VALUE;
        int maxVal = Integer.MIN_VALUE;

        while ( right < n ) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxVal = Math.max(maxVal, map.get(ch));
            right++;

            // Current window is invalid iff `window.size - maxValue > k`
            // Example, if A:3, B:3, C:2 & k = 4 & left = 0, right = 8
            // Longest string of length 8 can only be made for AAABBBC & not AAABBBCC
            // Since we can do only 4 replacements at max & which will leave one 'C'
            // Moreover, this while loop will only run once as window.size() will reduce by 1 due to left++
            while ( right - left - maxVal > k ) {
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
