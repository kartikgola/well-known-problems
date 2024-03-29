/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Name of the class has to be "Main" only if the class is public. */
public class PLAYSTR {
	public void solve() throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while ( t-- > 0 ) {
            int n = Integer.parseInt(br.readLine());
            String a = br.readLine();
            String b = br.readLine();
            int count = 0;
            
            for ( int i = 0; i < a.length(); ++i ) {
                if ( a.charAt(i) != b.charAt(i) )
                    ++count;
            }
            
            System.out.println(count % 2 == 0 ? "YES" : "NO");
        }
	}
}
