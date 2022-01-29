/*
 * Author: Kartik Gola
 * Date: 1/29/22, 1:48 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupShiftedStrings {

    private String getJumpHash(String s) {
        StringBuilder sb = new StringBuilder(s.length()-1);
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); ++i) {
            char curr = s.charAt(i);
            int diff = curr - prev;
            if (diff < 0)
                diff = 26 + diff;
            sb.append((char)diff);
            prev = curr;
        }
        return sb.toString();
    }

    public List<List<String>> groupStrings(String[] strings) {
        /*
        * Two or more strings belong to the same group if -
        * 1. Length of strings is same
        * 2. The sequence of 'jump' values from one character to next is same for all the strings
        *   Example
        *          Group 1
        *          "acf" has sequence of jumps as a+2 => c, c+3 => f; Sequence = [2,3]
        *          "xzc" has sequence of jumps as x+2 => z, z+3 => c; Sequence = [2,3]
        *
        *          Group 2
        *          "abc" has sequence of jumps as a+1 => b, b+1 => c; Sequence = [1,1]
        *   For fast lookup, we need to generate a hash value of Sequence.
        *   A simple approach is to make hash as comma-separated join of Sequence array like "2,3"
        *   However, we can map the sequence numbers to a string of chars since any sequence number belongs to [0, 25]
        *   So, [2,3] becomes "cd"
        *
        * For storage, we can use map<str_len, map<jump_hash_sequence, str[]>>
        * */
        Map<Integer, Map<String, List<String>>> map = new HashMap<>();
        for (String s: strings) {
            int len = s.length();
            map.putIfAbsent(len, new HashMap<>());
            final String key = getJumpHash(s);
            map.get(len).putIfAbsent(key, new ArrayList<>());
            map.get(len).get(key).add(s);
        }

        return map.values().stream()
                .flatMap(x -> x.values().stream())
                .collect(Collectors.toList());
    }
}
