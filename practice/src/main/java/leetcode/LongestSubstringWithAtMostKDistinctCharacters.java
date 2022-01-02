/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        final Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int maxLen = Integer.MIN_VALUE;

        while (r < s.length()) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            ++r;

            while (map.size() > k) {
                ch = s.charAt(l);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0)
                    map.remove(ch);
                ++l;
            }

            maxLen = Math.max(maxLen, r - l);
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
