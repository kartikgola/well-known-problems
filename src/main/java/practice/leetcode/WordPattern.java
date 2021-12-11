/*
 * Author: Kartik Gola
 * Date: 12/11/21, 4:39 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        Set<String> used = new HashSet<>();
        Map<Character, String> map = new HashMap<>();

        int i = 0, j = 0;
        while (i < pattern.length() && j < str.length) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                String val = map.get(ch);
                if (!val.equals(str[j]))
                    return false;
                i++;
                j++;
            } else {
                if (!used.contains(str[j])) {
                    used.add(str[j]);
                    map.put(ch, str[j]);
                    i++;
                    j++;
                } else return false;
            }
        }

        return i == pattern.length() && j == str.length;
    }
}
