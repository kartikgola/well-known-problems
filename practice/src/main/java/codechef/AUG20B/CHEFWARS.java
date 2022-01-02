/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef.AUG20B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHEFWARS {

    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while ( t-- > 0 ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            while ( h > 0 && p > 0 ) {
                h = h - p;
                p = p / 2;
            }
            if ( h <= 0 )
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
