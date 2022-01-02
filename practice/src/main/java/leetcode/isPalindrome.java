/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class isPalindrome {

    public boolean isPalindrome(int x) {
        if ( x < 0 )
            return false;
        int n = (int) Math.floor(Math.log10(x)) + 1;

        while ( x > 9 ) {
            final int pow = (int) Math.pow(10, n - 1);
            int last = x % 10;
            int first = x / pow;
            if ( last != first )
                return false;

            // Example, 5445 => 5445 - 5000 => 445
            x = x - (int) pow * last;
            // and so, 445 => 44
            x = x / 10;

            if ( x == 0 )
                break;

            int m = (int) Math.floor(Math.log10(x)) + 1;
            // If originally, x was say, 10021, then it becomes 2 at this point
            int deletedZeros = n - m - 2;

            // Remove the trailing zeros that match up with deletedZeros in the front
            for ( int count = 0; count < deletedZeros; ++count ) {
                if ( x % 10 == 0 ) {
                    x = x / 10;
                } else {
                    // in case trailing zero doesn't match
                    return false;
                }
            }

            // Since all the matching trailing zeros are removed, reduce n by `deletedZeros`
            n = m - deletedZeros;
        }

        return true;
    }
}
