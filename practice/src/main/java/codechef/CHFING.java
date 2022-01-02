/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CHFING {

    private int MOD = 1000_000_007;

    private long getUnreachableCount(long n, long k) {
        long min = k, max = k + n - 1;
        long count = (min - 1) % MOD,
             match = 0,
             current = max + 1;
        HashSet<Long> set = new HashSet<>();

        while ( true ) {
            long i = min;
            for ( ; i <= max; ++i ) {
                if ( ( min <= (current - i) && (current - i) <= max) || set.contains( current - i ) ) {
                    ++match;
                    set.add(current);
                    break;
                }
            }

            if ( i > max ) {
                ++count;
                match = 0;
                if ( count > MOD )
                    count = count % MOD;
            } else {
                if ( match == min )
                    break;
            }

            ++current;
        }

        return count;
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while ( t-- > 0 ) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            long n = Long.parseLong(tokenizer.nextToken());
            long k = Long.parseLong(tokenizer.nextToken());
            System.out.println(getUnreachableCount(n, k));
        }
    }
}
