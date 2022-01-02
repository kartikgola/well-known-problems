/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class LongestUncommonSubsequence2 {

    private boolean isSub(String a, String b) {
        int j = 0;
        for (int i = 0; i < a.length() && j < b.length();) {
            if (a.charAt(i) == b.charAt(j)) {
                i++; ++j;
            } else {
                ++i;
            }
        }
        return j == b.length();
    }

    public int findLUSlength(String[] strs) {
        Boolean[][] dp = new Boolean[strs.length][strs.length];
        Arrays.sort(strs, (s1, s2) -> s2.length() - s1.length());
        for (int i = 0; i < strs.length;) {
            int j = i;
            while (j+1 < strs.length && strs[j+1].length() == strs[i].length()) {
                j++;
            }
            outer:
            for (int k = i; k <= j; ++k) {
                for (int l = 0; l <= j; ++l) {
                    if (l != k) {
                        if (dp[l][k] == null)
                            dp[l][k] = isSub(strs[l], strs[k]);
                        if (dp[l][k])
                            continue outer;
                    }
                }
                return strs[k].length();
            }
            i = j+1;
        }
        return -1;
    }
}
