package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PROXYC {

    private int getMinimumProxy(char[] attendance, final int n) {
        float present = 0;
        for ( char ch : attendance ) {
            if ( ch == 'P' ) ++present;
        }

        float attended = present / n;
        if ( attended >= 0.75 ) return 0;

        float proxies = 0;

        for ( int i = 2; i < n - 2; ++i ) {
            if ( attendance[i] == 'A' ) {
                if ((attendance[i - 1] == 'P' || attendance[i - 2] == 'P') && (attendance[i + 1] == 'P' || attendance[i + 2] == 'P')) {
                    ++proxies;
                    attended = (present + proxies) / n;
                    if ( attended >= 0.75 ) return (int) proxies;
                }
            }
        }

        return -1;
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while ( t-- > 0 ) {
            final int n = Integer.parseInt(reader.readLine());
            System.out.println(getMinimumProxy(reader.readLine().toCharArray(), n));
        }
    }
}
