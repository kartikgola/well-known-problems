/*
 * Author: Kartik Gola
 * Date: 8/2/20 12:33 AM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL:
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        final int n = s.length();
        final int m = words.length;
        if ( m == 0 ) return ans;
        final int k = words[0].length();

        Map<String, Integer> map = new HashMap<>();
        for ( String word : words )
            map.put(word, map.getOrDefault(word, 0) + 1);
        Map<String, Integer> rem = new HashMap<>(map);

        for ( int i = 0; i < n - (m * k) + 1; ++i ) {
            String str = s.substring(i, i + m * k);
            int match = 0;
            for ( int j = 0; j < str.length(); j += k ) {
                String wd = str.substring(j, j + k);
                if ( rem.getOrDefault(wd, 0) > 0 ) {
                    rem.put(wd, rem.get(wd) - 1);
                    ++match;
                } else
                    break;
            }
            if ( match > 0 ) {
                if ( match == m )
                    ans.add(i);
                for ( Map.Entry<String, Integer> e : map.entrySet() )
                    rem.put(e.getKey(), e.getValue());
            }
        }

        return ans;
    }
}
