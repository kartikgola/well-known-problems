/*
 * Author: Kartik Gola
 * Date: 8/15/21, 8:00 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.atcoder.abc178;

import java.util.Arrays;

import static util.IOUtils.*;

public class TaskE {

    public static void main(String[] args) throws Exception {
        int n = nextInt();
        long[] x = new long[n];
        long[] y = new long[n];
        for (int i = 0; i < n; ++i) {
            x[i] = nextLong();
            y[i] = nextLong();
        }
        long[] max = new long[4];
        Arrays.fill(max, Integer.MIN_VALUE);
        long[] min = new long[4];
        Arrays.fill(min, Integer.MAX_VALUE);
        int[][] k = new int[][]{{1,1}, {1,-1}, {-1,1}, {-1,-1}};

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 4; j++) {
                long val = x[i] * k[j][0] + y[i] * k[j][1];
                max[j] = Math.max(max[j], val);
                min[j] = Math.min(min[j], val);
            }
        }

        long ans = 0;
        for (int i = 0; i < 4; ++i) {
            ans = Math.max(ans, max[i] - min[i]);
        }
        System.out.println(ans);
    }
}
