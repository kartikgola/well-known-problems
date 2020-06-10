/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EATTWICE {

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int t = Integer.parseInt(reader.readLine());

        while ( t-- > 0 ) {
            tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());

            int[] v = new int[n];
            int[] d = new int[n];

            for (int i = 0; i < n; ++i) {
                tokenizer = new StringTokenizer(reader.readLine());
                d[i] = Integer.parseInt(tokenizer.nextToken());
                v[i] = Integer.parseInt(tokenizer.nextToken());
            }

            // Find highest tastiness dish
            int maxT = -1;
            for (int i = 0; i < n; ++i) {
                if ( maxT == -1 || v[i] > v[maxT] )
                    maxT = i;
            }

            // Find second highest tastiness dish
            int secondMaxT = -1;
            for (int i = 0; i < n; ++i) {
                if ( (secondMaxT == -1 || v[i] > v[secondMaxT]) && d[i] != d[maxT] )
                    secondMaxT = i;
            }

            System.out.println(v[maxT] + v[secondMaxT]);
        }
    }
}
