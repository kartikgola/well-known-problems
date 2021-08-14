/*
 * Author: Kartik Gola
 * Date: 8/14/21, 12:56 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.List;

public class RemoveBoxes {

    // Naive solution
    private int removeBoxesNaive(int[] boxes) {
        int ans = 0;
        for (int i = 0, j = 0; i < boxes.length; i = (i == j ? i+1 : j)) {
            while (j+1 < boxes.length && boxes[i] == boxes[j+1]) ++j;

            int[] left = new int[i];
            System.arraycopy(boxes, 0, left, 0, left.length);

            int[] right = new int[boxes.length-1-j];
            System.arraycopy(boxes, j+1, right, 0, right.length);

            int[] both = new int[left.length+right.length];
            System.arraycopy(left, 0, both, 0, left.length);
            System.arraycopy(right, 0, both, left.length, right.length);

            ans = Math.max(ans, (j-i+1) * (j-i+1) + Math.max(removeBoxesNaive(left) + removeBoxesNaive(right), removeBoxesNaive(both)));
        }
        return ans;
    }

    // Semi-DP solution
    private int removeBoxesDP(int[] boxes, int l, int r, Integer[][] dp) {
        int ans = 0;
        if (l < 0 || r >= boxes.length || l > r)
            return ans;
        if (dp[l][r] != null)
            return dp[l][r];
        if (l == r)
            return dp[l][r] = 1;
        for (int i = l, j = l; i <= r; i = (i == j ? i+1 : j)) {
            while (j+1 <= r && boxes[i] == boxes[j+1])
                ++j;
            int[] both = new int[i-l+r-j];
            System.arraycopy(boxes, l, both, 0, i-l);
            System.arraycopy(boxes, j+1, both, i-l, r-j);
            ans = Math.max(ans, (j-i+1) * (j-i+1) + Math.max(removeBoxesDP(boxes, l, i-1, dp) + removeBoxesDP(boxes, j+1, r, dp), removeBoxes(both)));
        }
        return dp[l][r] = ans;
    }

    // Proper DP solution
    private int removeBoxes(int[] boxes, int l, int r, int k, Integer[][][] dp) {
        if (l > r)
            return 0;
        if (dp[l][r][k] != null)
            return dp[l][r][k];
        int tempL = l, tempR = r, tempK = k;
        while (l+1 <= r && boxes[l] == boxes[l+1]) {
            l++;
            k++;
        }
        int ans = (k+1) * (k+1) + removeBoxes(boxes, l+1, r, 0, dp);
        for (int j = l+1; j <= r; ++j) {
            if (boxes[l] == boxes[j]) {
                ans = Math.max(ans, removeBoxes(boxes, j, r, k+1, dp) + removeBoxes(boxes, l+1, j-1, 0, dp));
            }
        }
        return dp[tempL][tempR][tempK] = ans;
    }

    public int removeBoxes(int[] boxes) {
        final int n = boxes.length;
        return removeBoxes(boxes, 0, n-1, 0, new Integer[n][n][n]);
    }

}
