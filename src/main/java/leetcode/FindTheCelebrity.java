/*
 * Author: Kartik Gola
 * Date: 06/07/20, 9:30 AM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

public class FindTheCelebrity {

    public boolean knows(int i, int j) {
        return true;
    }

    public int findCelebrity(int n) {
        if ( n == 0 )
            return 0;

        int[] in = new int[n];

        // Person 'i' is not celebrity if it has outgoing edge
        // In worst, case, when everybody is a celebrity, this loop will run O(n) times
        for ( int i = 0; i < n; ++i ) {
            if ( in[i] != -1 )
                for ( int j = 0; j < n; ++j ) {
                    if ( i != j ) {
                        if ( knows(i, j) ) {
                            in[i] = -1; // i cannot be celebrity if it knows anybody
                            break;
                        } else { // j cannot be celebrity if even 1 person doesn't know him
                            in[j] = -1;
                        }
                    }
                }
        }

        // For the possible celeb, make sure, everybody knows him/her
        for ( int i = 0; i < n; ++i ) {
            if ( in[i] == 0 ) {
                for ( int j = 0; j < n; ++j ) {
                    if ( i != j ) {
                        if ( knows(j, i) ) {
                            in[i]++;
                        } else break;
                    }
                }
                return in[i] == n - 1 ? i : -1;
            }
        }

        return -1;
    }
}
