/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef.JUNE20B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PRICECON {

    public void solve() throws IOException {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn;
        int t = Integer.parseInt(rdr.readLine());

        while ( t-- > 0 ) {
            tkn = new StringTokenizer(rdr.readLine(), " ");
            int n = Integer.parseInt(tkn.nextToken());
            int k = Integer.parseInt(tkn.nextToken());

            tkn = new StringTokenizer(rdr.readLine(), " ");
            int bfr = 0, afr = 0;

            for ( int i = 0; i < n; ++i ) {
                int tmp = Integer.parseInt(tkn.nextToken());
                bfr += tmp;
                afr += (tmp > k ? k : tmp);
            }

            System.out.println(bfr - afr);
        }
    }
}
