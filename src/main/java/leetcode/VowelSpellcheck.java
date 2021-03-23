/*
 * Author: Kartik Gola
 * Date: 3/23/21, 8:54 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/vowel-spellchecker/
 */

package leetcode;

import java.util.*;

public class VowelSpellcheck {

    private final Set<Character> vowels = new HashSet<Character>(){{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
    }};

    private String replaceVowels(String word, String replacement) {
        StringBuilder sb = new StringBuilder();
        for (Character ch: word.toCharArray()) {
            if (vowels.contains(ch)) {
                sb.append(replacement);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        final int n = queries.length;
        final String[] ans = new String[n];
        final Map<String, Map<String, Set<String>>> dict = new HashMap<>();
        final String REPLACEMENT = "-";

        for (String word: wordlist) {
            String lowerCaseWord = word.toLowerCase();
            String dashedWord = replaceVowels(lowerCaseWord, REPLACEMENT);
            dict.putIfAbsent(dashedWord, new LinkedHashMap<>());
            dict.get(dashedWord).putIfAbsent(lowerCaseWord, new LinkedHashSet<>());
            dict.get(dashedWord).get(lowerCaseWord).add(word);
        }

        for (int i = 0; i < queries.length; ++i) {
            String lowerCaseQuery = queries[i].toLowerCase();
            String dashedQuery = replaceVowels(lowerCaseQuery, REPLACEMENT);
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
