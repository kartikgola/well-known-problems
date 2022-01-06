/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class StrobogrammaticNumber {

    // Map of mirror images of numbers
    Map<Character, Character> map = new HashMap<Character, Character>(){{
        put('1', '1');
        put('6', '9');
        put('9', '6');
        put('8', '8');
        put('0', '0');
    }};

    public boolean isStrobogrammatic(String num) {
        if (num.isEmpty())
            return false;
        if (num.length() > 1 && num.startsWith("0"))
            return false;
        for (int i = 0, j = num.length() - 1; i <= j; --j) {
            if (!map.containsKey(num.charAt(j)) || num.charAt(i++) != map.get(num.charAt(j)))
                return false;
        }
        return true;
    }

    // sister-code to generate all strobogrammatic numbers of length n
    private List<String> _generateStrobo(int n) {
        if (n == 0)
            return Collections.emptyList();
        if (n == 1)
            return Arrays.asList("0", "1", "8");
        List<String> ans = new ArrayList<>();
        for (Map.Entry<Character, Character> e: map.entrySet()) {
            char ch1 = e.getKey();
            char ch2 = e.getValue();
            List<String> sub = _generateStrobo(n-2);
            if (sub.isEmpty())
                ans.add(ch1 + "" + ch2);
            else {
                for (String mid : sub) {
                    ans.add(ch1 + mid + ch2);
                }
            }
            if (n >= 3)
                ans.add(ch1 + "0".repeat(n-2) + ch2);
        }
        return ans;
    }

    public List<String> generateStrobo(int n) {
        return _generateStrobo(n).stream()
                .filter(x -> x.length() == 1 || !x.startsWith("0"))
                .collect(Collectors.toList());
    }
}
