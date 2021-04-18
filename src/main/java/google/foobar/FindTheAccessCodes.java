/*
 * Author: Kartik Gola
 * Date: 4/17/21, 12:33 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package google.foobar;

public class FindTheAccessCodes {

    public static int solution(int[] l) {
        if ( l.length < 3 )
            return 0;

        int count = 0;
        final int n = l.length;

        int[] xyCount = new int[n];
        int[] yzCount = new int[n];
        // Algo -
        // 1. Find pairs x y _ where x divides y & note count of each y
        // 2. Find pairs _ y z where y divides z & note count of each y
        // 3. Add to final count, wherever y has equal value in x y _ & _ y z


        // Loop for y
        for ( int j = 1; j < n - 1; ++j ) {
            // Loop for x
            for ( int i = 0; i < j; ++i ) {
                if ( l[j] % l[i] == 0 ) {
                    // Increase count of times y is used
                    xyCount[j]++;
                }
            }
        }

        // Loop for z
        for ( int k = 2; k < n; ++k ) {
            // Loop for y
            for ( int j = 1; j < k; ++j ) {
                if ( l[k] % l[j] == 0 ) {
                    yzCount[j]++;
                }
            }
        }

        // if x divides y and y divides z, x will also divide z
        // So, we multiply the counts
        for ( int i = 0; i < n; ++i ) {
            count += yzCount[i] * xyCount[i];
        }

        return count;
    }

}
