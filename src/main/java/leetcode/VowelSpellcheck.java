/*
 * Author: Kartik Gola
 * Date: 3/23/21, 8:54 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/vowel-spellchecker/
 */

package leetcode;

import util.ds.trie.Trie;
import util.ds.trie.TrieNode;

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

    private Set<Character> vowels = new HashSet<Character>(){{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
    }};

    private String toDashed(String word) {
        StringBuilder sb = new StringBuilder(word.length());
        for (char ch: word.toCharArray()) {
            if (vowels.contains(ch))
                ch = '-';
            sb.append(ch);
        }
        return sb.toString();
    }

    public String[] spellchecker2(String[] wordlist, String[] queries) {
        Map<String, Trie> map = new HashMap<>();
        for (String word: wordlist) {
            String lower = word.toLowerCase();
            String dashed = toDashed(lower);
            map.putIfAbsent(dashed, new Trie());
            map.get(dashed).add(word);
        }

        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            String lower = queries[i].toLowerCase();
            String dashed = toDashed(lower);
            if (map.containsKey(dashed)) {
                if (map.get(dashed).contains(queries[i])) {
                    ans[i] = queries[i];
                } else {
                    StringBuilder sb = new StringBuilder();
                    TrieNode node = map.get(dashed).getRoot();
                    while (!node.isComplete) {
                        node = node.children.values().iterator().next();
                        sb.append(node.val);
                    }
                    ans[i] = sb.toString();
                }
            } else {
                ans[i] = "";
            }
        }

        return ans;
    }
}
