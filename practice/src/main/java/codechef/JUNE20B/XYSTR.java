/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef.JUNE20B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class XYSTR {

    public void solve() throws IOException {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tkn;
        int t = Integer.parseInt(rdr.readLine());

        while ( t-- > 0 ) {
            String str = rdr.readLine();
            int cnt = 0;
            char need = '\u0000';
            for ( int i = 0; i < str.length(); ++i ) {
                if ( need == '\u0000' ) {
                    need = str.charAt(i);
                } else if ( str.charAt(i) != need ) {
                    cnt++;
                    need = '\u0000';
                }
            }

            System.out.println(cnt);
        }
    }
}
