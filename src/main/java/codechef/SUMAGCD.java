package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Complete this problem
// Currently fails at 2 test cases (unknown)
public class SUMAGCD {

    private static long[] readArray(BufferedReader reader, int n, String delim) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), delim);
        long[] arr = new long[n];
        int i = 0;
        while ( tokenizer.hasMoreTokens() ) {
            arr[i++] = Long.parseLong(tokenizer.nextToken());
        }
        return arr;
    }

    private long gcd(long a, long b) {
        long t;
        while ( a != 0 ) {
            t = a;
            a = b % a;
            b = t;
        }
        return b;
    }

    private long gcdSum(long[] A) {
        final int n = A.length;
        long g1 = A[0], g2 = A[1];
        long[] t = new long[6];
        long x, y, z, max;

        for ( int i = 2; i < n; ++i ) {
            t[0] = gcd(g1, A[i]);
            t[1] = g2;
            x = t[0] + t[1];

            t[2] = gcd(g2, A[i]);
            t[3] = g1;
            y = t[2] + t[3];

            t[4] = gcd(g1, g2);
            t[5] = A[i];
            z = t[4] + t[5];

            max = Math.max(x, Math.max(y, z));
            if ( max == x ) {
                g1 = t[0];
                g2 = t[1];
            } else if ( max == y ) {
                g1 = t[2];
                g2 = t[3];
            } else {
                g1 = t[4];
                g2 = t[5];
            }
        }
        return g1 + g2;
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while ( t-- > 0 ) {
            int n = Integer.parseInt(reader.readLine());
            System.out.println(gcdSum(readArray(reader, n, " ")));
        }
    }
}
