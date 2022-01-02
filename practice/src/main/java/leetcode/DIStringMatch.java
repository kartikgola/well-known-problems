/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class DIStringMatch {

    public int[] diStringMatch(String S) {
        final int n = S.length();
        final int[] ans = new int[n+1];
        int begin = 0, end = n;

        for (int i = 0; i < n; ++i)
            ans[i] = S.charAt(i) == 'I' ? begin++ : end--;

        ans[n] = begin;
        return ans;
    }
}
