/*
 * Author: Kartik Gola
 * Date: 9/16/21, 12:05 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfGoodWaysToSplitAString {

    public int numSplits(String s) {
        Set<Character> set = new HashSet<>();
        int[] p1 = new int[s.length()];
        int[] p2 = new int[s.length()];

        for (int i = 0; i < s.length(); ++i) {
            set.add(s.charAt(i));
            p1[i] = set.size();
        }

        set.clear();
        for (int i = s.length()-1; i >= 0; --i) {
            set.add(s.charAt(i));
            p2[i] = set.size();
        }

        int ans = 0;
        for (int i = 0; i < s.length()-1; ++i) {
            ans += p1[i] == p2[i+1] ? 1 : 0;
        }

        return ans;
    }
}
