/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | rattl.io
 */

package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHFM {

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while ( t-- > 0 ) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int[] a = new int[n];
            double sum = 0;
            for ( int i = 0; i < n; ++i ) {
                a[i] = Integer.parseInt(st.nextToken());
                sum += a[i];
            }

            final double mean = sum / n;
            int coin = -1;
            for ( int i = 0; i < n; ++i ) {
                if ( (sum - a[i]) / (n - 1) == mean ) {
                    coin = i + 1;
                    break;
                }
            }

            System.out.println(coin == -1 ? "Impossible" : coin);
        }
    }
}