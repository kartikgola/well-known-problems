/*
 * Author: Kartik Gola
 * Date: 06/07/20, 1:33 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package ctci.chapter5;

public class FlipBitToWin {

    public int flipBitToWin(int n) {
        int mask = 1;
        int max = 0;
        while ( mask > 0 ) {
            int m = n | mask;
            int curr = 0;
            while ( m > 0 ) {
                int and = m & 1;
                if ( and == 1 ) {
                    curr++;
                } else {
                    max = Math.max(curr, max);
                    curr = 0;
                }
                m >>= 1;
            }
            max = Math.max(curr, max);
            mask <<= 1;
        }
        return max;
    }
}
