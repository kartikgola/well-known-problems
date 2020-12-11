/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package foobar;

public class DoomsdayFuel {

    public static void print(Fraction[][] A) {
        for ( Fraction[] fr: A ) {
            for ( Fraction f: fr ) {
                System.out.print(f + " ");
            }
            System.out.println();
        }
    }

    public static void subtractFromI(Fraction[][] A) {
        for ( int i = 0; i < A.length; ++i ) {
            for ( int j = 0; j < A[0].length; ++j ) {
                if ( i == j ) {
                    A[i][j] = (new Fraction(1)).subtract(A[i][j]);
                } else {
                    A[i][j] = (new Fraction(0)).subtract(A[i][j]);
                }
            }
        }
    }

    public static void getCofactorMat(Fraction[][] A, Fraction[][] t, int p, int q, int n) {
        int i = 0, j = 0;
        // Looping for each element of the matrix
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != p && col != q) {
                    t[i][j++] = new Fraction(A[row][col].n, A[row][col].d);
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    public static Fraction getDeterminant(Fraction[][] cf, int n) {
        Fraction d = new Fraction(0);
        if ( n == 1 ) {
            return cf[0][0];
        }

        Fraction[][] t = new Fraction[n][n];
        Fraction mult = new Fraction(1);

        for ( int i = 0; i < n; ++i ) {
            getCofactorMat(cf, t, 0, i, n);
            d = d.add(mult.multiply(cf[0][i].multiply(getDeterminant(t, n - 1))));
            mult = (new Fraction(-1)).multiply(mult);
        }

        return d;
    }

    public static Fraction[][] getAdjoint(Fraction[][] A)  {
        final int n = A.length;
        Fraction[][] cf = new Fraction[n][n];
        Fraction[][] adj = new Fraction[n][n];
        if ( n == 1 ) {
            return new Fraction[][]{{ new Fraction(1) }};
        }
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++) {
                getCofactorMat(A, cf, i, j, n);
                adj[j][i] = new Fraction((((i + j) % 2 == 0) ? 1 : -1)).multiply(getDeterminant(cf, n - 1));
            }
        }
        return adj;
    }

    public static Fraction[][] getInverse(Fraction[][] A) {
        final int n = A.length;
        Fraction d = getDeterminant(A, n);
        Fraction[][] inv = new Fraction[n][n];
        if ( d.n != 0 ) {
            Fraction[][] adj = getAdjoint(A);
            for ( int i = 0; i < n; ++i ) {
                for ( int j = 0; j < n; ++j ) {
                    inv[i][j] = adj[i][j].divide(d);
                }
            }
        }
        return inv;
    }

    public static Fraction[][] multiplyMat(Fraction[][] A, Fraction[][] B) {
        final int r1 = A.length;
        final int c2 = B[0].length;
        final int r2 = B.length;
        Fraction[][] res = new Fraction[r1][c2];

        for ( int i = 0; i < r1; i++ ) {
            for ( int j = 0; j < c2; j++ ) {
                res[i][j] = new Fraction(0);
                for ( int k = 0; k < r2; k++ ) {
                    res[i][j] = res[i][j].add(A[i][k].multiply(B[k][j]));
                }
            }
        }

        return res;
    }

    public static int[] solution(int[][] m) {
        if ( m.length == 1 )
            return new int[]{1, 1};

        final int n = m.length;
        Fraction[][] trans = new Fraction[n][n];
        boolean[] abs = new boolean[n];
        int[] seq = new int[n];

        // Find all absorbing/terminal/unreachable states
        // State i will be absorbing if Aii = 1 OR Aij = 0 for all j
        for ( int i = 0; i < n; ++i ) {
            int sum = 0;
            for ( int j = 0; j < n; ++j ) {
                sum += m[i][j];
            }
            // Check if it is absorbing
            if ( sum == 0 || sum == m[i][i] ) {
                m[i][i] = 1;
                abs[i] = true;
            }
        }

        // Re-arrange the transition matrix to canonical form
        // Move up absorbing states
        int absCount = 0;
        for ( int i = 0; i < n; ++i ) {
            if ( abs[i] ) {
                for ( int j = 0; j < n; ++j ) {
                    if ( absCount == j ) {
                        trans[absCount][j] = new Fraction(1);
                    } else {
                        trans[absCount][j] = new Fraction(0);
                    }
                }
                seq[absCount] = i;
                absCount++;
            }
        }

        // Define the sequence of states
        int otherCount = absCount;
        for ( int i = 0; i < n; ++i ) {
            if ( !abs[i] ) {
                seq[otherCount++] = i;
            }
        }
        otherCount = absCount;

        // Move down other states
        // Say, seq = [2, 3, 4, 5, 0 1]
        for ( int i = 0; i < n; ++i ) {
            if ( !abs[i] ) {
                int sum = 0;
                for ( int j = 0; j < n; ++j ) {
                    sum += m[i][seq[j]];
                }
                for ( int j = 0; j < n; ++j ) {
                    trans[otherCount][j] = new Fraction( m[i][seq[j]], sum );
                }
                otherCount++;
            }
        }

        // Take Q, which is bottom right of the matrix
        Fraction[][] Q = new Fraction[n - absCount][n - absCount];
        for ( int i = absCount; i < n; ++i ) {
            for ( int j = absCount; j < n; ++j ) {
                Q[i - absCount][j - absCount] = new Fraction(trans[i][j].n, trans[i][j].d);
            }
        }

        // Take R, which is bottom right of the matrix
        Fraction[][] R = new Fraction[n - absCount][absCount];
        for ( int i = absCount; i < n; ++i ) {
            for ( int j = 0; j < absCount; ++j ) {
                R[i - absCount][j] = new Fraction(trans[i][j].n, trans[i][j].d);
            }
        }

        // Set Q = I - Q
        subtractFromI(Q);

        // Calculate inverse of Q
        Fraction[][] F = getInverse(Q);

        // Multiply F & R
        Fraction[][] FR = multiplyMat(F, R);

        // Calculate the final result
        int[] res = new int[FR[0].length + 1];
        long lcm = 1L;
        for ( int j = 0; j < FR[0].length; ++j ) {
            if ( FR[0][j].d != 0 ) {
                lcm = Fraction.lcm(lcm, FR[0][j].d);
            }
        }
        for ( int j = 0; j < FR[0].length; ++j ) {
            if ( FR[0][j].d != 0 ) {
                res[j] = (int) (FR[0][j].n * (lcm / FR[0][j].d));
            }
        }
        res[res.length - 1] = (int) lcm;
        return res;
    }
}
