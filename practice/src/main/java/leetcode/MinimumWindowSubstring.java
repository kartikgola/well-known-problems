/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        String ans = "";
        // Store the counts of each char in 't'
        Map<Character, Integer> charMap = new HashMap<>();
        for ( Character ch : t.toCharArray() )
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);

        final int n = s.length();
        int left = 0, right = 0;
        // Count of unique required characters
        int required = charMap.size();

        while ( right < n ) {
            char rightChar = s.charAt(right);
            if ( charMap.containsKey(rightChar) ) {
                // Decrease the count, if we find any valid char in 's'
                int count = charMap.get(rightChar);
                charMap.put(rightChar, count - 1);
                if ( count - 1 == 0 )
                    --required;
            }
            ++right;

            // We've got a possible candidate at this point
            // as required number of characters are == 0
            // So, we loop until we require no more characters
            while ( required == 0 ) {
                // Check if current candidate's length is greater than last found candidate
                if ( ans.isEmpty() || right - left < ans.length() ) {
                    ans = s.substring(left, right);
                }

                // Now, we need to minimise our window, to make it minimum possible
                // As we move left pointer towards right, we increase the count of
                // all valid chars(those that are present in 't') found so far
                char leftChar = s.charAt(left);
                if ( charMap.containsKey(leftChar) ) {
                    int count = charMap.get(leftChar);
                    charMap.put(leftChar, count + 1);
                    if ( count + 1 > 0 )
                        ++required;
                }
                ++left;
            }
        }

        return ans;
    }
}
