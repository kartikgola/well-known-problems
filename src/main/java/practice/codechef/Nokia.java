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

public class Nokia {

    private int[] min = new int[31];
    private int[] max = new int[31];

    private int calcDistance(int k, int n) {
        return k <= n ? k + n + 1 - k : 0;
    }

    private int calcTotalDistance(int k, int n) {
        if ( k > n )
            return 0;
        return calcDistance(k, n) + calcTotalDistance(1 ,k - 1) + calcTotalDistance(1, n - k);
    }

    private void calcMinMaxWireUsage() {
        for ( int n = 1; n <= 30; ++n ) {
            int mid = n / 2;
            min[n] = min[mid] + min[n - mid - 1] + n + 1;
            max[n] = max[n - 1] + max[0] + n + 1;
        }
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        calcMinMaxWireUsage();

        while ( t-- > 0 ) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());

            if ( m < min[n] )
                System.out.println(-1);
            else if ( m <= max[n] )
                System.out.println(0);
            else
                System.out.println(m - max[n]);
        }
    }
}
