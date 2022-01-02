/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for ( int j = 0; j < t.length() && i < s.length(); ++j ) {
            if ( s.charAt(i) == t.charAt(j) ) {
                ++i;
            }
        }
        return i == s.length();
    }

}
