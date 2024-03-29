/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class CountNumberOfTeams {

    public int numTeams(int[] rating) {
        final int n = rating.length;
        if ( n < 3 )
            return 0;

        // Count of teams
        int c = 0;
        // great[i][0] = No. of elements greater than rating[i] on left side
        // great[i][1] = No. of elements greater than rating[i] on right side
        int[][] great = new int[n][2];
        // less[i][0] = No. of elements lesser than rating[i] on left side
        // less[i][1] = No. of elements lesser than rating[i] on right side
        int[][] less = new int[n][2];
        for ( int i = 0; i < n; ++i ) {
            for ( int j = i - 1; j > -1; --j ) {
                if ( rating[j] > rating[i] )
                    great[i][0]++;
                if ( rating[j] < rating[i] )
                    less[i][0]++;
            }

            for ( int j = i + 1; j < n; ++j ) {
                if ( rating[j] > rating[i] )
                    great[i][1]++;
                if ( rating[j] < rating[i] )
                    less[i][1]++;
            }
        }

        // For each j which lies between some other i & k
        // Teams that can be formed if i < j < k are less[j][0] * great[j][1]
        for ( int j = 1; j < n - 1; ++j ) {
            c += less[j][0] * great[j][1];
            c += great[j][0] * less[j][1];
        }

        return c;
    }

}
