/*
 * Author: Kartik Gola
 * Date: 05/07/20, 8:54 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

public class UglyNumber2 {

    public int nthUglyNumber(int n) {
        // Here, 1690 is max value of n given in question
        int[] ugly = new int[1690];
        // base case handling
        ugly[0] = 1;
        // f(n) = {
        //          1                                                  ;if n == 0
        //          min{f(a) * 2, f(b) * 3, f(c) * 5}                  ;if n > 1
        //              ,where f(a) = last ugly number not used by 2 such that f(a) * 2 is just greater than f(n - 1)
        //                     f(b) = last ugly number not used by 3 such that f(b) * 3 is just greater than f(n - 1)
        //                     f(c) = last ugly number not used by 5 such that f(c) * 5 is just greater than f(n - 1)
        //        }

        // Store the indices of ugly[] in variables a, b and c
        // values at these indices will be multiplied with 2, 3 and 5 respectively
        // to get the lowest ugly number
        int a = 0, b = 0, c = 0;
        for ( int i = 1; i < n; ++i ) {
            // Increment a/b/c until 'ugly[x] * K' is less than equal to last ugly number
            // where, x -> a or b or c
            //      , K -> 2 or 3 or 5
            for ( ; ugly[a] * 2 <= ugly[i - 1]; ++a );
            for ( ; ugly[b] * 3 <= ugly[i - 1]; ++b );
            for ( ; ugly[c] * 5 <= ugly[i - 1]; ++c );

            // Generate the lowest ugly numbers each from 2, 3 and 5
            // by multiplying them with previously
            // generated ugly numbers at ugly[a], ugly[b] or ugly[c]
            int a2 = ugly[a] * 2;
            int b3 = ugly[b] * 3;
            int c5 = ugly[c] * 5;

            // Get the minimum ugly number & increment a/b/c accordingly
            int min = Math.min(a2, Math.min(b3, c5));
            if ( min == c5 ) {
                ugly[i] = c5;
                c++;
            } else if ( min == b3) {
                ugly[i] = b3;
                b++;
            } else {
                ugly[i] = a2;
                a++;
            }
        }

        return ugly[n - 1];
    }
}
