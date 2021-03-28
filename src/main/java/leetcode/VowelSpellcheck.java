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

    private static class TrieNode {
        public char val;
        public boolean isComplete;
        public Map<Character, TrieNode> children = new LinkedHashMap<>();
        public TrieNode(char val) { this.val = val; }
    }

    private static class Trie {

        private final TrieNode root = new TrieNode('#');

        public TrieNode getRoot() {
            return root;
        }

        public void add(String word) {
            TrieNode curr = root;
            for ( int i = 0; i < word.length(); ++i ) {
                if ( curr.children.containsKey(word.charAt(i)) ) {
                    curr = curr.children.get(word.charAt(i));
                } else {
                    TrieNode temp = new TrieNode(word.charAt(i));
                    curr.children.put(word.charAt(i), temp);
                    curr = temp;
                }
                if ( i == word.length() - 1 )
                    curr.isComplete = true;
            }
        }

        private boolean contains(String word, int offset, TrieNode parent) {
            TrieNode curr = parent;
            for ( int i = offset; i < word.length(); ++i ) {
                char ch = word.charAt(i);
                if ( curr.children.containsKey(ch) ) {
                    curr = curr.children.get(ch);
                } else {
                    return false;
                }
            }
            return curr.isComplete;
        }

        public boolean contains(String word) {
            return contains(word, 0, root);
        }
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
