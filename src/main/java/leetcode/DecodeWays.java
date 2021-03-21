/*
 * Author: Kartik Gola
 * Date: 3/22/21, 12:13 AM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/decode-ways/
 */

package leetcode;

import java.util.Arrays;

public class DecodeWays {

    private boolean isValid(String s, int begin, int end) {
        if (s.charAt(begin) == '0')
            return false;
        final int val = Integer.parseInt(s.substring(begin, end));
        return val >= 1 && val <= 26;
    }

    private int numDecodings(String s, int begin, int[] dp) {
        if (dp[begin] != -1)
            return dp[begin];

        int count = 0;
        for (int end = begin+1; end <= Math.min(begin+2, s.length()); ++end) {
            if (isValid(s, begin, end))
                count += end >= s.length() ? 1 : numDecodings(s, end, dp);
            else break;
        }

        dp[begin] = count;
        return count;
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return numDecodings(s, 0, dp);
    }
}
