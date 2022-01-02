/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

    public String fractionToDecimal(int num, int den) {
        if (num % den == 0)
            return Integer.toString(num / den);
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        String suffix = null;
        boolean period = false;
        int p = -1;

        int t = 0;
        while (t++ < 10) {
            final int q = num / den;
            final int r = num % den;
            suffix = String.valueOf(q);
            if (q == 0 && !period) {
                period = true;
                suffix = sb.length() == 0 ? "0." : ".";
            }
            sb.append(suffix);
            if (r == 0)
                break;
            if (p != q && period) {
                if (map.containsKey(r)) {
                    sb.insert(map.get(r), "(")
                            .append(")");
                    break;
                }
                map.put(r, sb.length());
            }
            p = q;
            num = period ? r * 10 : r;
        }

        return sb.toString();
    }
}
