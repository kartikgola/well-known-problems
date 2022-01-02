/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern2 {

    private boolean isMatch(String p, int i, String s, int j, Map<Character, String> charMap, Set<String> used) {
        // S and P both are processed
        if (j == s.length())
            return i == p.length();

        // if pattern is all consumed, and S is still left unprocessed
        if (i == p.length())
            return false;

        char ch = p.charAt(i);
        if (charMap.containsKey(ch)) {
            // ch is already mapped previously, so we check match from the same mapping
            String val = charMap.get(ch);
            if (j + val.length() > s.length())
                return false;
            for (int k = j, l = 0; l < val.length(); ++k, ++l) {
                if (val.charAt(l) != s.charAt(k))
                    return false;
            }
            return isMatch(p, i+1, s, j+val.length(), charMap, used);
        } else {
            for (int k = j; k < s.length(); ++k) {
                String val = s.substring(j, k+1);
                // since mapping is bijective, there should not be a case where same substring is mapped to 2 diff chars
                if (!used.contains(val)) {
                    used.add(val);
                    charMap.put(ch, val);
                    if (isMatch(p, i+1, s, k+1, charMap, used)) {
                        return true;
                    }
                    used.remove(val);
                    charMap.remove(ch);
                }
            }
            return false;
        }
    }

    public boolean wordPatternMatch(String pattern, String s) {
        return isMatch(pattern, 0, s, 0, new HashMap<>(), new HashSet<>());
    }
}
