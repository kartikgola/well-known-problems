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

public class SLUSH {

    private String arrayString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < arr.length; ++i ) {
            sb.append(arr[i]).append(" ");
        }
        return sb.toString();
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int t = Integer.parseInt(reader.readLine());

        while ( t-- > 0 ) {
            tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken()); // total customers
            int m = Integer.parseInt(tokenizer.nextToken()); // total drinks

            int[] c = new int[m + 1]; // Count of drinks
            int[][] d = new int[n][3]; // Data of customers

            boolean[] r = new boolean[n]; // Satisfaction of customer
            long profit = 0l; // Total profit
            int[] order = new int[n]; // Order of drinks

            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 1; i <= m; ++i) {
                c[i] = Integer.parseInt(tokenizer.nextToken());
            }

            for (int i = 0; i < n; ++i) {
                tokenizer = new StringTokenizer(reader.readLine());
                d[i][0] = Integer.parseInt(tokenizer.nextToken());
                d[i][1] = Integer.parseInt(tokenizer.nextToken());
                d[i][2] = Integer.parseInt(tokenizer.nextToken());
            }

            // first, check what all customers can be satisfied
            for ( int i = 0; i < n; ++i ) {
                if ( c[d[i][0]] > 0 ) {
                    profit += d[i][1];
                    order[i] = d[i][0];
                    r[i] = true;
                    c[d[i][0]]--;
                }
            }

            // find the first non-empty index of drink
            int e = -1;
            for ( int i = 1; i <= m; ++i ) {
                if ( c[i] > 0 ) {
                    e = i;
                    break;
                }
            }

            // if non-zero count index is found
            if ( e != -1 ) {
                // satisfy the remaining customers by offering them alternate drinks
                for ( int i = 0; i < n; ++i ) {
                    if ( !r[i] ) {
                        if ( c[e] == 0 ) {
                            // find the next non-zero count index of drinks
                            // this is guaranteed to be found
                            for ( int j = e + 1; j <= m; ++j ) {
                                if ( c[j] > 0 ) {
                                    e = j;
                                    break;
                                }
                            }
                        }
                        c[e]--;
                        profit += d[i][2];
                        order[i] = e;
                    }
                }
            }
            System.out.println(profit);
            System.out.println(arrayString(order));
        }
    }

}
