/*
 * Author: Kartik Gola
 * Date: 11/06/20, 2:57 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package codechef.JUNE20B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class COVDSMPL {

    private BufferedReader br;

    private Integer query(int x1, int y1, int x2, int y2) throws Exception {
        System.out.printf("1 %d %d %d %d\n", x1, y1, x2, y2);
        return Integer.parseInt(br.readLine());
    }

    private void print(boolean[][] grid) {
        System.out.println("2");
        for ( int i = 0; i < grid.length; ++i ) {
            for ( int j = 0; j < grid[0].length; ++j ) {
                System.out.print(grid[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    public void solve() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while ( t-- > 0 ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            final int n = Integer.parseInt(st.nextToken());
            final int p = Integer.parseInt(st.nextToken());
            final int m = n * n;
            boolean[][] grid = new boolean[n][n];

            int i = 0, j = 0, k = m - 1, l = m - 1;
            final int total = query(i + 1, j + 1, k + 1, l + 1);

//            while (  ) {
//                if (  )
//            }
        }
    }
}
