/*
 * Author: Kartik Gola
 * Date: 8/13/20 11:06 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL:
 */

package practice.codechef.AUG20B;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SKMP {

    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while ( t-- > 0 ) {
            String s = br.readLine();
            String p = br.readLine();

            StringBuilder ans = new StringBuilder();
            int[] sMap = new int[26];
            int[] pMap = new int[26];

            // ccad, cad
            // cadc < ccad

            for ( char ch : s.toCharArray() )
                sMap[ch - 'a']++;

            for ( char ch : p.toCharArray() )
                pMap[ch - 'a']++;

            for ( int i = 0; i < sMap.length; ++i ) {
                while ( (i + 'a') <= p.charAt(0) && sMap[i] > pMap[i] ) {
                    ans.append((char)(i + 'a'));
                    sMap[i]--;
                }
                if ( pMap[i] > 0 )
                    sMap[i] -= pMap[i];
            }
            ans.append(p);
            for ( int i = 0; i < sMap.length; ++i ) {
                while ( sMap[i] > 0 ) {
                    ans.append((char)(i + 'a'));
                    sMap[i]--;
                }
            }

            System.out.println(ans.toString());
        }
    }
}
