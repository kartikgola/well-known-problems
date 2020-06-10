/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
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
