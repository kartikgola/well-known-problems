/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Map;
import java.util.TreeMap;

public class IntegerToRoman {

    public String intToRoman(int num) {
        TreeMap<Integer, String> map = new TreeMap<Integer, String>(){{
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(9, "IX");
            put(10, "X");
            put(40, "XL");
            put(50, "L");
            put(90, "XC");
            put(100, "C");
            put(400, "CD");
            put(500, "D");
            put(900, "CM");
            put(1000, "M");
        }};

        StringBuilder ans = new StringBuilder();
        while (num > 0) {
            int digits = (int)Math.floor(Math.log10(num)) + 1;
            int tens = (int) Math.pow(10, digits - 1);
            int x = num;
            if (tens > 1) {
                x = num / tens;
                x *= tens;
            }
            Map.Entry<Integer, String> floorEntry = map.floorEntry(x);
            int count = 0;
            for (int y = x; y >= floorEntry.getKey(); y -= floorEntry.getKey()) {
                ans.append(floorEntry.getValue());
                count++;
            }
            num -= floorEntry.getKey() * count;
        }

        return ans.toString();
    }
}
