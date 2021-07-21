/*
 * Author: Kartik Gola
 * Date: 6/27/21, 5:45 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package practice.codechef.START5B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHEFQUER {

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        long[] arr = new long[n+1];

        st = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= n; ++i) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        while (q-- > 0) {
            st = new StringTokenizer(reader.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                int l = Integer.parseInt(st.nextToken()),
                    r = Integer.parseInt(st.nextToken()),
                    x = Integer.parseInt(st.nextToken());

                for (int i = l; i <= r; ++i) {
                    long val = x + i - l;
                    arr[i] += val * val;
                }
            } else {
                System.out.println(arr[Integer.parseInt(st.nextToken())]);
            }
        }
    }
}
