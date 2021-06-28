/*
 * Author: Kartik Gola
 * Date: 1/23/21, 12:37 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/one-edit-distance/
 */

package leetcode;

public class OneEditDistance {

    public boolean isOneEditDistance(String s, String t) {
        final int m = s.length();
        final int n = t.length();
        if (Math.abs(m-n) > 1)
            return false;

        int i = 0, j = 0;
        int edits = 0;

        while (i < m && j < n && edits <= 1) {
            if (s.charAt(i) == t.charAt(j)) {
                ++i; ++j;
            } else {
                ++edits;
                if (m == n) {
                    ++i; ++j;
                } else {
                    if (m > n)
                        ++i;
                    else
                        ++j;
                }
            }
        }

        return i == m && j == n ? edits == 1 : edits == 0;
    }
}
