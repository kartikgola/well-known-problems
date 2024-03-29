/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;

public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        if ( A.length() == B.length() && A.length() > 1 ) {
            int[] aMap = new int[26];
            int[] bMap = new int[26];
            int misplaced = 0;
            boolean multiple = false;
            for ( int i = 0; i < A.length(); ++i ) {
                aMap[A.charAt(i) - 'a']++;
                bMap[B.charAt(i) - 'a']++;
                misplaced += A.charAt(i) != B.charAt(i) ? 1 : 0;
                if ( misplaced > 2 )
                    return false;
                if ( !multiple && (aMap[A.charAt(i) - 'a'] > 1 || bMap[B.charAt(i) - 'a'] > 1) )
                    multiple = true;
            }
            if ( Arrays.equals(aMap, bMap) ) {
                if ( misplaced == 2 )
                    return true;
                return multiple;
            }
        }
        return false;
    }
}
