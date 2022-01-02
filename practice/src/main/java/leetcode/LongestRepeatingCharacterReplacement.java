/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        final int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0;
        int ans = Integer.MIN_VALUE;
        int maxFreq = Integer.MIN_VALUE;

        while ( end < n ) {
            char ch = s.charAt(end++);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            // Get the maximum frequency in the current window
            maxFreq = Math.max(maxFreq, map.get(ch));

            // Current window has to be decreased only if `window.size - maxFreq > k`
            // Example, given s = "AAABBBCC"
            // if A:3, B:3, C:2 & k = 4 & left = 0, right = 8
            // Since we can do only 4 replacements at max, for the substring "BBBC"
            // Longest string of length 8 can only be made for `AAABBBC`
            if (end - begin - maxFreq > k) {
                ch = s.charAt(begin);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0)
                    map.remove(ch);
                ++begin;
            }

            ans = Math.max(ans, end - begin);
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}
