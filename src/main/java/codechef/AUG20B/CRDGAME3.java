/*
 * Author: Kartik Gola
 * Date: 8/13/20 10:39 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://www.codechef.com/AUG20B/problems/CRDGAME3
 */

package codechef.AUG20B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CRDGAME3 {

    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while ( t-- > 0 ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if ( Math.ceil(r / 9.0) <= Math.ceil(c / 9.0) )
                System.out.println("1 " + (int)Math.ceil(r / 9.0));
            else
                System.out.println("0 " + (int)Math.ceil(c / 9.0));
        }
    }
}
