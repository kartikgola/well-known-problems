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

public class FastFood {

    private int[] getArrayInput(final BufferedReader reader, int n) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int[] arr = new int[n];
        int i = 0;
        while ( tokenizer.hasMoreTokens() ) {
            arr[i++] = Integer.parseInt(tokenizer.nextToken());
        }
        return arr;
    }

    public void solve() throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while ( t-- > 0 ) {
            final int n =  Integer.parseInt(reader.readLine());
            int[] A = this.getArrayInput(reader, n);
            int[] B = this.getArrayInput(reader, n);

            int postfixSum = 0;
            for ( int i = n - 1; i >= 0; i-- ) {
                B[i] += postfixSum;
                postfixSum = B[i];
            }

            int maxSum = B[0], currentSum = 0;
            for ( int i = 0; i < n; ++i ) {
                currentSum += A[i];
                maxSum = Math.max(currentSum + ( i + 1 < n ? B[i + 1] : 0), maxSum);
            }
            System.out.println(maxSum);
        }
    }
}
