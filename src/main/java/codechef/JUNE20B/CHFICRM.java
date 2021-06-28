/*
 * Author: Kartik Gola
 * Date: 11/06/20, 9:29 AM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package codechef.JUNE20B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHFICRM {

    // Simple if-else logic
    // Time: O(n), Space: O(1)
    public void solve() throws IOException {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn;
        int t = Integer.parseInt(rdr.readLine());

        while ( t-- > 0 ) {
            tkn = new StringTokenizer(rdr.readLine(), " ");
            int n = Integer.parseInt(tkn.nextToken());

            tkn = new StringTokenizer(rdr.readLine(), " ");
            int[] coins = new int[10 + 1];
            int amount = 0, balance = 0;
            boolean res = true;

            while ( tkn.hasMoreTokens() ) {
                amount = Integer.parseInt(tkn.nextToken());
                coins[amount]++;
                balance = amount - 5;
                if ( balance > 0 ) {
                    if ( balance == 10 && coins[10] > 0 ) {
                        coins[10]--;
                    } else if ( coins[5] >= balance / 5 ) {
                        coins[5]--;
                    } else {
                        res = false;
                        break;
                    }
                }
            }

            System.out.println(res);
        }
    }

}
