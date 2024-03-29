/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class CountPrimes {

    public int countPrimes(int n) {
        if ( n < 2 )
            return 0;

        // Initially, all numbers are prime (represented as false in notPrimes)
        boolean[] notPrimes = new boolean[n];
        final int sqrt = (int) Math.ceil(Math.sqrt(n));

        for ( int m = 2; m < sqrt; ++m ) {
            if ( !notPrimes[m] ) {
                for ( int p = m * m; p < n; p += m ) {
                    notPrimes[p] = true;
                }
            }
        }

        int count = 0;
        for ( int m = 2; m < n; ++m ) {
            if ( !notPrimes[m] )
                ++count;
        }

        return count;
    }

}
