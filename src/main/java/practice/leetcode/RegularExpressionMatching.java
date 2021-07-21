/*
 * Author: Kartik Gola
 * Date: 4/2/21, 1:10 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/regular-expression-matching/
 */

package practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RegularExpressionMatching {

    Map<String, Boolean> dp = new HashMap<>();

    public boolean isMatch(String str, String pattern) {
        if (str.isEmpty() && pattern.isEmpty())
            return true;

        if (!str.isEmpty() && pattern.isEmpty())
            return false;

        final String key = str + ":" + pattern;
        if (dp.containsKey(key))
            return dp.get(key);

        final int starIndex = pattern.indexOf('*');
        final String subPattern = pattern.substring(0, starIndex != -1 ? starIndex+1 : pattern.length());

        // Keep a pointer for 'subPattern' and 'str'
        int j = 0;
        for (int i = 0; i < subPattern.length(); ++i) {
            char p = subPattern.charAt(i);
            boolean starEnding = i == subPattern.length()-2 && subPattern.charAt(i+1) == '*';
            if (starEnding) {
                // Current pattern is now ending with *
                // .* or x* means we can consume [0,INF] characters from 'str' (provided they match with . or x)
                // First, we consume 0 characters
                boolean matchResult = isMatch(str.substring(j), pattern.substring(subPattern.length()));
                // Next, we try consuming first 'k' characters, one-by-one
                for (int k = j; k < str.length() && (str.charAt(k) == p || p == '.') && !matchResult; ++k) {
                    matchResult = matchResult || isMatch(str.substring(k+1), pattern.substring(subPattern.length()));
                }
                dp.put(key, matchResult);
                return matchResult;
            } else if (j < str.length()) {
                if (str.charAt(j) == p || p == '.') {
                    ++j;
                } else return false;
            } else return false;
        }

        boolean result = isMatch(str.substring(j), pattern.substring(subPattern.length()));
        dp.put(key, result);
        return result;
    }

}
