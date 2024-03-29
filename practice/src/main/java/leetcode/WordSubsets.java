/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
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
