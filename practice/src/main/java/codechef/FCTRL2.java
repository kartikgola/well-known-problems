/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FCTRL2 {

    public void solve() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        int n;
        while ( t-- > 0 ) {
            n = Integer.parseInt(reader.readLine());
            BigInteger fact = BigInteger.ONE;
            while ( n-- > 0 ) fact = fact.multiply(BigInteger.valueOf(n + 1));
            System.out.println(fact);
        }
    }
}
