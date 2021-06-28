/*
 * Author: Kartik Gola
 * Date: 13/07/20, 1:52 AM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

public class ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if ( n == 0 )
            return 0;
        final int NUM_BITS = Integer.BYTES * 8;
        int m = 1, // Bit mask of only 1-set bit
            shift = NUM_BITS - 1, // No. of times to shift. If +ve, shift left, else shift right
            res = 0; // result

        for ( int i = 0; i < NUM_BITS; m <<= 1, ++i, shift -= 2 ) {
            // Get the bit at ith position
            int p = n & m;
            // Shift the set bit
            for ( int j = 0; j < Math.abs(shift); ++j ) {
                if ( shift >= 0 ) p <<= 1;
                else p >>>= 1;
            }
            // Set the bit in result
            res |= p;
        }

        return res;
    }
}
