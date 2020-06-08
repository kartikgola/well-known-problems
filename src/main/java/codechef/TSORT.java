package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TSORT {

    public void solve() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        int[] a = new int[t];

        for ( int i = 0; i < t; ++i ) {
            a[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(a);

        for ( int i = 0; i < t; ++i ) {
            System.out.println(a[i]);
        }
    }
}
