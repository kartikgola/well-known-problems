/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    private List<List<String>> groupAnagrams(String[] strs) {
        if ( strs.length == 0 ) return new ArrayList<>();
        final int n = strs.length;

        Map<String, List> map = new HashMap<>();
        char[] chKey;
        String key;
        final int aCode = 'a';
        for ( String s : strs ) {
            chKey = new char[26];
            for ( int i = 0; i < s.length(); ++i ) {
                ++chKey[s.charAt(i) - aCode];
            }
            key = String.valueOf(chKey);

            if ( map.containsKey(key) ) {
                map.get(key).add(s);
            } else {
                ArrayList<String> al = new ArrayList<>();
                al.add(s);
                map.put(key, al);
            }
        }

        return new ArrayList(map.values());
    }

}
