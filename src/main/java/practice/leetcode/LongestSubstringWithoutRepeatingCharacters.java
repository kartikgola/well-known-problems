/*
 * Author: Kartik Gola
 * Date: 7/28/20 7:13 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

package practice.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int len = 0;
        Set<Character> set = new HashSet<>();

        while ( right < s.length() ) {
            while ( set.contains(s.charAt(right)) ) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right++));
            len = Math.max(len, set.size());
        }

        return len;
    }

}
