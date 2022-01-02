/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef.JUNE20B;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EVENM {

    private int[][] getSpiralMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        for ( int layer = 0; layer <= n / 2; ++layer ) {
            int r = layer, c = layer;
            for ( c = layer; c < n - layer; ++c ) {
                res[r][c] = count++;
            }
            c = n - layer - 1;
            for ( r = layer + 1; r < n - layer; ++r ) {
                res[r][c] = count++;
            }
            r = n - layer - 1;
            for ( c = n - layer - 2; c >= layer; --c ) {
                res[r][c] = count++;
            }
            c = layer;
            for ( r = n - layer - 2; r > layer; --r ) {
                res[r][c] = count++;
            }
        }

        return res;
    }

    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while ( t-- > 0 ) {
            int n = Integer.parseInt(br.readLine());
            int[][] res = getSpiralMatrix(n);
            for ( int[] row : res ) {
                for ( int item : row ) {
                    System.out.print(item + " ");
                }
                System.out.println();
            }
        }
    }
}
