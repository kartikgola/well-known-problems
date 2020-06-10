/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | rattl.io
 */

package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RSIGNS {

    private long PRIME_MOD = 1000_000_007L;

    private long fastPow(long base, long exp) {
        long res = 1;
        while ( exp > 0 ) {
            if ( exp % 2 == 0 ) {
                base = (base * base) % PRIME_MOD;
                exp = exp / 2;
            } else {
                res = (res * base) % PRIME_MOD;
                base = (base * base) % PRIME_MOD;
                exp = exp / 2;
            }
        }
        return res;
    }

    private long getCount(final long k) {
        return (fastPow(2, k - 1) * 10) % PRIME_MOD;
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while ( t-- > 0 ) {
            long k = Long.parseLong(reader.readLine());
            System.out.println(getCount(k));
        }
    }
}
