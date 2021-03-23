/*
 * Author: Kartik Gola
 * Date: 3/23/21, 8:54 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/vowel-spellchecker/
 */

package leetcode;

import java.util.*;

public class VowelSpellcheck {

    /**
     * Make a map of the form
     * {
     *   "k-t-": {
     *       "kite": ["Kite", "KITE", "kITe", "KITe"]
     *    }
     * }
     */
    public String[] spellchecker(String[] wordlist, String[] queries) {
        final int n = queries.length;
        final String[] ans = new String[n];
        final Map<String, Map<String, Set<String>>> dict = new HashMap<>();
        final String REPLACEMENT = "-";
        final String VOWELS_REGEX = "[aeiou]";

        for (String word: wordlist) {
            String lowerCaseWord = word.toLowerCase();
            String dashedWord = lowerCaseWord.replaceAll(VOWELS_REGEX, REPLACEMENT);
            dict.putIfAbsent(dashedWord, new LinkedHashMap<>());
            dict.get(dashedWord).putIfAbsent(lowerCaseWord, new LinkedHashSet<>());
            dict.get(dashedWord).get(lowerCaseWord).add(word);
        }

        for (int i = 0; i < queries.length; ++i) {
            String lowerCaseQuery = queries[i].toLowerCase();
            String dashedQuery = lowerCaseQuery.replaceAll(VOWELS_REGEX, REPLACEMENT);
            if (dict.containsKey(dashedQuery)) {
                if (dict.get(dashedQuery).containsKey(lowerCaseQuery)) {
                   if (dict.get(dashedQuery).get(lowerCaseQuery).contains(queries[i])) {
                       ans[i] = queries[i];
                   } else {
                       ans[i] = dict.get(dashedQuery)
                               .get(lowerCaseQuery)
                               .iterator()
                               .next();
                   }
                } else {
                    ans[i] = dict.get(dashedQuery).entrySet()
                                .iterator()
                                .next()
                                .getValue()
                                .iterator()
                                .next();
                }
            } else {
                ans[i] = "";
            }
        }

        return ans;
    }
}
