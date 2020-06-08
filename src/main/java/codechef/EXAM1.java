package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EXAM1 {

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int t = Integer.parseInt(reader.readLine());

        while ( t-- > 0 ) {
            tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            String correct = reader.readLine();
            String resp = reader.readLine();

            boolean evaluate = true;
            int score = 0;
            for ( int i = 0; i < n; ++i ) {
                if ( evaluate ) {
                    if ( resp.charAt(i) == 'N' ) {
                        score += 0;
                    } else if ( resp.charAt(i) == correct.charAt(i) ) {
                        score += 1;
                    } else {
                        evaluate = false;
                    }
                } else {
                    evaluate = true;
                }
            }

            System.out.println(score);
        }
    }
}
