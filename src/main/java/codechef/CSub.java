/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | rattl.io
 */

package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CSub {

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while ( t-- > 0 ) {
            final int n = Integer.parseInt(reader.readLine());
            String str = reader.readLine();
            long countOf1s = 0L;

            for ( char s: str.toCharArray() ) {
                if ( s == '1' ) {
                    ++countOf1s;
                }
            }

            System.out.println( (countOf1s * (countOf1s + 1)) >> 1 );
        }
    }
}
