/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class MaximumXorSecondary {

    public void solve() throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(rd.readLine());
        StringTokenizer tkn = new StringTokenizer(rd.readLine());

        Stack<Integer> st = new Stack<>();
        int maxXor = 0, val;
        for ( int i = 0; tkn.hasMoreTokens(); ++i ) {
            val = Integer.parseInt(tkn.nextToken());
            while ( !st.empty() ) {
                maxXor = Math.max(maxXor, st.peek() ^ val);
                if ( st.peek() > val )
                    break;
                st.pop();
            }
            st.push(val);
        }

        System.out.println(maxXor);
    }
}
