/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class PerformStringShifts {

    public String stringShift(String s, int[][] shift) {
        StringBuilder sb = new StringBuilder(s);
        final int n = s.length();
        int shiftLen = 0;

        for ( int[] sh: shift ) {
            if ( sh[0] == 0 ) {
                shiftLen -= sh[1];
            } else {
                shiftLen += sh[1];
            }
        }
        shiftLen = shiftLen % n;

        if ( shiftLen < 0 ) {
            sb.append(sb.substring(0, -1 * shiftLen));
            sb.delete(0, -1 * shiftLen);
        } else if ( shiftLen > 0 ) {
            sb.append(sb.substring(0, n - shiftLen));
            sb.delete(0, n - shiftLen);
        }

        return sb.toString();
    }

}
