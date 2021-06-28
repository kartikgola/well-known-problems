/*
 * Author: Kartik Gola
 * Date: 09/03/2021, 20:20
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/strobogrammatic-number/
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        // Create a map for mirror images of numbers
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put('1', '1');
            put('6', '9');
            put('9', '6');
            put('8', '8');
            put('0', '0');
        }};

        for (int i = 0, j = num.length() - 1; i <= j; --j) {
            if (!map.containsKey(num.charAt(j)) || num.charAt(i++) != map.get(num.charAt(j)))
                return false;
        }

        return true;
    }
}
