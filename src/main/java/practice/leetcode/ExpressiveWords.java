/*
 * Author: Kartik Gola
 * Date: 9/10/21, 10:22 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class ExpressiveWords {

    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        outer:
        for (String wd: words) {
            if (wd.length() > s.length())
                continue;

            int i = 0;
            int j = 0;

            while (i < s.length() && j < wd.length()) {
                int k = i;
                while (k+1 < s.length() && s.charAt(k+1) == s.charAt(k))
                    ++k;

                int l = j;
                while (l+1 < wd.length() && wd.charAt(l+1) == wd.charAt(l))
                    ++l;

                if (s.charAt(k) != wd.charAt(l) || l-j+1 > k-i+1 || (k-i+1 <= 2 && l-j+1 != k-i+1))
                    continue outer;

                i = k+1;
                j = l+1;
            }

            if (i == s.length() && j == wd.length())
                ans += 1;
        }

        return ans;
    }
}
