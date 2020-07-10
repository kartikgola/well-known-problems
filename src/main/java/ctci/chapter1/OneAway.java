/*
 * Author: Kartik Gola
 * Date: 25/06/20, 11:11 AM
 * Copyright (c) 2020 | https://rattl.io
 */

package ctci.chapter1;

public class OneAway {

    public boolean oneAway(String s1, String s2) {
        int diff = Math.abs(s1.length() - s2.length());
        if ( diff > 1 ) return false;
        if ( s1.isEmpty() || s2.isEmpty() ) return true;

        int i = 0, j = 0;
        int edits = 0;
        while ( i < s1.length() && j < s2.length() ) {
            if ( s1.charAt(i) == s2.charAt(j) ) {
                ++i;
                ++j;
                continue;
            } else if ( s1.length() == s2.length() ) {
                ++i; ++j; // Case of replacing the character
            } else {
                // Case of removing/inserting the character
                if ( s1.length() > s2.length() )
                    ++i;
                else
                    ++j;
            }
            ++edits;
        }

        return edits < 2;
    }
}
