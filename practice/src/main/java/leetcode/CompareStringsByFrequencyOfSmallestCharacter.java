/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import util.ArrayUtils;

import java.util.Arrays;

public class CompareStringsByFrequencyOfSmallestCharacter {

    private int f(String s) {
        int[] map = new int[26];
        for (char ch: s.toCharArray())
            map[ch-'a']++;
        for (int val: map)
            if (val > 0)
                return val;
        return 0;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int[] fw = new int[words.length];

        for (int i = 0; i < words.length; ++i)
            fw[i] = f(words[i]);

        Arrays.sort(fw);

        for (int i = 0; i < queries.length; ++i) {
            int k = f(queries[i]);
            int j = ArrayUtils.Bisect.bisectRight(fw, 0, fw.length, k);
            if (j < fw.length) {
                if (fw[j] > k)
                    ans[i] = fw.length-j;
                else
                    ans[i] = fw.length-1-j;
            }
        }

        return ans;
    }

}
