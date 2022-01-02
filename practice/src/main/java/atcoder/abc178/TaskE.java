/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package atcoder.abc178;

import java.util.Arrays;

import static util.IOUtils.*;

public class TaskE {

    public void solve() throws Exception {
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

    // Editorial - https://img.atcoder.jp/abc178/editorial-E-en.pdf
    public void solve2() throws Exception {
        int n = nextInt();
        long zmax = Long.MIN_VALUE,
             zmin = Long.MAX_VALUE,
             wmax = Long.MIN_VALUE,
             wmin = Long.MAX_VALUE;

        while (n-- > 0) {
            long x = nextLong(), y = nextLong();
            zmax = Math.max(zmax, x+y);
            zmin = Math.min(zmin, x+y);
            wmax = Math.max(wmax, x-y);
            wmin = Math.min(wmin, x-y);
        }
        System.out.println(Math.max(zmax-zmin, wmax-wmin));
    }

    public static void main(String[] args) throws Exception {
        new TaskE().solve2();
    }
}
