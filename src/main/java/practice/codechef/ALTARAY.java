/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ALTARAY {

    private int[] readArray(BufferedReader reader, int n) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int[] arr = new int[n];
        int i = 0;
        while ( tokenizer.hasMoreTokens() ) {
            arr[i++] = Integer.parseInt(tokenizer.nextToken());
        }
        return arr;
    }

    private boolean isAlternate(int a, int b) {
        return (a >= 0 && b < 0) || (a < 0 && b >= 0);
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while ( t-- > 0 ) {
            int n = Integer.parseInt(reader.readLine());
            int[] A = readArray(reader, n);
            int[] R = new int[n];

            int i = n - 1;
            R[i] = 1;
            for ( i = n - 2; i >= 0; --i ) {
                R[i] = 1;
                if ( isAlternate(A[i], A[i + 1]) ) {
                    R[i] = R[i + 1] + 1;
                }
            }

            for ( Integer item : R ) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
