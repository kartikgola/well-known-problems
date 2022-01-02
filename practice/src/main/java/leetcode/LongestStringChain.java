/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class LongestStringChain {

    private int longest(String word, Set<String> set, Map<String, Integer> dp) {
        if (dp.containsKey(word))
            return dp.get(word);

        int maxLen = 1;
        for (int i = 0; i < word.length(); ++i) {
            String newWord = word.substring(0, i) + word.substring(i+1, word.length());
            if (set.contains(newWord)) {
                maxLen = Math.max(maxLen, longest(newWord, set, dp) + 1);
            }
        }

        dp.put(word, maxLen);
        return maxLen;
    }

    public int longestStrChain(String[] words) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, words);
        Map<String, Integer> dp = new HashMap<>();

        int maxLen = 0;
        for (String word: words)
            maxLen = Math.max(maxLen, longest(word, set, dp));

        return maxLen;
    }
}
