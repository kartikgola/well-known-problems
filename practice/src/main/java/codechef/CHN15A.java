/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHN15A {

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while ( t-- > 0 ) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            int n = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());

            int totalWolverines = 0;
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            while ( n-- >  0 ) {
                final int icv = Integer.parseInt(tokenizer.nextToken());
                if ( (icv + k) % 7 == 0 )
                    totalWolverines++;
            }
            System.out.println(totalWolverines);
        }
    }
}
