/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MAXDIFF {

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while ( t-- > 0 ) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            int n = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());

            ArrayList<Integer> arrayList = new ArrayList<>(n);
            tokenizer = new StringTokenizer(reader.readLine(), " ");

            for ( int i = 0; i < n; ++i )
                arrayList.add(Integer.parseInt(tokenizer.nextToken()));

            arrayList.sort(Comparator.naturalOrder());

            long sumOfFirstK = 0L, sumOfLastK = 0L;
            long sumOfLastNMinusK = 0L, sumOfFirstNMinusK = 0L;// 1 2 10
            for ( int i = 0; i < k; ++i )
                sumOfFirstK += arrayList.get(i);

            for ( int i = k; i < n; ++i )
                sumOfLastNMinusK += arrayList.get(i);

            for ( int i = n - 1; i >= n - k; --i )
                sumOfLastK += arrayList.get(i);

            for ( int i = n - k - 1; i >= 0; --i )
                sumOfFirstNMinusK += arrayList.get(i);

            final long firstDiff = Math.abs(sumOfFirstK - sumOfLastNMinusK);
            final long secondDiff = Math.abs(sumOfLastK - sumOfFirstNMinusK);

            System.out.println(Math.max(firstDiff, secondDiff));
        }
    }
}
