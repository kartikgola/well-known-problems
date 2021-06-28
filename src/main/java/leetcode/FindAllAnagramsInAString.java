/*
 * Author: Kartik Gola
 * Date: 02/08/20, 1:00 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int left = 0, right = 0;
        final int n = s.length();

        Map<Character, Integer> map = new HashMap<>();
        for ( Character ch : p.toCharArray() )
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        int req = map.size();
        while ( right < n ) {
            char ch = s.charAt(right);
            if ( map.containsKey(ch) ) {
                map.put(ch, map.get(ch) - 1);
                if ( map.get(ch) == 0 )
                    --req;
            }
            ++right;
            while ( req == 0 ) {
                ch = s.charAt(left);
                if ( map.containsKey(ch) ) {
                    map.put(ch, map.get(ch) + 1);
                    if ( map.get(ch) > 0 )
                        ++req;
                }
                // Only consider current window as potential candidate, if its length is equals to length of `p`
                if ( right - left == p.length() )
                    ans.add(left);
                ++left;
            }
        }

        return ans;
    }
}
