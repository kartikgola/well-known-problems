/*
 * Author: Kartik Gola
 * Date: 28/03/2021, 23:23
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/word-subsets/
 */

package leetcode;

import java.util.LinkedList;
import java.util.List;

public class WordSubsets {

    public List<String> wordSubsets(String[] A, String[] B) {
        int[] univ = new int[26];
        for (String b: B) {
            int[] aux = new int[26];
            for (char ch: b.toCharArray())
                univ[ch - 'a'] = Math.max(univ[ch - 'a'], ++aux[ch - 'a']);
        }

        List<String> ans = new LinkedList<>();
        outer:
        for (String a: A) {
            int[] aux = new int[26];
            for (char ch: a.toCharArray())
                aux[ch - 'a']++;

            for (int i = 0; i < aux.length; ++i) {
                if (univ[i] > aux[i])
                    continue outer;
            }
            ans.add(a);
        }

        return ans;
    }
}
