/*
 * Author: Kartik Gola
 * Date: 02/08/20, 1:51 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/permutation-in-string/
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for ( Character ch : s1.toCharArray() )
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        int req = map.size();
        int left = 0, right = 0;
        final int n = s2.length();

        while ( right < n ) {
            char ch = s2.charAt(right);
            if ( map.containsKey(ch) ) {
                map.put(ch, map.get(ch) - 1);
                if ( map.get(ch) == 0 )
                    --req;
            }
            ++right;

            while ( req == 0 ) {
                ch = s2.charAt(left);
                if ( map.containsKey(ch) ) {
                    map.put(ch, map.get(ch) + 1);
                    // We've found a valid char & now we need to remove it from window if its count is > 0
                    // If all counts of these char is removed, we need to increment our requirement as well
                    if ( map.get(ch) > 0 ) {
                        ++req;
                        // Return true only if window size is equal to `s1.length()`
                        if ( right - left == s1.length() )
                            return true;
                    }
                }
                ++left;
            }
        }

        return false;
    }
}
