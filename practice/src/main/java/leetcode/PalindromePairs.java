/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import trie.Trie;

import java.util.*;

import static util.StringUtils.isPalindrome;

public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Trie trie = new Trie();
        int empty = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) empty = i;
            else trie.add(new StringBuilder(words[i]).reverse().toString(), i);
        }

        for (int i = 0; i < words.length; i++) {
            if (i == empty) continue;
            for (int j: trie.getWordIdsBelow(words[i])) {
                if (i == j) continue;
                // Case 1: CAT,TAC
                // Case 2: CAT,DOODTAC
                if (words[j].length() == words[i].length() || isPalindrome(words[j], 0, words[j].length() - words[i].length() - 1)) {
                    ans.add(Arrays.asList(i, j));
                }
            }
            // find palindrome suffixes
            for (int j = words[i].length()-1; j >= 0; --j) {
                // Case 3: CATDOOD,TAC
                if (isPalindrome(words[i], j, words[i].length()-1)) {
                    int k = trie.getWordId(words[i].substring(0, j));
                    if (k != -1)
                        ans.add(Arrays.asList(i, k));
                    if (j == 0 && empty != -1) {
                        ans.add(Arrays.asList(i, empty));
                        ans.add(Arrays.asList(empty, i));
                    }
                }
            }
        }

        return ans;
    }
}
