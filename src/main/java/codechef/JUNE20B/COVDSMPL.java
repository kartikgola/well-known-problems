/*
 * Author: Kartik Gola
 * Date: 11/06/20, 2:57 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package codechef.JUNE20B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class COVDSMPL {

    class Range {
        short i;
        short j;
        short k;
        short l;

        Range(short i, short j, short k, short l) {
            this.i = i;
            this.j = j;
            this.k = k;
            this.l = l;
        }

        Range[] half() {
            if ( k - i == 0 && l - j == 0 )
                return null;
            if ( k - i > 0 )
                return new Range[]{
                        new Range(i, j, (short)((i + k) / 2), l),
                        new Range((short)(((i + k) / 2) + 1), j, k, l)
                };
            else
                return new Range[]{
                        new Range(i, j, k, (short)((j + l) / 2)),
                        new Range(i, (short)(((j + l) / 2) + 1), k, l)
                };
        }
        
        short size() {
            return (short)((k - i + 1) * (l - j + 1));
        }
    }

    private BufferedReader br;

    private Short query(Range r) throws Exception {
        System.out.printf("1 %d %d %d %d\n", r.i + 1, r.j + 1, r.k + 1, r.l + 1);
        return Short.parseShort(br.readLine());
    }

    private void print(boolean[][] grid) {
        System.out.println("2");
        for ( short i = 0; i < grid.length; ++i ) {
            for ( short j = 0; j < grid[0].length; ++j ) {
                System.out.print(grid[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    private void updateGrid(Range r, boolean[][] grid, boolean value) {
        for ( int i = r.i; i <= r.k; ++i ) {
            for ( int j = r.j; j <= r.l; ++j ) {
                grid[i][j] = value;
            }
        }
    }

    private boolean canContinue() throws Exception {
        return Integer.parseInt(br.readLine()) != -1;
    }

    public void solve() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        short t = Short.parseShort(br.readLine());

        while ( t-- > 0 ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            final short n = Short.parseShort(st.nextToken());
            final short p = Short.parseShort(st.nextToken());
            boolean[][] grid = new boolean[n][n];
            Short[][][][] map = new Short[n][n][n][n];

            short sum = -1; // Stores sum of previous range
            Stack<Range> stk = new Stack<>();
            stk.push(new Range((short)0, (short)0, (short)(n - 1), (short)(n - 1)));

            while ( !stk.empty() ) {
                Range r = stk.pop();
                Short q = map[r.i][r.j][r.k][r.l];
                if ( q == null ) // get it from user
                    q = map[r.i][r.j][r.k][r.l] = query(r);

                if ( q == -1 )
                    throw new Exception(); // To give NZEC instead of WA in OJ

                if ( sum == -1 )
                    sum = q;
                else if ( !stk.empty() ) {
                    Range pk = stk.peek();
                    // set the sum of previous range to `sum - q`
                    map[pk.i][pk.j][pk.k][pk.l] = (short)(sum - q);
                    sum = -1;
                }

                if ( q != 0 ) {
                    // size of range is equal to number of 1s it contains
                    if ( q == r.size() ) {
                        updateGrid(r, grid, true);
                        sum = -1;
                    } else {
                        sum = q;
                        Range[] halves = r.half();
                        if ( halves != null ) {
                            stk.push(halves[1]);
                            stk.push(halves[0]);
                        }
                    }
                } else {
                    updateGrid(r, grid, false);
                    sum = -1;
                }
            }

            print(grid);
            if ( !canContinue() )
                throw new Exception(); // To give NZEC instead of WA in OJ
        }
    }
}
