/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef.AUG20B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LINCHESS {

    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while ( t-- > 0 ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int moves = Integer.MAX_VALUE;
            int ans = -1;

            st = new StringTokenizer(br.readLine());
            while ( st.hasMoreTokens() ) {
                int p = Integer.parseInt(st.nextToken());
                if ( k % p == 0 ) {
                    moves = Math.min(moves, k / p);
                    ans = p;
                }
            }

            System.out.println(ans);
        }
    }
}
