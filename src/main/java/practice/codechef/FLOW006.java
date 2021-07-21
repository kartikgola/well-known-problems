/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.codechef;

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
