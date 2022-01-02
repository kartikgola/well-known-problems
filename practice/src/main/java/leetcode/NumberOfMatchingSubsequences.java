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

public class NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {
        // Example, if words[] = ["c", "cat", "com", "dog"]
        // map = {c=["", "at", "om"], d="og"}
        Map<Character, List<String>> map = new HashMap<>();
        for (String wd: words) {
            map.putIfAbsent(wd.charAt(0), new ArrayList<>());
            map.get(wd.charAt(0)).add(wd.substring(1));
        }

        int ans = 0;
        for (char ch: s.toCharArray()) {
            if (map.containsKey(ch)) {
                List<String> vals = map.remove(ch);
                for (String v: vals) {
                    if (v.isEmpty())
                        ans++;
                    else {
                        map.putIfAbsent(v.charAt(0), new ArrayList<>());
                        map.get(v.charAt(0)).add(v.substring(1));
                    }
                }
            }
        }

        return ans;
    }
}
