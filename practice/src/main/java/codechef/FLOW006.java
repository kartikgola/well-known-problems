/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FLOW006 {

    public void solve() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while ( t-- > 0 ) {
            String n = reader.readLine();
            int sum = 0;

            for ( int i = 0; i < n.length(); ++i ) {
                sum = sum + Character.getNumericValue(n.charAt(i));
            }

            System.out.println(sum);
        }
    }
}
