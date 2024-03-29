/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef.JUNE20B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EOEO {

    // Divide by 2 solution
    // Time: O(log(n)), Space: O(1)
    public void solve() throws IOException {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn;
        int t = Integer.parseInt(rdr.readLine());

        while ( t-- > 0 ) {
            tkn = new StringTokenizer(rdr.readLine(), " ");
            long ts = Long.parseLong(tkn.nextToken());

            // There is no way to win, if `ts` is a power of 2
            if ( (ts & ts - 1) ==  0 ) {
                System.out.println(0);
            } else {
                // Divide by 2, until `ts` is odd
                while ( ts % 2 == 0 )
                    ts /= 2;
                System.out.println(ts / 2);
            }
        }
    }
}
