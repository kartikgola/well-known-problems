/*
 * Author: Kartik Gola
 * Date: 02/07/20, 2:00 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class WordBreak2 {

    Set<String> set = new HashSet<>();
    Map<Integer, List<String>> map = new HashMap<>();

    private List<String> wordBreak(String s, int i) {
        List<String> res = new ArrayList<>();
        if ( i == s.length() ) {
            res.add( "" );
            return res;
        }

        if ( map.containsKey(i) )
            return map.get(i);

        for ( int j = i + 1; j <= s.length(); ++j ) {
            String str = s.substring(i, j);
            if ( set.contains(str) ) {
                List<String> al = wordBreak(s, j);
                // We can't directly modify `al` as it is linked with another value in Map
                // So, we create a copy of `al` and do modifications in that
                List<String> newAl = new ArrayList<>();
                if ( al.size() > 0 ) {
                    for ( int k = 0; k < al.size(); ++k )
                        newAl.add( str + (al.get(k).isEmpty() ? "" : " " + al.get(k)) );
                    res.addAll(newAl);
                }

            }
        }

        map.put(i, res);
        return res;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        for ( String wd: wordDict )
            set.add( wd );
        return wordBreak(s, 0);
    }
}
