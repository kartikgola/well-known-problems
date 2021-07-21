/*
 * Author: Kartik Gola
 * Date: 7/12/21, 9:29 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/isomorphic-strings/
 */

package practice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            // source char is already mapped
            if (map.containsKey(ch1)) {
                if (map.get(ch1) != ch2) {
                    // return false if mapped value is other than ch2
                    return false;
                }
            } else {
                // return false if ch2 is already used as a mapped value
                if (used.contains(ch2))
                    return false;
                else {
                    map.put(ch1, ch2);
                    // mark ch2 as used
                    used.add(ch2);
                }
            }
        }
        return true;
    }
}
