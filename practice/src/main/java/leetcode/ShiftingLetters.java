/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class ShiftingLetters {

    public String shiftingLetters(String s, int[] shifts) {
        final int n = s.length();
        long[] total = new long[n];
        total[n-1] = shifts[n-1];
        for (int i = n-2; i >= 0; --i) {
            total[i] = shifts[i] + total[i+1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            int x = (int) (((s.charAt(i) - 'a') + total[i]) % 26);
            sb.append((char)('a' + x));
        }

        return sb.toString();
    }
}
