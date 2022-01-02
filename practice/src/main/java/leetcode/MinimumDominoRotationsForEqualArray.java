/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class MinimumDominoRotationsForEqualArray {

    // min rotations to make all values in top/bottom equal to v
    private int f(int v, int[] top, int[] bot) {
        int tr = 0;
        int br = 0;
        for (int i = 0; i < top.length; ++i) {
            if (bot[i] == v && top[i] != v)
                tr++;
            else if (top[i] == v && bot[i] != v)
                br++;
            else if (top[i] != v && bot[i] != v)
                return top.length;
        }
        return Math.min(tr, br);
    }

    public int minDominoRotations(int[] top, int[] bot) {
        int ans = Math.min(
                f(top[0], top, bot),
                f(bot[0], top, bot)
        );
        return ans == top.length ? -1 : ans;
    }
}
