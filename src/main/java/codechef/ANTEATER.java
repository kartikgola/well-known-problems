/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Complete this code
// Doesn't work yet.
public class ANTEATER {

    private static boolean isMovePossible(int r, int c, int i, int j) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }

    private static int[] nextMove(String[][] g, int i, int j) {
        int k, l;
        final String move = g[i][j];
        if ( move.equals("U") ) {
            k = i - 1;
            l = j;
        } else if ( move.equals("R") ) {
            k = i;
            l = j + 1;
        } else if ( move.equals("D") ) {
            k = i + 1;
            l = j;
        } else {
            k = i;
            l = j - 1;
        }
        return new int[]{k, l};
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int t = Integer.parseInt(reader.readLine());

        while ( t-- > 0 ) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int r = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());

            String[][] g = new String[r][c];
            String[][] a = g.clone();

            for ( int i = 0; i < r; ++i ) {
                tokenizer = new StringTokenizer(reader.readLine(), "");
                for ( int j = 0; j < c; ++j ) {
                    g[i][j] = tokenizer.nextToken();
                }
            }

            boolean updated = true;
            while ( updated ) {
                for ( int i = 0; i < r; ++i ) {
                    for ( int j = 0; j < c; ++j ) {
                        if ( !g[i][j].equals("#") && !g[i][j].equals("-") ) {
                            final int[] m = nextMove(g, i, j);
                            if ( isMovePossible(r, c, m[0], m[1]) ) {
                                if ( g[m[0]][m[1]].equals("#") ) {
                                    a[m[0]][m[1]] = "";
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
