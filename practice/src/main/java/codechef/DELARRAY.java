/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DELARRAY {
	public void solve() throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while ( t-- > 0 ) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] l = new int[n];

            for ( int i = 0; i < n; ++i )
                l[i] = Integer.parseInt(st.nextToken());

            int count = 0;
            for ( int i = 0; i < n; ++i ) {
                middle:
                for ( int j = i; j < n; ++j ) {
                    // Check if elements are strictly increasing in left part
                    int p = -1;
                    for ( int k = 0; k < i; ++k ) {
                        if ( p == -1 || l[k] > l[p] )
                            p = k;
                        else continue middle;
                    }

                    // Check if elements are strictly increasing in right part
                    for ( int m = j + 1; m < n; ++m ) {
                        if ( p == -1 || l[m] > l[p] )
                            p = m;
                        else continue middle;
                    }
                    ++count;
                }
            }
            System.out.println(count == 0 ? 0 : count - 1);
        }
	}
}
